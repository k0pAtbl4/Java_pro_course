package jdbc.dbWorker;

import jdbc.dbInfo.Config;
import jdbc.dbInfo.Const;
import jdbc.dbWorker.ConnectionProvider;
import jdbc.entity.Order;
import jdbc.entity.Product;
import jdbc.entity.ProductInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Repository {
    public Order findByNumber(int number)
            throws SQLException, ClassNotFoundException {
        List<ProductInfo> list = new LinkedList<>();
        String query = "SELECT * FROM shop." + Const.ORDER_TABLE + " WHERE " +
                Const.ORDER_TABLE + ".id = " + number;

        ConnectionProvider cp = new ConnectionProvider();

        Statement st = cp.getDbConnection().createStatement();
        ResultSet resultSet = st.executeQuery(query);

        String orderStr = "";
        String dateStr = "";
        while(resultSet.next()) {
            orderStr = resultSet.getString("order");
            dateStr = resultSet.getString("date");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);

        String[] orderArray = orderStr.split(",");
        for(int i = 0; i < orderArray.length; i++) {
            String productName = orderArray[i];
            int productAmount = 0;

            query = "SELECT * FROM shop." + Const.ITEM_TABLE + " WHERE " +
                    Const.ITEM_TABLE + ".product = '" + productName + "'";
            resultSet = st.executeQuery(query);
            while(resultSet.next()) {
                productAmount = resultSet.getInt("amount");
            }

            query = "SELECT * FROM shop." + Const.PRODUCT_TABLE + " WHERE " +
                    Const.PRODUCT_TABLE + ".name = '" + productName + "'";
            resultSet = st.executeQuery(query);
            String description = "";
            String cost = "";
            while(resultSet.next()) {
                description = resultSet.getString("description");
                cost = resultSet.getString("cost");
            }

            Product p = new Product(productName, description, (int)Integer.parseInt(cost));
            ProductInfo pi = new ProductInfo(number, p, productAmount);
            list.add(pi);
        }
        return new Order(number, list, date);
    }

    public List<Integer> ordersThatContainProduct(String searchedProduct)
            throws SQLException, ClassNotFoundException {
        List<Integer> list = new LinkedList<>();

        String query = "SELECT " + Const.ITEM_TABLE + ".order_number" + " FROM shop." + Const.ITEM_TABLE + " WHERE " +
                Const.ITEM_TABLE + ".product IN ('" + searchedProduct + "')";

        ConnectionProvider cp = new ConnectionProvider();

        Statement st = cp.getDbConnection().createStatement();
        ResultSet resultSet = st.executeQuery(query);

        while(resultSet.next()) {
            list.add(resultSet.getInt("order_number"));
        }
        return list;
    }

    public List<Integer> ordersThatDontContainProductToday(String searchedProduct)
            throws SQLException, ClassNotFoundException {
        List<Integer> list = ordersThatContainProduct(searchedProduct);
        List<Integer> resultList = new LinkedList<>();

        StringBuilder query = new StringBuilder("SELECT " + Const.ORDER_TABLE + ".id" + " FROM shop."
                + Const.ORDER_TABLE + " WHERE ");
        for (Integer integer : list) {
            query.append(Const.ORDER_TABLE + ".id <> ").append(integer).append(" AND");
        }
        query.append(" " + Const.ORDER_TABLE + ".date BETWEEN " +
                "Addtime(Curdate(), '00:00:00') AND Addtime(Curdate(), '23:59:59')");

        ConnectionProvider cp = new ConnectionProvider();

        Statement st = cp.getDbConnection().createStatement();
        ResultSet resultSet = st.executeQuery(query.toString());

        while(resultSet.next()) {
            resultList.add(resultSet.getInt("id"));
        }
        return resultList;
    }

    public List<Integer> sumLessThanGivenAmountEqualsToGiven(int sum, int amount)
            throws SQLException, ClassNotFoundException {
        List<Integer> result = new LinkedList<>();

        String query = "SELECT " + Const.ITEM_TABLE + ".order_number" +
                " FROM shop." + Const.ITEM_TABLE +
                " JOIN " + Const.PRODUCT_TABLE +
                " ON " + Const.ITEM_TABLE + ".product = " + Const.PRODUCT_TABLE + ".name" +
                " GROUP BY order_number" +
                " HAVING SUM(" + Const.PRODUCT_TABLE + ".cost * " + Const.ITEM_TABLE + ".amount) <= " + sum +
                " AND COUNT(DISTINCT " + Const.ITEM_TABLE + ".id) = " + amount;

        ConnectionProvider cp = new ConnectionProvider();

        Statement st = cp.getDbConnection().createStatement();
        ResultSet resultSet = st.executeQuery(query);

        while(resultSet.next()) {
            result.add(resultSet.getInt("order_number"));
        }
        return result;
    }

    public void newOrderFromTodayProducts()
            throws SQLException, ClassNotFoundException {
        String insertToItemTable = "INSERT INTO item_in_order" +
                "(item_in_order.order_number, item_in_order.product, item_in_order.amount) " +
                "SELECT MAX(shop.order_table.id) + 1 AS order_id, " +
                "item_in_order.id, SUM(item_in_order.amount) / 2 " +
                "FROM item_in_order, shop.order_table " +
                "WHERE item_in_order.id IN " +
                "(SELECT DISTINCT item_in_order.order_number FROM shop.order_table " +
                "WHERE shop.order_table.date " +
                "BETWEEN Addtime(Curdate(), '00:00:00') AND Addtime(Curdate(), '23:59:59')) " +
                "GROUP BY item_in_order.id";
        String insertToOrderTable = "INSERT INTO shop.order_table " +
                "(shop.order_table.id, shop.order_table.order, shop.order_table.date) " +
                "SELECT MAX(shop.order_table.id) + 1, shop.order_table.order, CURDATE() " +
                "FROM shop.order_table";

        ConnectionProvider cp = new ConnectionProvider();

        PreparedStatement st1 = cp.getDbConnection().prepareStatement(insertToItemTable);
        PreparedStatement st2 = cp.getDbConnection().prepareStatement(insertToOrderTable);
        st1.executeUpdate();
        st2.executeUpdate();
    }

    public void deleteOrderWithProductOfAmount(String searchedProduct, int amount)
            throws SQLException, ClassNotFoundException {
        String query = "DELETE shop.order_table, item_in_order FROM shop.order_table " +
                "JOIN item_in_order ON shop.order_table.id = item_in_order.order_number " +
                "JOIN product ON item_in_order.product IN (product.name) " +
                "WHERE product.name = '" + searchedProduct + "' " +
                "AND item_in_order.amount = " + amount;

        ConnectionProvider cp = new ConnectionProvider();

        Statement st = cp.getDbConnection().prepareStatement(query);
        st.executeUpdate(query);
    }
}
