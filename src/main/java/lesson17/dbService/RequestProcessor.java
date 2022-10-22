package lesson17.dbService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RequestProcessor {

    public static Connection getConnection(String path, String username, String password) throws SQLException {
        return DriverManager.getConnection(path, username, password);
    }


}
