package lesson4;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] mainArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int mainArrIndex, truthAm = 0;
        boolean answerFound = false;
        int[] subArray = {2, 3, 4};

        for (int i = 0; i < mainArray.length; i++) {
            if (subArray[0] == mainArray[i]) {
                mainArrIndex = i + 1;
                truthAm++;
                for (int g = 1; mainArrIndex < mainArray.length && g < subArray.length; g++, mainArrIndex++) {
                    if (subArray[g] == mainArray[mainArrIndex]) {
                        truthAm++;
                        if (truthAm == subArray.length) {
                            System.out.print("Second array:\n[");
                            for (int number : subArray) {
                                System.out.print(" " + number);
                            }
                            System.out.print(" ]\nis a part of a first array:\n[");
                            for (int number : mainArray) {
                                System.out.print(" " + number);
                            }
                            System.out.println(" ]");
                            answerFound = true;
                        }
                    }
                }
            }
            truthAm = 0;
        }
        if (!answerFound) {
            System.out.print("Second array:\n[");
            for (int i : subArray) {
                System.out.print(" " + i);
            }
            System.out.print(" ]\nis not a part of a first array:\n[");
            for (int i : mainArray) {
                System.out.print(" " + i);
            }
            System.out.println(" ]");
            answerFound = true;
        }
    }
}
