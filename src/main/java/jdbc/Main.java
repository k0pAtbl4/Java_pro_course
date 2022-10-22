package jdbc;

import jdbc.dbWorker.Repository;
import jdbc.entity.Order;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Repository r = new Repository();
        Order test = r.findByNumber(2);
        System.out.println(test);
        System.out.println(r.ordersThatContainProduct("window"));
        System.out.println(r.ordersThatDontContainProductToday("window"));
        System.out.println(r.sumLessThanGivenAmountEqualsToGiven(10000000, 2));
        r.newOrderFromTodayProducts();
        r.deleteOrderWithProductOfAmount("window", 8);
    }
}
