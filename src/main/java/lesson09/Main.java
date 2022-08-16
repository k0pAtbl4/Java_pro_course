package lesson09;

import lesson09.carTypes.Car;
import lesson09.carTypes.FreightCar;
import lesson09.carTypes.SedanCar;
import lesson09.carTypes.SportCar;
import lesson09.fileWork.ReadFromFile;
import lesson09.fileWork.WriteToFile;
import lesson09.service.CarPark;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        double maxAllowedSpeed = 230;
        double minSpeed = 110;

        ReadFromFile read = new ReadFromFile("D:\\polytechnic\\Java cars.txt");
        WriteToFile write = new WriteToFile("D:\\polytechnic\\Java cars result.txt", true);

        String oneLine = read.fileRead();
        String[] lines = oneLine.split(";\r\n");

        String[][] carsInStr = new String[lines.length][];
        Car[] cars = new Car[lines.length];

        for(int i = 0; i < lines.length; i++) {
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

        toWrite += "Cars that fit the range (" + minSpeed + " - " + maxAllowedSpeed + " km/h):\n";
        Car[] fitsTheRange = park.fitsRange(minSpeed, maxAllowedSpeed);
        toWrite += printCars(fitsTheRange);

        toWrite += "Car park cost: " + park.parkCost();
        write.FileWrite(toWrite);
    }

    public static String printCars(Car[] car) {
        StringBuilder result = new StringBuilder();
        for (Car iterator : car) {
            result.append(iterator).append("\n");
        }
        return result.toString();
    }
}
