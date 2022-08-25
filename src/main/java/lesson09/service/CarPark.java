package lesson09.service;

import lesson09.carTypes.Car;

import java.util.Arrays;
import java.util.Comparator;

public class CarPark implements CarParkFunctions {
    private Car[] cars;

    private Car[] fitsRange;

    public CarPark(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public double parkCost() {
        double sum = 0;
        for (Car car : cars) {
            sum += car.getPrice();
        }
        return sum;
    }

    public void interfaceFuelSort() {
        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
            }
        });
    }
    public void lambdaFuelSort() {
        Arrays.sort(cars, (o1, o2) -> Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption()));
    }

    public void methodFuelSort() {
        Arrays.sort(cars, Comparator.comparingDouble(Car::getFuelConsumption));
    }

    @Override
    public Car[] fuelConsumptionSort() {
        Car[] carsCopy = cars;
        for (int k = 0; k < carsCopy.length; k++) {
            for (int i = 1; i < carsCopy.length; i++) {
                if (carsCopy[i - 1].getFuelConsumption() > carsCopy[i].getFuelConsumption()) {
                    Car temp = carsCopy[i - 1];
                    carsCopy[i - 1] = carsCopy[i];
                    carsCopy[i] = temp;
                }
            }
        }
        return carsCopy;
    }

    @Override
    public Car[] fitsRange(double minSpeed, double maxSpeedAllowed) {
        Car[] resultArray = new Car[]{};
        for (Car car : cars) {
            if (car.getMaxSpeed() <= maxSpeedAllowed && car.getMaxSpeed() >= minSpeed) {
                resultArray = pushBack(car, resultArray);
            }
        }
        return resultArray;
    }

    private Car[] pushBack(Car car, Car[] carArray) {
        Car[] resultArray = new Car[carArray.length + 1];
        arrayCopy(carArray, resultArray);
        resultArray[resultArray.length - 1] = car;
        return resultArray;
    }

    private void arrayCopy(Car[] copyFromArray, Car[] copyToArray) {
        for (int i = 0; i < Math.min(copyFromArray.length, copyToArray.length); i++) {
            copyToArray[i] = copyFromArray[i];
        }
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
