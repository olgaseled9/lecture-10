package by.itacademy.javaenterprise.seledtsova.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionToDataBase {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionToDataBase.class);

    static {
        loadDriver();
    }

    private ConnectionToDataBase() {
    }

    public static Connection getConnection() {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("database");
            String url = resource.getString("database.url");
            String user = resource.getString("database.user");
            String password = resource.getString("database.password");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Connection is not available" + e);
        }
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Driver not found " + e);
            throw new RuntimeException(e);
        }
    }
}


