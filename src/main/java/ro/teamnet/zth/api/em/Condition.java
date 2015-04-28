package ro.teamnet.zth.api.em;

/**
 * Created by Adina Radu on 4/28/2015.
 */
public class Condition {

    private String columnName;
    private  Object value;

    public String getColumnName() {
        return columnName;
    }

    public Object getValue() {
        return value;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
