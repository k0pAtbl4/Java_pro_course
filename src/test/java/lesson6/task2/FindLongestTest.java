package lesson6.task2;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FindLongestTest {

    @Test
    public void testLongestDigitFind() {
        int[] array = {994, 645, 834, 4536456, 8888, 234, 54655465, 134};
        Result expectedResult = new Result(54655465, 8);
        FindLongest finder = new FindLongest(array);
        assertEquals(finder.longestDigitFind().number, expectedResult.number);
        assertEquals(finder.longestDigitFind().length, expectedResult.length);
    }
}