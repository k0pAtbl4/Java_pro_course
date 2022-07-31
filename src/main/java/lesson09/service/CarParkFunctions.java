package lesson09.service;

import lesson09.carTypes.Car;

public interface CarParkFunctions {
    double parkCost();
    Car[] fuelConsumptionSort();
    Car[] fitsRange(double minSpeed, double maxSpeedAllowed);
}
