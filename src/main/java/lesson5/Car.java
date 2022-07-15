package lesson5;

public class Car {
    private String mark;
    private String model;
    private String year;
    private String color;
    private double price;
    private int registerNumber;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Car(String mark, String model, String year, String color, double price, int registerNumber) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registerNumber = registerNumber;
    }
}
