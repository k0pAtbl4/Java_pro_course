package lesson06.task2;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {994, 645, 834, 4536456, 8888, 234, 54655465, 134};
        FindLongest finderLongest = new FindLongest(array);
        FindShortest finderShortest = new FindShortest(array);
        finderLongest.longestDigitFind();
        finderShortest.shortestDigitFind();
    }
}
