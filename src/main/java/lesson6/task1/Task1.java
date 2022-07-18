package lesson6.task1;

public class Task1 {
    public static void main(String[] args) {
        int[] mainArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] subArray = {2, 3, 4};
        SubArrayFinder finder = new SubArrayFinder(mainArray, subArray);
        boolean result = finder.findSubArray();
        System.out.println(result);
    }
}
