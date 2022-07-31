package lesson03;

public class Task4 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 2, 3, 4, 6, 25, 736, 3, 678, 12, -7, 57, 891, 45};
        int min = numbers[0];
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        System.out.println("Max: " + max + "\nMin: " + min);
    }
}
