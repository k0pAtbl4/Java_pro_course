package lesson6.task1;

import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class SubArrayFinderTest {

    @Test
    public void subArrayFindTest() {
        int[] mainArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] subArray = {2, 3, 4};
        SubArrayFinder finder = new SubArrayFinder(mainArray, subArray);
        boolean expectedAnswer = true;
        assertEquals(finder.findSubArray(), expectedAnswer);
    }

}