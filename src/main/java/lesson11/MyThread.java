package lesson11;

public class MyThread extends Thread {
    private final int[] array;
    private final int start;
    private final int end;
    private final int threadNumber;

    public MyThread(int[] array, int start, int end, int threadNumber) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        boolean isSimple = true;
        for (int i = start; i <= end; i++) {
            for (int g = 2; g < array[i]; g++) {
                if (array[i] % g == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) {
                while (true) {
                    if (Main.getCurrentPriority() == threadNumber || threadNumber == 0) {
                        Main.setResultArray(pushBack(array[i], Main.getResultArray()));
                        break;
                    }
                }
            }
            isSimple = true;
        }
        Main.setCurrentPriority(threadNumber + 1);
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

    public int[] getArray() {
        return array;
    }
}
