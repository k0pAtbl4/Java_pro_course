package lesson10.flowerShop;

import lesson10.bouquetParts.Accessory;
import lesson10.bouquetParts.Flower;
import lesson10.bouquetParts.Bouquet;
import lesson10.exception.InvalidStemLengthException;

import java.util.Arrays;
import java.util.Scanner;

public class FlowerShop implements FlowerShopModel {
    private Bouquet[] bArray;

    public FlowerShop() {
        bArray = new Bouquet[0];
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        int choose;
        do {
            mainMenuPrint();
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    Bouquet[] temp = new Bouquet[bArray.length + 1];
                    System.arraycopy(bArray, 0, temp, 0, bArray.length);
                    temp[temp.length - 1] = new Bouquet();
                    bArray = temp;
                    do {
                        createBouquetMenuPrint();
                        choose = input.nextInt();
                        switch (choose) {
                            case 1:
                                try {
                                    addFlower();
                                } catch (InvalidStemLengthException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                addAccessory();
                                break;
                            case 3:
                                bArray[bArray.length - 1].printBouquet();
                                break;
                            case 4:
                                System.out.println("Sum: " + bArray[bArray.length - 1].sumCalculate());
                                break;
                            case 5:
                                Arrays.sort(bArray[bArray.length - 1].getFlowers());
                                bArray[bArray.length - 1].printBouquet();
                                break;
                            default:
                                if(choose != 6) {
                                    System.out.println("Incorrect number. Try again");
                                }
                        }
                    } while (choose != 6);
                    break;
                case 2:
                    for (Bouquet bouquet : bArray) {
                        System.out.println(bouquet);
                    }
                    break;
                default:
                    if(choose != 3) {
                        System.out.println("Incorrect number. Try again");
                    }
            }
        } while (choose != 3);
    }

    public void addFlower() throws InvalidStemLengthException {
        Scanner scan = new Scanner(System.in);
        Flower[] temp = new Flower[bArray[bArray.length - 1].getFlowers().length + 1];
        System.arraycopy(bArray[bArray.length - 1].getFlowers(), 0, temp, 0, bArray[bArray.length - 1].getFlowers().length);
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
        bArray[bArray.length - 1].setFlowers(temp);
    }

    public void addAccessory() {
        Scanner scan = new Scanner(System.in);
        Accessory[] temp = new Accessory[bArray[bArray.length - 1].getAccessories().length + 1];
        System.arraycopy(bArray[bArray.length - 1].getAccessories(), 0, temp, 0, bArray[bArray.length - 1].getAccessories().length);
        temp[temp.length - 1] = new Accessory();
        System.out.println("Name:");
        temp[temp.length - 1].setName(scan.nextLine());
        System.out.println("Price:");
        temp[temp.length - 1].setPrice(scan.nextInt());
        bArray[bArray.length - 1].setAccessories(temp);
    }

    public static void mainMenuPrint() {
        System.out.println("1. Create bouquet\n2. Made bouquets list\n3. Exit");
    }

    public static void createBouquetMenuPrint() {
        System.out.println("""
                1. Add flower
                2. Add accessory
                3. View current bouquet
                4. Calculate current bouquet cost
                5. Sort flowers in current
                   bouquet by stem length
                6. Back""");
    }
}
