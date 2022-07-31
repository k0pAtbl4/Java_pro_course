package lesson10.flowerShop;

import lesson10.bouquetParts.Bouquet;
import lesson10.exception.InvalidStemLengthException;

import java.util.Arrays;
import java.util.Scanner;

public class FlowerShop {
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
                                    bArray[bArray.length - 1].addFlower();
                                } catch (InvalidStemLengthException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                bArray[bArray.length - 1].addAccessory();
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
                            case 6:
                                bArray[bArray.length - 1].findFlowerByStemLength();
                                break;
                            default:
                                if (choose != 7) {
                                    System.out.println("Incorrect number. Try again");
                                }
                        }
                    } while (choose != 7);
                    break;
                case 2:
                    for (Bouquet bouquet : bArray) {
                        System.out.println(bouquet);
                    }
                    break;
                default:
                    if (choose != 3) {
                        System.out.println("Incorrect number. Try again");
                    }
            }
        } while (choose != 3);
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
                6. Find flowers by stem length
                7. Back""");
    }
}
