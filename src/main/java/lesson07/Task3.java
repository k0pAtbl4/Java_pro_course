package lesson07;

public class Task3 {
    public static void main(String[] args) {
        int startSum = 0;
        System.out.println(recursiveSum(893567, startSum));
    }

    public static int recursiveSum(int number, int sum) {
        int rightDigit = number % 10;
        number = number / 10;
        if (number > 0) {
            sum = recursiveSum(number, sum);
        }
        sum += rightDigit;
        return sum;
    }
}
