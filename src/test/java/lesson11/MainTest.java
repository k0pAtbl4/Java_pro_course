package lesson11;

import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void testMainStart() throws InterruptedException {
        int from = 3;
        int to = 23;
        int[][] array = {{3, 5, 7}, {11, 13}, {17, 19, 23}};
        int[] temp = Main.start(from, to, 3);
        assertTrue(subArrayCheck(temp, array[0]));
        assertTrue(subArrayCheck(temp, array[1]));
        assertTrue(subArrayCheck(temp, array[2]));
        assertEquals(temp.length, 8);
    }

    boolean subArrayCheck(int[] mainArray, int[] subArray) {
        int correctNumberAmount = 1;
        if(mainArray.length > subArray.length) {
            for(int i = 0; i < mainArray.length; i++) {
                for (int value : subArray) {
                    if (mainArray[i] == value) {
                        for (int j = 1; j < subArray.length; j++) {
                            if (subArray[j] == mainArray[i + j]) {
                                correctNumberAmount++;
                                if (correctNumberAmount == subArray.length) {
                                    return true;
                                }
                            }
                        }
                    }
                    correctNumberAmount = 1;
                }
            }
        }
        return false;
    }
}