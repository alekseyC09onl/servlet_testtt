package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static final String DB_URL = PropertiesReader.getProperties("dbUrl");
    public static final String DB_USER = PropertiesReader.getProperties("dbUser");
    public static final String DB_PASSWORD = PropertiesReader.getProperties("dbPassword");
    public static final String JDBC_DRIVER = PropertiesReader.getProperties("jdbcDriver");

    public ConnectionManager() {
    }

    static {
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection get() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
