package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adina Radu on 4/28/2015.
 */
public class EntityUtilsTest {


    @Test
    public void testGetTableNameMethod() {
        Department department = new Department();
        String tableName = EntityUtils.getTableName(Department.class);
        Assert.assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetColumns() {
        List<ColumnInfo> expectedColumns = new ArrayList<ColumnInfo>();

        ColumnInfo column;
        column = new ColumnInfo();
        column.setColumnName("id");
        column.setColumnType(Long.class);
        column.setDbName("department_id");
        column.setIsId(true);
        expectedColumns.add(column);

        column = new ColumnInfo();
        column.setColumnName("departmentName");
        column.setColumnType(Long.class);
        column.setDbName("department_name");
        column.setIsId(false);
        expectedColumns.add(column);

        column = new ColumnInfo();
        column.setColumnName("location");
        column.setColumnType(Long.class);
        column.setDbName("location_id");
        column.setIsId(false);
        expectedColumns.add(column);

        List<ColumnInfo> columns = EntityUtils.getColumns(Department.class);
        Assert.assertEquals("Incorrect number of columns!", columns.size(), expectedColumns.size());
    }

    @Test
    public void testCastFromSqlType() {
        BigDecimal bigDecimal = new BigDecimal(1234);
        Assert.assertEquals("Returned type should be Integer!", EntityUtils.castFromSqlType(bigDecimal, Integer.class).getClass(), Integer.class);
    }

    @Test
    public void testGetFieldsByAnnotations() {
        List<Field> expectedFields = new ArrayList<Field>();
        try {
            expectedFields.add(Department.class.getDeclaredField("departmentName"));
            expectedFields.add(Department.class.getDeclaredField("location"));
        } catch (Exception e) {
            System.err.println("Caught Exception: " + e.getMessage());
        }
    }
}
