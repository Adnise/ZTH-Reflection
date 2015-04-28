package ro.teamnet.zth.api.em;


import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adina Radu on 4/28/2015.
 */
public class EntityUtils {

    private EntityUtils() {
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity) {
        return ((Table) entity.getAnnotation(Table.class)).name();
    }

    public static List<ColumnInfo> getColumns(Class entity) {
        List<ColumnInfo> columns = new ArrayList<ColumnInfo>();

        //Get all declared fields from class;
        Field[] fields = entity.getDeclaredFields();


        for (Field field : fields) {

            try {
                ColumnInfo columnInfo = new ColumnInfo();
                Column c = field.getAnnotation(Column.class);
                columnInfo.setColumnName(field.getName());
                columnInfo.setColumnType(field.getType());
                columnInfo.setDbName(field.getName());
                columns.add(new ColumnInfo());
            } catch (Exception e) {
                System.err.println("Caught Exception: " + e.getMessage());

            }
            try {
                ColumnInfo columnInfo = new ColumnInfo();
                Id c = field.getAnnotation(Id.class);
                columnInfo.setColumnName(field.getName());
                columnInfo.setColumnType(field.getType());
                columnInfo.setDbName(field.getName());
                columnInfo.setIsId(true);
                columns.add(new ColumnInfo());
            } catch (Exception e) {
                System.err.println("Caught Exception: " + e.getMessage());
            }
        }
        return columns;
    }

    public static Object castFromSqlType(Object value, Class wantedType) {
        if (value instanceof BigDecimal && wantedType == Integer.class)
            return ((BigDecimal) value).intValue();
        else
            return value;
    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation) {
        List<Field> fields = new ArrayList();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if( declaredField.getAnnotation(annotation) != null ){
                fields.add(declaredField);
            }
        }
    return fields;
    }

}





















