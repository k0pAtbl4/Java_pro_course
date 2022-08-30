package lesson14.service;

import lesson09.carTypes.Car;

import java.util.Comparator;
import java.util.LinkedList;

public class CarPark {
    private LinkedList<Car> cars;

    private Car[] fitsRange;

    public CarPark(LinkedList<Car> cars) {
        this.cars = cars;
    }

    public double parkCost() {
        double sum = 0;
        for (Car car : cars) {
            sum += car.getPrice();
        }
        return sum;
    }

    public void interfaceFuelSort() {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
            }
        });
    }
    public void lambdaFuelSort() {
        cars.sort((o1, o2) -> Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption()));
    }

    public void methodFuelSort() {
        cars.sort(Comparator.comparingDouble(Car::getFuelConsumption));
    }

    public LinkedList<Car> fuelConsumptionSort() {
        LinkedList<Car> carsCopy = cars;
        for (int k = 0; k < carsCopy.size(); k++) {
            for (int i = 1; i < carsCopy.size(); i++) {
                if (carsCopy.get(i - 1).getFuelConsumption() > carsCopy.get(i).getFuelConsumption()) {
                    Car temp = carsCopy.get(i - 1);
                    carsCopy.set(i - 1, carsCopy.get(i));
                    carsCopy.set(i, temp);
                }
            }
        }
        System.out.println("Test");
        return carsCopy;
    }

    public LinkedList<Car> fitsRange(double minSpeed, double maxSpeedAllowed) {
        LinkedList<Car> resultArray = new LinkedList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() <= maxSpeedAllowed && car.getMaxSpeed() >= minSpeed) {
                resultArray.push(car);
            }
        }
        return resultArray;
    }

    private void arrayCopy(Car[] copyFromArray, Car[] copyToArray) {
        for (int i = 0; i < Math.min(copyFromArray.length, copyToArray.length); i++) {
            copyToArray[i] = copyFromArray[i];
        }
    }

    public LinkedList<Car> getCars() {
        return cars;
    }

    public void setCars(LinkedList<Car> cars) {
        this.cars = cars;
    }

    public Car[] getFitsRange() {
        return fitsRange;
    }

    public void setFitsRange(Car[] fitsRange) {
        this.fitsRange = fitsRange;
    }
}
