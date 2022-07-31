package lesson06.task3;

import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class ResultFinderTest {
    @Test
    public void testResultFinderTest() {
        int[] array = {994, 645, 834, 4536456, 8888, 234, 54655465, 134, 12345678};
        boolean[] expectedResult = {false, true, true, false, false, true, false, true, true};
        ResultFinder finder = new ResultFinder(array);
        assertEquals(finder.findResult(), expectedResult);
    }
}