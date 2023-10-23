package FileWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.stream.Stream;

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

    @Override
    public Object read(String fileName) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
