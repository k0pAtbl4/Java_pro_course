package lesson09.service;

import lesson09.carTypes.Car;
import lesson09.carTypes.FreightCar;
import lesson09.carTypes.SedanCar;
import lesson09.carTypes.SportCar;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CarParkTest {

    @Test
    public void testParkCost() {
        double expectedCost = 195500.0;
        Car[] cars = new Car[4];
        cars[0] = new FreightCar(160, 20000, 56000, "mark 8", "white", 30, 16000, 4.6);
        cars[1] = new SedanCar(220, 15000, 2300, "lancer 10", "black", 15, true);
        cars[2] = new SportCar(310, 67000, 1200, "challenger src hellcat", "black", 45, true);
        cars[3] = new SedanCar(230, 93500, 1800, "e-tron 10", "black", 0, true);
        CarPark park = new CarPark(cars);
        assertEquals(park.parkCost(), expectedCost);
    }

    @Test
    public void testFuelConsumptionSort() {
        Car[] cars = new Car[4];
        cars[0] = new FreightCar(160, 20000, 56000, "mark 8", "white", 30, 16000, 4.6);
        cars[1] = new SedanCar(220, 15000, 2300, "lancer 10", "black", 15, true);
        cars[2] = new SportCar(310, 67000, 1200, "challenger src hellcat", "black", 45, true);
        cars[3] = new SedanCar(230, 93500, 1800, "e-tron 10", "black", 0, true);
        CarPark park = new CarPark(cars);
        Car[] sortedArray = {cars[3], cars[1], cars[0], cars[2]};
        assertEquals(park.fuelConsumptionSort(), sortedArray);
    }

    @Test
    public void testFitsRange() {
        Car[] cars = new Car[4];
        cars[0] = new FreightCar(160, 20000, 56000, "mark 8", "white", 30, 16000, 4.6);
        cars[1] = new SedanCar(220, 15000, 2300, "lancer 10", "black", 15, true);
        cars[2] = new SportCar(310, 67000, 1200, "challenger src hellcat", "black", 45, true);
        cars[3] = new SedanCar(230, 93500, 1800, "e-tron 10", "black", 0, true);
        CarPark park = new CarPark(cars);
        Car[] expectedArray = {cars[0], cars[1], cars[3]};
        double maxSpeedAllowed = 230.0;
        double minSpeed = 110.0;
        assertEquals(park.fitsRange(minSpeed, maxSpeedAllowed), expectedArray);
    }
}