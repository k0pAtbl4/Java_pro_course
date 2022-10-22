package lesson17.shopWorker;

import lesson17.dbService.RequestProcessor;
import lesson17.shop.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Service {
    public LinkedList<Order> orders;

    public Service(Order[] orders) {
        this.orders = new LinkedList<>();
        this.orders.addAll(Arrays.asList(orders));
    }

    /*private List<Order> getOrders(String requestByOrderNumber, String[] parameters) throws SQLException {
        Connection connection = RequestProcessor.getConnection("jdbc:mysql://localhost:3306/test", "root", "1qaz2wsxzxcZ1");
        ResultSet resultSet = executeRequestForDB(connection, requestByOrderNumber, parameters);
        return processResultSetCreateFullObjectOrder(connection, resultSet);
    }*/

    private ResultSet executeRequestForDB(Connection connection, String query, String[] parameters) {
        ResultSet resultSet = null;

        if (connection == null) {
            return null;
        }
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    statement.setString(i + 1, parameters[i]);
                }
            }
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.err.println("Can not execute query:" + e.getMessage());

        }
        return resultSet;
    }

    /*private List<Order> processResultSetCreateFullObjectOrder(Connection connection, ResultSet resultSet) {
        if (resultSet == null) {
            return null;
        }
        List<Order> orders = new ArrayList<>();
        List<OrderNomenclature> orderNomenclatures = null;
        Order order = null;
        int orderPrev = 0;
        int orderCurrent = 0;
        int nomenclatureId = 0;
        try {
            while (resultSet.next()) {
                orderCurrent = resultSet.getInt("order_id");
                nomenclatureId = resultSet.getInt("nomenclature_id");

                if (orderPrev != orderCurrent) {
                    if (orderPrev != 0) {
                        order.setOrderNomenclatures(orderNomenclatures);
                    }
                    LocalDate localDate = Date.valueOf(resultSet.getString("date")).toLocalDate();
                    order = new Order(localDate, resultSet.getString("number"), resultSet.getInt("order_id"));
                    orders.add(order);
                    orderNomenclatures = new ArrayList<>();
                    orderPrev = orderCurrent;
                }
                if (nomenclatureId == 0) {
                    continue;
                }
                Nomenclature nomenclature = new Nomenclature(nomenclatureId, resultSet.getString("name"), resultSet.getString("description"), resultSet.getDouble("price"));
                orderNomenclatures.add(new OrderNomenclature(nomenclature, resultSet.getDouble("count")));
            }
            if (orderCurrent != 0 && orderNomenclatures.size() != 0) {
                order.setOrderNomenclatures(orderNomenclatures);
            }

        } catch (SQLException e) {
            System.err.println("Can't read resultSet:" + e.getMessage());
        } finally {
            closeConnection(connection);
        }
        return orders;

    }*/
}
