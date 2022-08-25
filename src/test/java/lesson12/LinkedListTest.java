package lesson12;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTest {

    @Test
    public void testPushBack() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(4);
        list.pushBack(5);
        int[] expected = new int[] {4, 5};
        int[] array = new int[list.getListLength()];
        int listLength = list.getListLength();
        for(int i = 0; i < listLength; i++) {
            array[i] = list.getHead().getData();
            list.deleteFirst();
        }
        assertEquals(array, expected);
    }

    @Test
    public void testPushForward() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushForward(4);
        list.pushForward(5);
        int[] expected = new int[] {5, 4};
        int[] array = new int[list.getListLength()];
        int listLength = list.getListLength();
        for(int i = 0; i < listLength; i++) {
            array[i] = list.getHead().getData();
            list.deleteFirst();
        }
        assertEquals(array, expected);
    }

    @Test
    public void testInsert() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(4);
        list.pushBack(5);
        list.insert(3, 1);
        int[] expected = new int[] {4, 3, 5};
        int[] array = new int[list.getListLength()];
        int listLength = list.getListLength();
        for(int i = 0; i < listLength; i++) {
            array[i] = list.getHead().getData();
            list.deleteFirst();
        }
        assertEquals(array, expected);
    }

    @Test
    public void testDeleteFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(4);
        list.pushBack(5);
        list.deleteFirst();
        int[] expected = new int[] {5};
        int[] array = new int[list.getListLength()];
        int listLength = list.getListLength();
        for(int i = 0; i < listLength; i++) {
            array[i] = list.getHead().getData();
            list.deleteFirst();
        }
        assertEquals(array, expected);
    }

    @Test
    public void testDeleteLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(4);
        list.pushBack(5);
        list.deleteLast();
        int[] expected = new int[] {4};
        int[] array = new int[list.getListLength()];
        int listLength = list.getListLength();
        for(int i = 0; i < listLength; i++) {
            array[i] = list.getHead().getData();
            list.deleteFirst();
        }
        assertEquals(array, expected);
    }

    @Test
    public void testDeleteByIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(3);
        list.deleteByIndex(1);
        int[] expected = new int[] {4, 3};
        int[] array = new int[list.getListLength()];
        int listLength = list.getListLength();
        for(int i = 0; i < listLength; i++) {
            array[i] = list.getHead().getData();
            list.deleteFirst();
        }
        assertEquals(array, expected);
    }

    @Test
    public void testSwap() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(3);
        list.pushBack(6);
        list.pushBack(7);
        list.swap(1, 3);
        int[] expected = new int[] {4, 6, 3, 5, 7};
        int[] array = new int[list.getListLength()];
        int listLength = list.getListLength();
        for(int i = 0; i < listLength; i++) {
            array[i] = list.getHead().getData();
            list.deleteFirst();
        }
        assertEquals(array, expected);
    }

    @Test
    public void testGetListLength() {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(3);
        list.pushBack(6);
        list.pushBack(7);
        int expected = 5;
        assertEquals(list.getListLength(), expected);
    }

    @Test
    public void testIfEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.ifEmpty());
    }
}