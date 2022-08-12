package lesson11;

public class Result {
    private static int[] resultArray;

    public Result() {
        resultArray = new int[0];
    }

    public static void addToResultArray(int[] arrayToAdd) {
        synchronized (Result.class) {
            int[] temp = resultArray;
            resultArray = new int[resultArray.length + arrayToAdd.length];
            System.arraycopy(temp, 0, resultArray, 0, temp.length);
            System.arraycopy(arrayToAdd, 0, resultArray, temp.length, arrayToAdd.length);
        }
    }

    public static int[] getResultArray() {
        return resultArray;
    }

    public void setResultArray(int[] resultArray) {
        Result.resultArray = resultArray;
    }
}
