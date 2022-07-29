package lesson9.service;

import lesson9.carTypes.Car;

public interface CarParkFunctions {
    double parkCost();

    Car[] fuelConsumptionSort();

    Car[] fitsRange(double maxSpeedAllowed);
}
