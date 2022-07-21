package lesson5;

import java.util.Arrays;

public class CarProcessor {

    private Car[] carsArray;

    CarProcessor() {
        carsArray = null;
    }

    CarProcessor(Car[] array) {
        carsArray = array;
    }

    public Car[] getCarsWithMark(Car[] cars, String mark) {
        int truthAmount = 0;
        int iteration = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getMark().equals(mark)) {
                truthAmount++;
            }
        }
        Car[] resultCars = new Car[truthAmount];
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getMark().equals(mark)) {
                resultCars[iteration] = cars[i];
                printCars(resultCars, iteration);
                iteration++;
            }
        }
        return resultCars;
    }

    public Car[] getCarsWithMark(String mark) {
        if (carsArray == null) {
            return null;
        } else {
            int truthAmount = 0;
            int iteration = 0;
            for (int i = 0; i < carsArray.length; i++) {
                if (carsArray[i].getMark().equals(mark)) {
                    truthAmount++;
                }
            }
            Car[] resultCars = new Car[truthAmount];
            for (int i = 0; i < carsArray.length; i++) {
                if (carsArray[i].getMark().equals(mark)) {
                    resultCars[iteration] = carsArray[i];
                    printCars(resultCars, iteration);
                    iteration++;
                }
            }
            return resultCars;
        }
    }

    public Car[] getCarsWithModel(Car[] cars, String model, int yearAmount) {
        int truthAmount = 0;
        int iteration = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getModel().equals(model)) {
                if (2022 - Integer.parseInt(cars[i].getYear()) > yearAmount) {
                    truthAmount++;
                }
            }
        }
        Car[] resultCars = new Car[truthAmount];
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getModel().equals(model)) {
                if (2022 - Integer.parseInt(cars[i].getYear()) > yearAmount) {
                    resultCars[iteration] = cars[i];
                    printCars(resultCars, iteration);
                    iteration++;
                }
            }
        }
        return resultCars;
    }

    public Car[] getCarsWithModel(String model, int yearAmount) {
        if (carsArray == null) {
            return null;
        } else {
            int truthAmount = 0;
            int iteration = 0;
            for (int i = 0; i < carsArray.length; i++) {
                if (carsArray[i].getModel().equals(model)) {
                    if (2022 - Integer.parseInt(carsArray[i].getYear()) > yearAmount) {
                        truthAmount++;
                    }
                }
            }
            Car[] resultCars = new Car[truthAmount];
            for (int i = 0; i < carsArray.length; i++) {
                if (carsArray[i].getModel().equals(model)) {
                    if (2022 - Integer.parseInt(carsArray[i].getYear()) > yearAmount) {
                        resultCars[iteration] = carsArray[i];
                        printCars(resultCars, iteration);
                        iteration++;
                    }
                }
            }
            return resultCars;
        }
    }

    public Car[] getCarsWithYear(Car[] cars, String year, double price) {
        int truthAmount = 0;
        int iteration = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getYear().equals(year)) {
                if (cars[i].getPrice() > price) {
                    truthAmount++;
                }
            }
        }
        Car[] resultCars = new Car[truthAmount];
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getYear().equals(year)) {
                if (cars[i].getPrice() > price) {
                    resultCars[iteration] = cars[i];
                    printCars(resultCars, iteration);
                    iteration++;
                }
            }
        }
        return resultCars;
    }

    public Car[] getCarsWithYear(String year, double price) {
        if (carsArray == null) {
            return null;
        } else {
            int truthAmount = 0;
            int iteration = 0;
            for (int i = 0; i < carsArray.length; i++) {
                if (carsArray[i].getYear().equals(year)) {
                    if (carsArray[i].getPrice() > price) {
                        truthAmount++;
                    }
                }
            }
            Car[] resultCars = new Car[truthAmount];
            for (int i = 0; i < carsArray.length; i++) {
                if (carsArray[i].getYear().equals(year)) {
                    if (carsArray[i].getPrice() > price) {
                        resultCars[iteration] = carsArray[i];
                        printCars(resultCars, iteration);
                        iteration++;
                    }
                }
            }
            return resultCars;
        }
    }

    public void printCars(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.println("Model: " + cars[i].getModel() + "\t\tMark: " + cars[i].getMark() + "\t\tColor: " + cars[i].getColor() + "\t\tYear: " +
                    cars[i].getYear() + "\t\tPrice: " + cars[i].getPrice() + "\t\tRegister number: " + cars[i].getRegisterNumber());
        }
        System.out.println();
    }

    public void printCars(Car[] cars, int index) {
        if (index >= 0 && index < cars.length) {
            System.out.println("Model: " + cars[index].getModel() + "\t\tMark: " + cars[index].getMark() +
                    "\t\tColor: " + cars[index].getColor() + "\t\tYear: " + cars[index].getYear() +
                    "\t\tPrice: " + cars[index].getPrice() + "\t\tRegister number: " +
                    cars[index].getRegisterNumber());
        }
    }
}
