package cn.yxtreme.jooq.generate;

import cn.yxtreme.jooq.model.BasePO;
import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

/**
 * @author xuzebiao
 * @version 1.0.0
 * @date 2021/7/26
 * @remark
 */
public class YuJiGeneratorStrategy extends DefaultGeneratorStrategy {

    private static final Class<BasePO> BASE_TABLE_CLASS = BasePO.class;

    @Override
    public String getJavaClassExtends(Definition definition, Mode mode) {
        if (mode.equals(Mode.POJO)) {
            return BASE_TABLE_CLASS.getName();
        }
        return super.getJavaClassExtends(definition, mode);
    }


    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        if (mode.equals(Mode.POJO)) {
            return super.getJavaClassName(definition, mode) + "PO";
        }
        return super.getJavaClassName(definition, mode);
    }

}
