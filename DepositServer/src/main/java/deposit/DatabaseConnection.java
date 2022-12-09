package deposit;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private String driverName;
    private Connection connect;
    private Statement statement;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void setDriverName(String driverName) throws ClassNotFoundException {
        this.driverName = driverName;
        Class.forName(this.driverName);
    }

    public void initConnection(String url, String name, String pass) throws SQLException {
        this.connect = DriverManager.getConnection(url, name, pass);
        this.statement = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        this.statement.execute("set character set utf8");
        this.statement.execute("set names utf8");
    }

    public void insert(String sqlString) {
        try {
            statement.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String sqlString) {
        try {
            statement.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String sqlString) {
        try {
            statement.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet select(String sqlString) {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void close() {
        try {
            connect.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
