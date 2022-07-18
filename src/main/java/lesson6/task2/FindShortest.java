package lesson6.task2;

public class FindShortest {
    int[] array;

    public FindShortest(int[] array) {
        this.array = array;
    }

    public Result shortestDigitFind() {
        int digitAm = 0, minDigitAm, minDigit = 0, k = array[0], temp = 0;
        final int TEN = 10;

        while (k != 0) {
            k /= TEN;
            digitAm++;
        }
        minDigitAm = digitAm;
        digitAm = 0;

        for (int i : array) {

            temp = i;
            while (i != 0) {
                i /= TEN;
                digitAm++;
            }


            if (minDigitAm >= digitAm) {
                minDigitAm = digitAm;
                minDigit = temp;
            }
            digitAm = 0;
        }
        System.out.println("Min digit amount is " + minDigitAm + " in the number " + minDigit);
        return new Result(minDigit, minDigitAm);
    }
}
