package lesson09.fileWork;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {
    private final String pathToFile;

    public WriteToFile(String pathToFile, boolean delete) throws IOException {
        this.pathToFile = pathToFile;
        if (delete) {
            clearTheFile(pathToFile);
        }
    }

    public void FileWrite(String text) {
        try (FileOutputStream fos = new FileOutputStream(pathToFile)) {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void clearTheFile(String fileName) throws IOException {
        FileWriter fwOb = new FileWriter(fileName, false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
}
