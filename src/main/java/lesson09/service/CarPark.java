package lesson09.service;

import lesson09.carTypes.Car;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarPark implements CarParkFunctions {
    private Car[] cars;

    private Car[] fitsRange;

    public CarPark(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public double parkCost() {
        return Arrays.stream(cars).map(Car::getPrice).reduce(Double::sum).orElse(0.0);
    }

    @Override
    public Car[] fuelConsumptionSort() {
        cars = Arrays.stream(cars).sorted(this::compareByFuel).toArray(Car[]::new);
        return cars;
    }

    public int compareByFuel(Car car1, Car car2) {
        return Double.compare(car1.getFuelConsumption(), car2.getFuelConsumption());
    }

    @Override
    public Car[] fitsRange(double minSpeed, double maxSpeedAllowed) {
        return Arrays.stream(cars).filter(car -> car.getMaxSpeed() <= maxSpeedAllowed &&
                car.getMaxSpeed() >= minSpeed).toArray(Car[]::new);
    }

    @Override
    public String toString() {
        return Arrays.stream(cars).map(Object::toString).collect(Collectors.joining(", "));
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public Car[] getFitsRange() {
        return fitsRange;
    }

    public void setFitsRange(Car[] fitsRange) {
        this.fitsRange = fitsRange;
    }
}
