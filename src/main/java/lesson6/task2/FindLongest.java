package lesson6.task2;

public class FindLongest {
    int[] array;

    public FindLongest(int[] array) {
        this.array = array;
    }

    public Result longestDigitFind() {
        int digitAm = 0, maxDigitAm, maxDigit = 0, k = array[0], temp = 0;
        final int TEN = 10;

        while (k != 0) {
            k /= TEN;
            digitAm++;
        }
        maxDigitAm = digitAm;
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
            digitAm = 0;
        }
        System.out.println("Max digit amount is " + maxDigitAm + " in the number " + maxDigit);
        return new Result(maxDigit, maxDigitAm);
    }
}
