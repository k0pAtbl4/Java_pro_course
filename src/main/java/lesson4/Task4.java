package lesson4;

public class Task4 {
    public static void main(String[] args) {
        int k = 21;
        int n = 0;
        int number = 0;
        while (n * n < k) {
            n++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (number <= k) {
                    System.out.print(number + "\t");
                    number++;
                }
            }
            System.out.println();
        }
    }
}
