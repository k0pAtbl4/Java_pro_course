package lesson9;

import lesson9.carTypes.Car;
import lesson9.carTypes.FreightCar;
import lesson9.carTypes.SedanCar;
import lesson9.carTypes.SportCar;
import lesson9.service.CarPark;

public class Main {
    public static void main(String[] args) {
        double maxAllowedSpeed = 230;
        double minSpeed = 110;
        Car[] cars = new Car[4];
        cars[0] = new FreightCar(160, 20000, 56000, "mark 8", "white", 30, 16000, 4.6);
        cars[1] = new SedanCar(220, 15000, 2300, "lancer 10", "black", 15, true);
        cars[2] = new SportCar(310, 67000, 1200, "challenger src hellcat", "black", 45, true);
        cars[3] = new SedanCar(230, 93500, 1800, "e-tron 10", "black", 0, true);
        CarPark park = new CarPark(cars);

        System.out.println("Not sorted array of cars:\n");
        printCars(cars);

        System.out.println("Sorted array of cars:\n");
        printCars(park.fuelConsumptionSort());

        System.out.println("Cars that fit the range (" + minSpeed + " - " + maxAllowedSpeed + " km/h):\n");
        Car[] fitsTheRange = park.fitsRange(minSpeed, maxAllowedSpeed);
        printCars(fitsTheRange);

        System.out.println("Car park cost: " + park.parkCost());
    }

    public static void printCars(Car[] car) {
        for (Car iterator : car) {
            System.out.println(iterator);
        }
    }
}
