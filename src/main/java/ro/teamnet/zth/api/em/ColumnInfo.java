package ro.teamnet.zth.api.em;

/**
 * Created by Adina Radu on 4/28/2015.
 */
public class ColumnInfo {
    private String columnName;
    private Class columnType;
    private String dbName;
    private boolean isId;
    private Object value;

    public String getColumnName() {
        return columnName;
    }

    public Class getColumnType() {
        return columnType;
    }

    public String getDbName() {
        return dbName;
    }

    public boolean isId() {
        return isId;
    }

    public Object getValue() {
        return value;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setColumnType(Class columnType) {
        this.columnType = columnType;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setIsId(boolean isId) {
        this.isId = isId;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
