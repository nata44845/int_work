package FileWork;

import java.io.File;
import java.io.FileOutputStream;

public class FileHandler implements Writable {

    @Override
    public boolean write(String text, String fileName, boolean append) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName), append);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

}
