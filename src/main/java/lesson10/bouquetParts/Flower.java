package lesson10.bouquetParts;

public class Flower implements Comparable<Flower> {
    private String name;
    private int days;
    private int price;
    private int stemLength;

    public Flower(String name, int days, int price, int steamLength) {
        this.name = name;
        this.days = days;
        this.price = price;
        this.stemLength = steamLength;
    }

    public Flower() {
    }

    @Override
    public String toString() {
        return "[ Name: " + name + "\tDays left: " + days + "\tPrice: " + price + "\tStem length: " + stemLength + " ]";
    }

    @Override
    public int compareTo(Flower o) {
        return this.days - o.days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSteamLength() {
        return stemLength;
    }

    public void setSteamLength(int steamLength) {
        this.stemLength = steamLength;
    }
}
