package lesson09.fileWork;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromFile {
    private String pathToFile;

    public ReadFromFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String fileRead() {

        char[] charStr = new char[0];
        try (FileInputStream fin = new FileInputStream(pathToFile)) {
            System.out.printf("File size: %d bytes \n", fin.available());
            charStr = new char[fin.available()];
            int i, iterator = 0;
            while ((i = fin.read()) != -1) {
                charStr[iterator] = (char) i;
                iterator++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(charStr);
    }

    private String[] arrayExpand(String[] line) {
        String[] resultArray = new String[line.length + 1];
        System.arraycopy(line, 0, resultArray, 0, Math.min(line.length, resultArray.length));
        return resultArray;
    }

    private String[] arrayDecrease(String[] line) {
        String[] resultArray = new String[line.length - 1];
        System.arraycopy(line, 0, resultArray, 0, resultArray.length);
        return resultArray;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
}
