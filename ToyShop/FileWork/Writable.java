package FileWork;

import java.io.Serializable;

public interface Writable {
    public boolean write(String text, String fileName, boolean append);

    public Object read(String fileName);
}
