package lesson14;

import lesson09.carTypes.Car;
import lesson14.service.Runner;

import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        double maxAllowedSpeed = 230;
        double minSpeed = 110;

        Runner temp = new Runner(maxAllowedSpeed, minSpeed);
        temp.run();
    }

    public static String printCars(LinkedList<Car> car) {
        StringBuilder result = new StringBuilder();
        for (Car iterator : car) {
            result.append(iterator).append("\n");
        }
        return result.toString();
    }
}
