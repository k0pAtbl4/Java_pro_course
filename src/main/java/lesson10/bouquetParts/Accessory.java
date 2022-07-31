package lesson10.bouquetParts;

public class Accessory {
    private String name;
    private int price;

    public Accessory(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Accessory() {
    }

    @Override
    public String toString() {
        return "[ Name: " + name + "\tPrice: " + price + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
