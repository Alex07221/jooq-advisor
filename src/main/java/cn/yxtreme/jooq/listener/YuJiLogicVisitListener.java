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
 * <p>
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
    private final BaseFieldConfig.DeleteField deleteField;

    public YuJiLogicVisitListener(Class<?> tablesClass, BaseFieldConfig.DeleteField deleteField) {
        super(tablesClass);
        this.deleteField = deleteField;
    }

    void push(VisitContext context) {
        tableStack(context);
        conditionStack(context);
        whereStack(context);
    }

    void pop(VisitContext context) {
        whereStack(context).pop();
        conditionStack(context).pop();
        tableStack(context).pop();

    }

    private SingleStack<List<Table>> tableStack(VisitContext context) {
        SingleStack<List<Table>> data = (SingleStack<List<Table>>) context.data("tables");

        if (data == null) {
            data = new SingleStack<>(new ArrayList<>());
            context.data("tables", data);
        }

        return data;
    }

    private SingleStack<List<Condition>> conditionStack(VisitContext context) {
        SingleStack<List<Condition>> data = (SingleStack<List<Condition>>) context.data("conditions");

        if (data == null) {
            data = new SingleStack<>(new ArrayList<>());
            context.data("conditions", data);
        }

        return data;
    }

    private SingleStack<Boolean> whereStack(VisitContext context) {
        SingleStack<Boolean> data = (SingleStack<Boolean>) context.data("predicates");

        if (data == null) {
            data = new SingleStack<>(false);
            context.data("predicates", data);
        }

        return data;
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
                    if (!tableStack(context).data().contains(table)) {

                        // acquire logic field
                        f = table.field(deleteField.getDeleted());

                        // it must only have one of alias name or the original name
                        if (clauses.contains(TABLE_ALIAS) && ORIGINAL_TABLE_NAMES.contains(table.getName())) {
                            f = null;
                        } else {
                            tableStack(context).data().add(table);
                            break;
                        }
                    }
                }
            }


            var condition = f == null ? null : f.eq(false);

            if (condition != null && !conditionStack(context).data().contains(condition)) {
                conditionStack(context).data().add(condition);
            }
        }
    }


    @Override
    public void clauseStart(VisitContext context) {

        // Enter a new SELECT clause
        if (context.clause() == SELECT) {
            push(context);
        }
    }

    @Override
    public void clauseEnd(VisitContext context) {
        // Append all collected predicates to the WHERE clause if any
        if (context.clause() == SELECT_WHERE) {
            List<Condition> conditions = conditionStack(context).data();

            if (conditions.size() > 0) {
                context.context()
                        .formatSeparator()
                        .keyword(whereStack(context).data() ? "and" : "where")
                        .sql(' ');

                context.context().visit(DSL.condition(Operator.AND, conditions));
            }
        }

        // Leave a SELECT clause
        if (context.clause() == SELECT) {
            pop(context);
        }
    }

    @Override
    public void visitEnd(VisitContext context) {
        pushConditions(context);

        if (context.queryPart() instanceof Condition) {
            List<Clause> clauses = clauses(context);

            if (clauses.contains(SELECT_WHERE)) {
                whereStack(context).refresh(true);
            }
        }
    }
}
