package lesson11;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void testMainStart() throws InterruptedException {
        int from = 3;
        int to = 23;
        int[] array = {3, 5, 7, 11, 13, 17, 19, 23};
        int[] temp = Main.start(3, 23, 3);
        assertEquals(temp, array);
    }
}