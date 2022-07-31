package lesson06.task2;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FindShortestTest {
    @Test
    public void testShortestDigitFind() {
        int[] array = {994, 645, 834, 4536456, 8888, 234, 54655465, 134};
        Result expectedResult = new Result(134, 3);
        FindShortest finder = new FindShortest(array);
        assertEquals(finder.shortestDigitFind().number, expectedResult.number);
        assertEquals(finder.shortestDigitFind().length, expectedResult.length);
    }
}