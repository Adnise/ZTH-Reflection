package ro.teamnet.zth.api.database;

import junit.framework.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Adina Radu on 4/29/2015.
 */
public class DBManagerTest {

    @Test
    public void testGetConnection() {
        System.out.println("Testing DBManager.getConnection()... ");

        Connection connection = DBManager.getConnetion();
        Assert.assertNotNull("Connection Failed!", connection);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckConnection() {
        Connection connection = DBManager.getConnetion();
        Assert.assertTrue(DBManager.checkConnection(connection));

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

