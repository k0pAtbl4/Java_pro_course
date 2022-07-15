package lesson5;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        Car[] cars = {new Car("toyota", "m5", "2021", "black", 250000.0, 1243),
                new Car("mercedes", "mk4", "2021", "Grey", 200000.0, 3406),
                new Car("nissan", "r34", "1987", "blue", 23000.0, 4536),
                new Car("toyota", "mk4", "1989", "green", 29000.0, 8670),
                new Car("tesla", "s-cl", "2021", "white", 290000.0, 8270)};

        CarProcessor proc = new CarProcessor();
        Car[] firstResult = proc.getCarsWithMark(cars, "toyota");
        System.out.println("First result:");
        proc.printCars(firstResult);
        Car[] secondResult = proc.getCarsWithModel(cars, "mk4", 10);
        System.out.println("Second result:");
        proc.printCars(secondResult);
        Car[] thirdResult = proc.getCarsWithYear(cars, "2021", 210000.0);
        System.out.println("Third result:");
        proc.printCars(thirdResult);
    }
}
