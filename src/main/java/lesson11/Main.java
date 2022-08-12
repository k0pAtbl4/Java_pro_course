package lesson11;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int from, to, threadAmount;

        //ввод начальных данных с клавиатуры
        System.out.println("Enter number diapason:\nFrom:");
        from = scan.nextInt();
        System.out.println("To:");
        to = scan.nextInt();
        System.out.println("Threads amount:");
        threadAmount = scan.nextInt();

        start(from, to, threadAmount);
    }

    public static int[] start(int from, int to, int threadAmount) throws InterruptedException {
        int numbersForThread;

        //формируем массив чисел в заданном диапазоне
        Result result = new Result();
        int[] numberArray = new int[to - from + 1];
        for (int i = from; i <= to; i++) {
            numberArray[i - from] = i;
        }

        int start = 0;
        int end = 0;

        //рассчитываем количество проверяемых чисел для каждого потока
        if (numberArray.length % threadAmount != 0) {
            numbersForThread = numberArray.length / threadAmount + 1;
        } else {
            numbersForThread = numberArray.length / threadAmount;
        }
        end = numbersForThread - 1;

        //формируем массив потоков
        MyThread[] thread = new MyThread[threadAmount];

        for (int i = 0; i < threadAmount; i++) {
            thread[i] = new MyThread(numberArray[start], numberArray[end]);
            int temp = start;
            start += end - start + 1;
            end += end - temp + 1;
            if (end >= numberArray.length) {
                end = numberArray.length - 1;
            }
        }

        //запускаем потоки
        for (int i = 0; i < threadAmount; i++) {
            thread[i].start();
        }
        //ждем завершения потоков
        for (int i = 0; i < threadAmount; i++) {
            thread[i].join();
        }

        //выводим результат на экран
        System.out.println("Results:");
        for (int i = 0; i < Result.getResultArray().length; i++) {
            if ((i % 30 != 0) || (i == 0)) {
                System.out.print(Result.getResultArray()[i] + " ");
            } else {
                System.out.println();
            }
        }
        return Result.getResultArray();
    }
}
