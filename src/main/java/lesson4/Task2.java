package lesson4;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {994, 645, 834, 4536456, 8888, 234, 54655465, 134};
        int digitAm = 0, maxDigitAm, minDigitAm, maxDigit = 0, minDigit = 0, k = array[0], temp = 0;
        final int TEN = 10;

        while (k != 0) {
            k /= TEN;
            digitAm++;
        }
        maxDigitAm = digitAm;
        minDigitAm = digitAm;
        digitAm = 0;

        for (int i : array) {

            temp = i;
            while (i != 0) {
                i /= TEN;
                digitAm++;
            }

            if (maxDigitAm <= digitAm) {
                maxDigitAm = digitAm;
                maxDigit = temp;
            }
            if (minDigitAm >= digitAm) {
                minDigitAm = digitAm;
                minDigit = temp;
            }
            digitAm = 0;
        }
        System.out.println("Max digit amount is " + maxDigitAm + " in the number " + maxDigit + "\nMin digit amount is " + minDigitAm + " in the number " + minDigit);
    }
}
