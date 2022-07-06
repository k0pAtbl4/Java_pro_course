package lesson3;

public class Task2 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 83, 84, 97};
        for (int i = 0; i < numbers.length; i++) {
            for (int div_number = numbers[i] - 1; div_number > 1; div_number--) {
                if (numbers[i] % div_number == 0)
                    numbers[i] = 1;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 1)
                System.out.print(numbers[i] + " ");
        }
    }
}
