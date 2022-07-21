package lesson7;

public class Task2 {
    public static void main(String[] args) {
        int number = 7;
        recursiveFunc(1, number);
    }

    public static void recursiveFunc(int partNumber, int number) {
        if (partNumber <= number) {
            System.out.print(partNumber + " ");
        } else {
            return;
        }
        partNumber++;
        recursiveFunc(partNumber, number);
    }
}
