package cn.yxtreme.jooq.listener;

import cn.yxtreme.jooq.model.BaseFieldConfig;
import cn.yxtreme.jooq.utils.SingleStack;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.Clause.*;

/**
 * It's listener about join the logic deleted condition for jooq
 *
 * TODO wait for jooq version update to replace the ${@link Clause}
 *
 * @author: Alex
 * @since: 2021/7/28
 */
@Slf4j
public class YuJiLogicVisitListener extends BaseVisitListener {

    /**
     * Here are some stack for recoding which we already process.
     */
    private static SingleStack<List<Table>> tablesSingleStack;
    private static SingleStack<List<Condition>> conditionsSingleStack;
    private static SingleStack<Boolean> whereSingleStack;
    private final BaseFieldConfig.DeleteField deleteField;

    public YuJiLogicVisitListener(Class<?> tablesClass, BaseFieldConfig.DeleteField deleteField) {
        super(tablesClass);
        this.deleteField = deleteField;
    }

    @Override
    void push() {
        tablesSingleStack = new SingleStack(new ArrayList<Table>());
        conditionsSingleStack = new SingleStack(new ArrayList<Condition>());
        whereSingleStack = new SingleStack(false);
    }


    @Override
    void pop() {
        tablesSingleStack.pop();
        conditionsSingleStack.pop();
        whereSingleStack.pop();
    }

    void pushConditions(VisitContext context) {

        List<Clause> clauses = clauses(context);

        // enter a SELECT_FROM clause
        if (clauses.contains(SELECT_FROM)) {
            Field f = null;
            QueryPart[] parts = context.queryParts();
            for (int i = parts.length - 2; i >= 0; i--) {

                if (parts[i] instanceof Table) {

                    var table = ((Table<?>) parts[i]);
                    if (!tablesSingleStack.data().contains(table)) {

                        // acquire logic field
                        f = table.field(deleteField.getDeleted());

                        // it must only have one of alias name or the original name
                        if (clauses.contains(TABLE_ALIAS) && ORIGINAL_TABLE_NAMES.contains(table.getName())) {
                            f = null;
                        } else {
                            tablesSingleStack.data().add(table);
                            break;
                        }
                    }
                }
            }


            var condition = f == null ? null : f.eq(false);

            if (condition != null && !conditionsSingleStack.data().contains(condition)) {
                conditionsSingleStack.data().add(condition);
            }
        }
    }


    @Override
    public void clauseStart(VisitContext context) {

        // Enter a new SELECT clause
        if (context.clause() == SELECT) {
            push();
        }
    }

    @Override
    public void clauseEnd(VisitContext context) {
        // Append all collected predicates to the WHERE clause if any
        if (context.clause() == SELECT_WHERE) {
            List<Condition> conditions = conditionsSingleStack.data();

            if (conditions.size() > 0) {
                context.context()
                        .formatSeparator()
                        .keyword(whereSingleStack.data() ? "and" : "where")
                        .sql(' ');

                context.context().visit(DSL.condition(Operator.AND, conditions));
            }
        }

        // Leave a SELECT clause
        if (context.clause() == SELECT) {
            pop();
        }
    }

    @Override
    public void visitEnd(VisitContext context) {
        pushConditions(context);

        if (context.queryPart() instanceof Condition) {
            List<Clause> clauses = clauses(context);

            if (clauses.contains(SELECT_WHERE)) {
                whereSingleStack.refresh(true);
            }
        }
    }
}
