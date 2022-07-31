package lesson06.task4;

public class ResultStrFinder {

    String findResult() {
        String result = "";
        int k = 21;
        int n = 0;
        int number = 0;
        while (n * n < k) {
            n++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (number <= k) {
                    result += number + "\t";
                    number++;
                }
            }
            result += "\n";
        }
        return result;
    }
}
