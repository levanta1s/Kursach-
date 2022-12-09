import deposit.DatabaseConnection;
import deposit.ThreadServer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestServerWork {

    @Before
    public void setConnection() {
        ThreadServer.setConnection();
    }

    @Test
    public void testSelect() throws SQLException {
        int expectedAmount = 6;
        String query = "select * from deposits";
        ResultSet resultSet = DatabaseConnection.getInstance().select(query);
        int actualAmount = 0;
        while (resultSet.next()) {
            actualAmount++;
        }
        Assert.assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testInsert() throws SQLException {
        int expectedAmount = 9;
        String insertQuery = "insert into contacts VALUES(9,'2018-11-19', 4, 3)";
        DatabaseConnection.getInstance().insert(insertQuery);
        String selectQuery = "select * from contacts";
        ResultSet resultSet = DatabaseConnection.getInstance().select(selectQuery);
        int actualAmount = 0;
        while (resultSet.next()) {
            actualAmount++;
        }
        Assert.assertEquals(expectedAmount, actualAmount);
    }
}
