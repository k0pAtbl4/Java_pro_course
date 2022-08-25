package lesson09.service;

import lesson09.carTypes.Car;
import lesson09.carTypes.FreightCar;
import lesson09.carTypes.SedanCar;
import lesson09.carTypes.SportCar;
import lesson09.fileWork.ReadFromFile;
import lesson09.fileWork.WriteToFile;

import java.util.Arrays;

import static lesson09.Main.printCars;

public class Runner {
    private double maxAllowedSpeed;
    private double minSpeed;

    public Runner(double maxAllowedSpeed, double minSpeed) {
        this.maxAllowedSpeed = maxAllowedSpeed;
        this.minSpeed = minSpeed;
    }

    public void run() {
        ReadFromFile read = new ReadFromFile("D:\\polytechnic\\Java cars.txt");
        WriteToFile write = new WriteToFile("D:\\polytechnic\\Java cars result.txt");

        String oneLine = read.fileRead();
        String[] lines = oneLine.split(";\r\n");

        String[][] carsInStr = new String[lines.length][];
        Car[] cars = new Car[lines.length];

        for (int i = 0; i < lines.length; i++) {
            carsInStr[i] = lines[i].split(", ");
            System.out.println(Arrays.toString(carsInStr[i]));
            switch (carsInStr[i][0]) {
                case "FREIGHT" ->
                        cars[i] = new FreightCar(Double.parseDouble(carsInStr[i][1]), Double.parseDouble(carsInStr[i][2]), Double.parseDouble(carsInStr[i][3]),
                                carsInStr[i][4], carsInStr[i][5], Double.parseDouble(carsInStr[i][6]), Double.parseDouble(carsInStr[i][7]),
                                Double.parseDouble(carsInStr[i][8]));
                case "SEDAN" ->
                        cars[i] = new SedanCar(Double.parseDouble(carsInStr[i][1]), Double.parseDouble(carsInStr[i][2]), Double.parseDouble(carsInStr[i][3]),
                                carsInStr[i][4], carsInStr[i][5], Double.parseDouble(carsInStr[i][6]), Boolean.parseBoolean(carsInStr[i][7]));
                case "SPORT" ->
                        cars[i] = new SportCar(Double.parseDouble(carsInStr[i][1]), Double.parseDouble(carsInStr[i][2]), Double.parseDouble(carsInStr[i][3]),
                                carsInStr[i][4], carsInStr[i][5], Double.parseDouble(carsInStr[i][6]), Boolean.parseBoolean(carsInStr[i][7]));
            }
        }

        CarPark park = new CarPark(cars);

        String toWrite = "";
        toWrite += "Not sorted array of cars:\n\n";
        toWrite += printCars(cars);

        toWrite += "Sorted array of cars:\n\n";
        toWrite += printCars(park.fuelConsumptionSort());
        park.interfaceFuelSort();
        toWrite += "Sorted by interface:\n\n";
        toWrite += Arrays.toString(park.getCars()) + "\n";
        park.lambdaFuelSort();
        toWrite += "Sorted by lambda:\n\n";
        toWrite += Arrays.toString(park.getCars()) + "\n";
        park.methodFuelSort();
        toWrite += "Sorted by method:\n\n";
        toWrite += Arrays.toString(park.getCars()) + "\n";


        toWrite += "Cars that fit the range (" + minSpeed + " - " + maxAllowedSpeed + " km/h):\n";
        Car[] fitsTheRange = park.fitsRange(minSpeed, maxAllowedSpeed);
        toWrite += printCars(fitsTheRange);

        toWrite += "Car park cost: " + park.parkCost();
        write.fileWrite(toWrite);
    }

    public double getMaxAllowedSpeed() {
        return maxAllowedSpeed;
    }

    public void setMaxAllowedSpeed(int maxAllowedSpeed) {
        this.maxAllowedSpeed = maxAllowedSpeed;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }
}
