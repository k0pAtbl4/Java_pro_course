package lesson13;

import lesson09.carTypes.*;
import lesson13.service.WordProcessor;

public class Main {
    public static void main(String[] args) {
        WordProcessor proc = new WordProcessor("D:\\polytechnic\\data.txt");
        proc.read();
        System.out.println(proc);
    }
}
