package lesson11;

public class Result {
    private int[] resultArray;

    public Result() {
        resultArray = new int[0];
    }

    public synchronized void addToResultArray(int[] arrayToAdd) {
        int[] temp = resultArray;
        resultArray = new int[resultArray.length + arrayToAdd.length];
        System.arraycopy(temp, 0, resultArray, 0, temp.length);
        System.arraycopy(arrayToAdd, 0, resultArray, temp.length, arrayToAdd.length);
    }

    public int[] getResultArray() {
        return resultArray;
    }

    public void setResultArray(int[] resultArray) {
        this.resultArray = resultArray;
    }
}
