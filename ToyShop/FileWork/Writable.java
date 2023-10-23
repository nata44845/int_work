package FileWork;

import java.io.Serializable;

public interface Writable {
    public boolean write(Serializable serializable, String fileName);

    public Object read(String fileName);
}
