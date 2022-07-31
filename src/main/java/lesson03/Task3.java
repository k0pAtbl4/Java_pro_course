package lesson03;

public class Task3 {
    public static void main(String[] args) {
        int[] fibonachi = new int[20];
        for (int i = 0; i < 2; i++) {
            fibonachi[i] = 1;
            System.out.print(fibonachi[i] + " ");
        }
        for (int i = 2; i < fibonachi.length; i++) {
            fibonachi[i] = fibonachi[i - 1] + fibonachi[i - 2];
            System.out.print(fibonachi[i] + " ");
        }
    }
}
