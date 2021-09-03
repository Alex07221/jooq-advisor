package cn.yxtreme.jooq.generate;

import cn.yxtreme.jooq.model.BasePO;
import cn.yxtreme.jooq.utils.Streams;
import lombok.extern.slf4j.Slf4j;
import org.jooq.codegen.GeneratorStrategy;
import org.jooq.codegen.JavaGenerator;
import org.jooq.codegen.JavaWriter;
import org.jooq.meta.*;
import org.jooq.tools.StringUtils;

import java.util.*;

import static org.jooq.codegen.GeneratorStrategy.Mode;

/**
 * @author xuzebiao
 * @version 1.0.0
 * @date 2021/7/26
 * @remark
 */
@Slf4j
@SuppressWarnings("all")
public class YujiGenerator extends JavaGenerator {
    private static final Class<BasePO> BASE_TABLE_CLASS = BasePO.class;
    private static final List<String> BASE_TABLE_FIELD_NAME = Streams.streamToList(Arrays.stream(BASE_TABLE_CLASS.getDeclaredFields()), e -> e, e -> e.getName());
    private static boolean isPojo = false;

    private static final <T> List<T> list(T... objects) {
        List<T> result = new ArrayList<>();

        if (objects != null) {
            for (T object : objects) {
                if (object != null && !"".equals(object)) {
                    result.add(object);
                }
            }
        }

        return result;
    }

    @Override
    protected void printClassAnnotations(JavaWriter out, Definition definition, GeneratorStrategy.Mode mode) {
        if (isPojo) {
            out.println("@%s", new Object[]{out.ref("lombok.Data")});
            out.println("@%s", new Object[]{out.ref("lombok.AllArgsConstructor")});
            out.println("@%s", new Object[]{out.ref("lombok.NoArgsConstructor")});
            out.println("@%s", new Object[]{out.ref("lombok.experimental.SuperBuilder")});
            out.println("@%s(chain = true)", new Object[]{out.ref("lombok.experimental.Accessors")});
        }
        super.printClassAnnotations(out, definition, mode);
    }

    @Override
    protected void generatePojo(TableDefinition table, JavaWriter out) {
        isPojo = true;
        generatePojo0(table, out);
        isPojo = false;
    }

    @Override
    protected void generateDaoClassFooter(TableDefinition table, JavaWriter out) {
        super.generateDaoClassFooter(table, out);
        String pType = out.ref(getStrategy().getFullJavaClassName(table, GeneratorStrategy.Mode.POJO));

        for (ColumnDefinition column : table.getColumns()) {
            final String colClass = getStrategy().getJavaClassName(column);
            final String colTypeFull = getJavaType(column.getType(resolver(out)), out);
            final String colType = out.ref(colTypeFull);
            final String colIdentifier = this.ref(getStrategy().getFullJavaIdentifier(column));
            out.tab(1).println("public %s<%s> fetchBy%s(%s<%s> value) {", List.class, pType, colClass, Collection.class, colType);
            out.tab(2).println("return fetch(%s, value.toArray(new %s[value.size()]));", colIdentifier, colType);
            out.tab(1).println("}");
        }
    }

    private String ref(String clazzOrId) {
        return clazzOrId == null ? null : ref(Arrays.asList(clazzOrId)).get(0);
    }

    private List<String> ref(List<String> clazzOrId) {
        return clazzOrId == null ? Collections.emptyList() : clazzOrId;
    }


    private final void generatePojo0(Definition tableOrUDT, JavaWriter out) {
        final String className = getStrategy().getJavaClassName(tableOrUDT, Mode.POJO);
        final String interfaceName = generateInterfaces()
                ? out.ref(getStrategy().getFullJavaClassName(tableOrUDT, Mode.INTERFACE))
                : "";
        final String superName = out.ref(getStrategy().getJavaClassExtends(tableOrUDT, Mode.POJO));
        final List<String> interfaces = out.ref(getStrategy().getJavaClassImplements(tableOrUDT, Mode.POJO));

        if (generateInterfaces())
            interfaces.add(interfaceName);

        printPackage(out, tableOrUDT, Mode.POJO);

        if (tableOrUDT instanceof TableDefinition)
            generatePojoClassJavadoc((TableDefinition) tableOrUDT, out);
        else
            generateUDTPojoClassJavadoc((UDTDefinition) tableOrUDT, out);

        printClassAnnotations(out, tableOrUDT.getSchema(), Mode.POJO);

        if (tableOrUDT instanceof TableDefinition)
            printTableJPAAnnotation(out, (TableDefinition) tableOrUDT);

        int maxLength = 0;
        for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT))
            maxLength = Math.max(maxLength, out.ref(getJavaType(column.getType(resolver(out, Mode.POJO)), out, Mode.POJO)).length());

        out.println("public class %s[[before= extends ][%s]][[before= implements ][%s]] {", className, list(superName), interfaces);

        if (generateSerializablePojos() || generateSerializableInterfaces())
            out.printSerial();

        out.println();

        for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT)) {
            var memberName = getStrategy().getJavaMemberName(column, Mode.POJO);

            if (!BASE_TABLE_FIELD_NAME.contains(memberName)) {
                out.tab(1).println("private %s%s %s;",
                        generateImmutablePojos() ? "final " : "",
                        StringUtils.rightPad(out.ref(getJavaType(column.getType(resolver(out, Mode.POJO)), out, Mode.POJO)), maxLength),
                        memberName);
            }
        }

        // Default constructor
        if (!generateImmutablePojos())
            generatePojoDefaultConstructor(tableOrUDT, out);

        // [#1363] [#7055] copy constructor
        generatePojoCopyConstructor(tableOrUDT, out);

        // Multi-constructor
        generatePojoMultiConstructor(tableOrUDT, out);

        List<? extends TypedElementDefinition<?>> elements = getTypedElements(tableOrUDT);
        for (int i = 0; i < elements.size(); i++) {
            TypedElementDefinition<?> column = elements.get(i);

            if (tableOrUDT instanceof TableDefinition) {
                generatePojoGetter(column, i, out);
            } else {
                generateUDTPojoGetter(column, i, out);
            }

            // Setter
            if (!generateImmutablePojos()) {
                if (tableOrUDT instanceof TableDefinition) {
                    generatePojoSetter(column, i, out);
                } else {
                    generateUDTPojoSetter(column, i, out);
                }
            }
        }

        if (generatePojosEqualsAndHashCode()) {
            generatePojoEqualsAndHashCode(tableOrUDT, out);
        }

        if (generatePojosToString()) {
            generatePojoToString(tableOrUDT, out);
        }

        if (generateInterfaces() && !generateImmutablePojos()) {
            printFromAndInto(out, (TableDefinition) tableOrUDT);
        }

        if (tableOrUDT instanceof TableDefinition) {
            generatePojoClassFooter((TableDefinition) tableOrUDT, out);
        } else {
            generateUDTPojoClassFooter((UDTDefinition) tableOrUDT, out);
        }

        out.println("}");
        closeJavaWriter(out);
    }

    private List<? extends TypedElementDefinition<? extends Definition>> getTypedElements(Definition definition) {
        if (definition instanceof TableDefinition)
            return ((TableDefinition) definition).getColumns();
        else if (definition instanceof EmbeddableDefinition)
            return ((EmbeddableDefinition) definition).getColumns();
        else if (definition instanceof UDTDefinition)
            return ((UDTDefinition) definition).getAttributes();
        else if (definition instanceof RoutineDefinition)
            return ((RoutineDefinition) definition).getAllParameters();
        else
            throw new IllegalArgumentException("Unsupported type : " + definition);
    }

    @Override
    protected void generatePojoDefaultConstructor(Definition tableOrUDT, JavaWriter out) {
    }

    @Override
    protected void generatePojoMultiConstructor(Definition tableOrUDT, JavaWriter out) {
    }

    @Override
    protected void generatePojoCopyConstructor(Definition tableOrUDT, JavaWriter out) {
    }

    @Override
    protected void generatePojoGetter(TypedElementDefinition<?> column, int index, JavaWriter out) {
    }

    @Override
    protected void generatePojoSetter(TypedElementDefinition<?> column, int index, JavaWriter out) {
    }
}
