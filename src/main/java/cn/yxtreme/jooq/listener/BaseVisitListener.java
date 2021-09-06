package cn.yxtreme.jooq.listener;

import org.jooq.Clause;
import org.jooq.VisitContext;
import org.jooq.impl.DefaultVisitListener;
import org.jooq.impl.TableImpl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.jooq.Clause.SELECT;

/**
 * @author: Alex
 * @since: 2021/8/4
 */
public abstract class BaseVisitListener extends DefaultVisitListener {

    /**
     * Here are table names which we generate by {@link cn.yxtreme.jooq.generate.YujiGenerator}.
     * We will use reflect to find them
     */
    final List<String> ORIGINAL_TABLE_NAMES;

    public BaseVisitListener(Class<?> tablesClass) {
        var fields = tablesClass.getFields();
        ORIGINAL_TABLE_NAMES = new ArrayList<>();
        for (var field : fields) {
            Class<TableImpl> type = (Class<TableImpl>) field.getType();
            try {
                Method method = type.getMethod("getName");
                method.setAccessible(true);
                ORIGINAL_TABLE_NAMES.add((String) method.invoke(type.newInstance()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Retrieve all clauses for the current subSelect level, starting with
     * the last {@link Clause#SELECT}.
     */
    List<Clause> clauses(VisitContext context) {
        List<Clause> result = asList(context.clauses());
        int index = result.lastIndexOf(SELECT);

        if (index > 0) {
            return result.subList(index, result.size() - 1);
        } else {
            return result;
        }
    }

    /**
     * init what we need
     */
    abstract void push();

    /**
     * destroy what we need
     */
    abstract void pop();
}
