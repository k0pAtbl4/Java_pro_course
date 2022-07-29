package lesson9.carTypes;

import lesson9.carTypes.Car;

public class FreightCar extends Car {
    private double loadCapacity;
    private double height;

    public FreightCar(double maxSpeed, double price, double weight, String model, String color, double fuelConsumption, double loadCapacity, double height) {
        super(maxSpeed, price, weight, model, color, fuelConsumption);
        this.loadCapacity = loadCapacity;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Max speed: " + getMaxSpeed() + "\nPrice: " + getPrice() +
                "\nWeight: " + getWeight() + "\nModel: " + getModel() +
                "\nColor: " + getColor() + "\nFuel consumption: " + getFuelConsumption() +
                "\nLoad capacity: " + loadCapacity +
                "\nHeight: " + height + "\n";
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
