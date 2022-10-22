package lesson17.shop;

import java.util.Objects;

public class Order {
    Product[] products;
    String date;
    int id;
    int size;

    public Order(Product[] products, String date, int id) {
        this.products = products;
        this.date = date;
        this.id = id;
        size = products.length;
    }

    public String productInfo() {
        StringBuilder result = new StringBuilder("");
        for(int i = 0; i < size; i++) {
            result.append(products[i]);
        }
        result.append("\n");
        return result.toString();
    }

    public boolean ifProductsSatisfyCondition(double sum, int productAmount) {
        return ((sum >= this.getOrderSum()) && (productAmount == products.length));
    }

    public boolean ifOrderContainsProduct(Product p) {
        for (Product product : products) {
            if (p.equals(product)) {
                return true;
            }
        }
        return false;
    }

    public boolean ifOrderDateEquals (String date) {
        return Objects.equals(this.date, date);
    }

    int getOrderSum() {
        int result = 0;
        for(int i = 0; i < products.length; i++) {
            result += products[i].getPrice();
        }
        return result;
    }

    public Product[] getProducts() {
        return products;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }
}
