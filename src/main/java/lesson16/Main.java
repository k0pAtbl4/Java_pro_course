package lesson16;

public class Main {
    public static void main(String[] args) {
        String str = "Hello world, my name is Alex. Im 17 years old. I love Java. is Hello repair";
        StringWorker worker = new StringWorker(str);
        worker.wordCount();
        System.out.println(worker);
        worker.symbolChange(1, '-');
        worker.printString();
        worker.sameSymbolEndStart();
        System.out.println(worker.punctuationMarksCount());
    }
}
