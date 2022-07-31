package lesson09.carTypes;

public class SportCar extends Car {
    private boolean backEngine;
    private boolean frontEngine;

    public SportCar(double maxSpeed, double price, double weight, String model, String color,
                    double fuelConsumption, boolean backEngine) {
        super(maxSpeed, price, weight, model, color, fuelConsumption);
        this.backEngine = backEngine;
        this.frontEngine = !backEngine;
    }

    @Override
    public String toString() {
        return "Max speed: " + getMaxSpeed() + "\nPrice: " + getPrice() +
                "\nWeight: " + getWeight() + "\nModel: " + getModel() +
                "\nColor: " + getColor() + "\nFuel consumption: " + getFuelConsumption() +
                "\nEngine on the back: " + backEngine + "\nEngine in the front: " + frontEngine + "\n";
    }

    public boolean isBackEngine() {
        return backEngine;
    }

    public void setBackEngine(boolean backEngine) {
        this.backEngine = backEngine;
    }

    public boolean isFrontEngine() {
        return frontEngine;
    }

    public void setFrontEngine(boolean frontEngine) {
        this.frontEngine = frontEngine;
    }
}
