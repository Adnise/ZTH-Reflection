package ro.teamnet.zth.api.em;

import java.util.List;

/**
 * Created by Adina Radu on 4/29/2015.
 */
public class QueryBuilder {

    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public QueryBuilder addCondition(Condition conditions) {
        this.conditions.add(conditions);
        return this;
    }

    public QueryBuilder setTableName(Object tableName) {
        this.tableName = tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns) {
        this.queryColumns.addAll(queryColumns);
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType) {
        this.queryType = queryType;
        return this;
    }

    private String createSelectQuery() {
        StringBuilder str = new StringBuilder();
        str.append("SELECT ");

        for (int i = 0; i < queryColumns.size() - 1; i++) {
            str.append(queryColumns.get(i).getDbName());
            str.append(",");
        }

        str.append("FROM ");
        str.append(tableName.toString());

        str.append("WHERE ");
        for (int i = 0; i < conditions.size() - 1; i++) {
            str.append(conditions.get(i).getColumnName());
            str.append(" = ");
            if (conditions.get(i).getValue() instanceof String)
                str.append("'").append(conditions.get(i).getValue().toString()).append("'");
            else
                str.append(conditions.get(i).getValue().toString());
            str.append(" AND ");
        }
        str.append(conditions.get(conditions.size() - 1).getColumnName());
        str.append(" = ");
        str.append(conditions.get(conditions.size() - 1).getValue().toString());
        str.append(";");

        return str.toString();
    }

    private String createUpdateQuery() {
        StringBuilder str = new StringBuilder();
        str.append("UPDATE ");

        str.append(tableName.toString());
        str.append("SET ");

        for (int i = 0; i < queryColumns.size() - 1; i++) {
            str.append(queryColumns.get(i).getDbName());
            str.append(" = ");
            str.append(queryColumns.get(i).getValue());
            str.append(", ");
        }
        str.append(queryColumns.get(queryColumns.size() - 1).getDbName());
        str.append(" = ");
        str.append(queryColumns.get(queryColumns.size() - 1).getValue());

        str.append("WHERE ");
        for (int i = 0; i < conditions.size() - 1; i++) {
            str.append(conditions.get(i).getColumnName());
            str.append(" = ");
            if (conditions.get(i).getValue() instanceof String)
                str.append("'").append(conditions.get(i).getValue().toString()).append("'");
            else
                str.append(conditions.get(i).getValue().toString());
            str.append(" AND ");
        }
        str.append(conditions.get(conditions.size() - 1).getColumnName());
        str.append(" = ");
        str.append(conditions.get(conditions.size() - 1).getValue().toString());
        str.append(";");
        return str.toString();
    }
    private String createInsertQuery() {
        StringBuilder str = new StringBuilder();
        str.append("INSERT INTO ");

        str.append(tableName.toString()).append("\n");

        str.append(" (");
        for (int i = 0; i < queryColumns.size() - 1; i++) {
            str.append(queryColumns.get(i).getDbName());
            str.append(", ");
        }
        str.append(queryColumns.get(queryColumns.size() - 1).getDbName());
        str.append(")");

        str.append(" VALUES (");
        for (int i = 0; i < queryColumns.size() - 1; i++) {
            str.append(queryColumns.get(i).getValue());
            str.append(", ");
        }
        str.append(queryColumns.get(queryColumns.size() - 1).getValue());
        str.append(");");

        return str.toString();
    }

    private String createDeleteQuery() {
        StringBuilder str = new StringBuilder();
        str.append("DELETE FROM ");

        // Add table name
        str.append(tableName.toString()).append("\n");

        // Add conditions
        str.append("WHERE ");
        for (int i = 0; i < conditions.size() - 1; i++) {
            str.append(conditions.get(i).getColumnName());
            str.append(" = ");
            if (conditions.get(i).getValue() instanceof String)
                str.append("'").append(conditions.get(i).getValue().toString()).append("'");
            else
                str.append(conditions.get(i).getValue().toString());
            str.append(" AND ");
        }
        str.append(conditions.get(conditions.size() - 1).getColumnName());
        str.append(" = ");
        str.append(conditions.get(conditions.size() - 1).getValue().toString());
        str.append(";");

        return str.toString();
    }

    public String createQuery() {
        if (queryType == QueryType.SELECT)
            return createSelectQuery();
        else if (queryType == QueryType.UPDATE)
            return createUpdateQuery();
        else if (queryType == QueryType.INSERT)
            return createInsertQuery();
        else if (queryType == QueryType.DELETE)
            return createDeleteQuery();
        else
            return null;
    }
}
