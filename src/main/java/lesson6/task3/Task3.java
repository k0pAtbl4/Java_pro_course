package lesson6.task3;

public class Task3 {
    public static void main(String[] args) {
        int[] array = {994, 645, 834, 4536456, 8888, 234, 54655465, 134, 12345678};
        ResultFinder finder = new ResultFinder(array);
        boolean[] result = finder.findResult();
    }
}
