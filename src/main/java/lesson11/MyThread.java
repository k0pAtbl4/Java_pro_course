package lesson11;

public class MyThread extends Thread {
    private final int start;
    private final int end;

    public MyThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int[] numberArray = new int[end - start + 1];
        int[] resultArray = new int[0];
        int temp = start;
        for(int i = 0; i < numberArray.length; i++) {
            numberArray[i] = temp;
            temp++;
        }
        boolean isSimple = true;
        for (int j : numberArray) {
            for (int g = 2; g <= j / 2; g++) {
                if (j % g == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) {
                resultArray = pushBack(j, resultArray);
            }
            isSimple = true;
        }
        Result.addToResultArray(resultArray);
    }

    public int[] pushBack(int a, int[] NumberArray) {
        int[] temp = NumberArray;
        NumberArray = new int[NumberArray.length + 1];
        System.arraycopy(temp, 0, NumberArray, 0, temp.length);
        boolean functionWorkCorrectly = false;
        for (int i = 0; i < NumberArray.length; i++) {
            if (NumberArray[i] == 0) {
                NumberArray[i] = a;
                functionWorkCorrectly = true;
                break;
            }
        }
        if (!functionWorkCorrectly) {
            System.out.println("Cannot push number back");
        }
        return NumberArray;
    }
}
