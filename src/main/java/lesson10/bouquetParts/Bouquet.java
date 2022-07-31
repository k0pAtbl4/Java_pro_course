package lesson10.bouquetParts;

import lesson10.exception.InvalidStemLengthException;

import java.util.Scanner;

public class Bouquet {
    private Flower[] flowers;
    private Accessory[] accessories;

    public Bouquet(Flower[] flowers, Accessory[] accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
    }

    public Bouquet() {
        flowers = new Flower[0];
        accessories = new Accessory[0];
    }

    public void addFlower() throws InvalidStemLengthException {
        Scanner scan = new Scanner(System.in);
        Flower[] temp = new Flower[flowers.length + 1];
        System.arraycopy(flowers, 0, temp, 0, flowers.length);
        temp[temp.length - 1] = new Flower();
        System.out.println("Name:");
        temp[temp.length - 1].setName(scan.nextLine());
        System.out.println("Days till death:");
        temp[temp.length - 1].setDays(scan.nextInt());
        System.out.println("Price:");
        temp[temp.length - 1].setPrice(scan.nextInt());
        System.out.println("Stem length:");
        int stem = scan.nextInt();
        if (stem <= 0) {
            stem = 1;
            throw new InvalidStemLengthException("Incorrect stem length");
        } else {
            temp[temp.length - 1].setSteamLength(stem);
        }
        flowers = temp;
    }

    public void addAccessory() {
        Scanner scan = new Scanner(System.in);
        Accessory[] temp = new Accessory[accessories.length + 1];
        System.arraycopy(accessories, 0, temp, 0, accessories.length);
        temp[temp.length - 1] = new Accessory();
        System.out.println("Name:");
        temp[temp.length - 1].setName(scan.nextLine());
        System.out.println("Price:");
        temp[temp.length - 1].setPrice(scan.nextInt());
        accessories = temp;
    }

    public int sumCalculate() {
        int sum = 0;
        for (Flower flower : flowers) {
            sum += flower.getPrice();
        }
        for (Accessory accessory : accessories) {
            sum += accessory.getPrice();
        }
        return sum;
    }

    public void findFlowerByStemLength() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Min stem length:");
        int minStemLength = scan.nextInt();
        System.out.println("Max stem length:");
        int maxStemLength = scan.nextInt();
        for (Flower flower : flowers) {
            if (flower.getSteamLength() >= minStemLength && flower.getSteamLength() <= maxStemLength) {
                System.out.println(flower);
            }
        }
    }

    public void printBouquet() {
        System.out.println("Flowers:");
        if (flowers.length > 0) {
            for (Flower flower : flowers) {
                System.out.println(flower);
            }
        } else {
            System.out.println("No flowers in the bouquet");
        }
        System.out.println("Accessories:");
        if (accessories.length > 0) {
            for (Accessory accessory : accessories) {
                System.out.println(accessory);
            }
        } else {
            System.out.println("No accessories in the bouquet");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        String result = "Flowers:\n";
        for (Flower flower : flowers) {
            result += flower + "\n";
        }
        result += "Accessories:\n";
        for (Accessory accessory : accessories) {
            result += accessory + "\n";
        }
        return result;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    public Accessory[] getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessory[] accessories) {
        this.accessories = accessories;
    }
}
