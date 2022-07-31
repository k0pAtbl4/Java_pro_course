package lesson06.task4;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ResultStrFinderTest {
    @Test
    public void testResultStrFinder() {
        String expected = "0\t1\t2\t3\t4\t\n5\t6\t7\t8\t9\t\n10\t11\t12\t13\t14\t\n15\t16\t17\t18\t19\t\n20\t21\t\n";
        ResultStrFinder finder = new ResultStrFinder();
        assertEquals(finder.findResult(), expected);
    }
}