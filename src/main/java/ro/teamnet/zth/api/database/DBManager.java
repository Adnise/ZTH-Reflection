package ro.teamnet.zth.api.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Adina Radu on 4/29/2015.
 */

public class DBManager {

    public static final String CONNECTION_STRING = "jdbc:mysql://" + DBProperties.IP + "/" + DBProperties.SCHEMA;

    public DBManager() {
        throw new UnsupportedOperationException();
    }

    private static void registerDriver() {
        try {
            Class.forName(DBProperties.DRIVER_CLASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection  getConnection() {
        try {
            Class.forName(DBProperties.DRIVER_CLASS).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
        try{
            DriverManager.getConnection(CONNECTION_STRING, DBProperties.USER, DBProperties.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static  boolean checkConnection(Connection connection){
        try(Statement stmt = connection.createStatement()){
            stmt.execute("SELECT 1 FROM DUAL");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
