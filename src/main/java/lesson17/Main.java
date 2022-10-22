package lesson17;

import lesson17.dbService.RequestProcessor;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        RequestProcessor proc = new RequestProcessor();
        Connection connection = proc.getConnection("jdbc:mysql://localhost:3306/test", "root", "1qaz2wsxzxcZ1");
        DatabaseMetaData data = connection.getMetaData();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from javalesson");

        while(resultSet.next()) {
            String products = resultSet.getString("products");
            System.out.println(products);
            String date = resultSet.getString("date");
            System.out.println(date);
        }

        connection.close();
    }
}
