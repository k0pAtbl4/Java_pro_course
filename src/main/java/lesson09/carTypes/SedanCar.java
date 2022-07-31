package lesson09.carTypes;

public class SedanCar extends Car {
    private boolean fourDoored;
    private boolean doubleDoored;

    public SedanCar(double maxSpeed, double price, double weight, String model, String color,
                    double fuelConsumption, boolean fourDoored) {
        super(maxSpeed, price, weight, model, color, fuelConsumption);
        this.fourDoored = fourDoored;
        doubleDoored = !fourDoored;
    }

    @Override
    public String toString() {
        return "Max speed: " + getMaxSpeed() + "\nPrice: " + getPrice() +
                "\nWeight: " + getWeight() + "\nModel: " + getModel() +
                "\nColor: " + getColor() + "\nFuel consumption: " + getFuelConsumption() +
                "\nFour doored: " + fourDoored + "\nDouble doored: " + doubleDoored + "\n";
    }

    public boolean isFourDoored() {
        return fourDoored;
    }

    public void setFourDoored(boolean fourDoored) {
        this.fourDoored = fourDoored;
    }

    public boolean isDoubleDoored() {
        return doubleDoored;
    }

    public void setDoubleDoored(boolean doubleDoored) {
        this.doubleDoored = doubleDoored;
    }
}
