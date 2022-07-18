package lesson6.task1;

public class SubArrayFinder {
    int[] mainArray;
    int[] subArray;

    public SubArrayFinder(int[] mainArray, int[] subArray) {
        this.mainArray = mainArray;
        this.subArray = subArray;
    }

    public boolean findSubArray() {
        int mainArrIndex, truthAm = 0;
        boolean answerFound = false;
        for (int i = 0; i < mainArray.length; i++) {
            if (subArray[0] == mainArray[i]) {
                mainArrIndex = i + 1;
                truthAm++;
                for (int g = 1; mainArrIndex < mainArray.length && g < subArray.length; g++, mainArrIndex++) {
                    if (subArray[g] == mainArray[mainArrIndex]) {
                        truthAm++;
                        if (truthAm == subArray.length) {
                            System.out.print("Second array:\n[");
                            for (int number : subArray) {
                                System.out.print(" " + number);
                            }
                            System.out.print(" ]\nis a part of a first array:\n[");
                            for (int number : mainArray) {
                                System.out.print(" " + number);
                            }
                            System.out.println(" ]");
                            answerFound = true;
                        }
                    }
                }
            }
            truthAm = 0;
        }
        if (!answerFound) {
            System.out.print("Second array:\n[");
            for (int i : subArray) {
                System.out.print(" " + i);
            }
            System.out.print(" ]\nis not a part of a first array:\n[");
            for (int i : mainArray) {
                System.out.print(" " + i);
            }
            System.out.println(" ]");
        }
        return answerFound;
    }
}
