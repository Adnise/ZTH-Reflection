package ro.teamnet.zth.api.database;

/**
 * Created by Adina Radu on 4/29/2015.
 */
public interface DBProperties {
    String IP = "127.0.0.1";
    String PORT = "3306";
    String SCHEMA = "ZTH_18";
    String USER = "zth";
    String PASS = "parola";
    String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    boolean IS_ORACLE = false;
    boolean IS_MYSQL = true;


}
