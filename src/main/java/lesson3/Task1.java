package lesson3;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Task1 {
    public static int[] numbersFinder(int[] numbers) {
        int oddCount = 0, iterator = 0;
        System.out.println("Even ones:");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.print(numbers[i] + " ");
                oddCount++;
            }
        }
        int[] oddNumbers = new int[oddCount];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if(iterator <= oddCount) {
                    oddNumbers[iterator] = numbers[i];
                    iterator++;
                }
            }
        }
        System.out.println("\nOdd ones:");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                System.out.print(numbers[i] + " ");
            }
        }
        return oddNumbers;
    }
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = numbersFinder(numbers);
    }
}
