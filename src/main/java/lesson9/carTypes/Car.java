package lesson9.carTypes;

public abstract class Car {
    private double maxSpeed;
    private double price;
    private double weight;
    private String model;
    private String color;
    private double fuelConsumption;

    public Car(double maxSpeed, double price, double weight, String model, String color, double fuelConsumption) {
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.weight = weight;
        this.model = model;
        this.color = color;
        this.fuelConsumption = fuelConsumption;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
