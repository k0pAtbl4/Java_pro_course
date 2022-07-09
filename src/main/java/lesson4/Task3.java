package lesson4;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] array = {994, 645, 834, 4536456, 8888, 234, 54655465, 134, 12345678};
        int[] digitAm = new int[array.length];
        final int TEN = 10;
        int digitNumb = 0, temp = 1;
        boolean breakPoint = false;

        System.out.println("Numbers without repeating digits:");

        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            while (temp != 0) {
                temp /= TEN;
                digitNumb++;
            }
            digitAm[i] = digitNumb;
            digitNumb = 0;
        }

        for (int i = 0; i < array.length; i++) {
            breakPoint = false;
            int[] number = new int[digitAm[i]];
            temp = array[i];

            for (int k = 0; k < digitAm[i]; k++) {
                number[k] = temp % TEN;
                temp /= TEN;
            }

            for(int g = 0; g < number.length; g++) {
                if(breakPoint) {
                    break;
                }
                for(int h = 0; h < number.length; h++) {
                    if(g != h) {
                        if(number[g] == number[h]) {
                            breakPoint = true;
                            break;
                        }
                    }
                    if ((h == number.length - 1) && (g == number.length - 1)) {
                        for(int t = number.length - 1; t >= 0; t--) {
                            System.out.print(number[t] + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
