package lesson09.fileWork;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    private final String pathToFile;

    public WriteToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void FileWrite(String text) {
        try (FileOutputStream fos = new FileOutputStream(pathToFile)) {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
