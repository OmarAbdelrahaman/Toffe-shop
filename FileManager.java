import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//Java serialize

public class FileManager {
    public static boolean write(String filepath, Object data) {
        ObjectOutputStream file;
        try {
            file = new ObjectOutputStream(new FileOutputStream(filepath));
            file.writeObject(data);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return false;
    }

    public static Object read(String filepath) {

        Object x = new ArrayList<>();

        ObjectInputStream file;
        try {
            file = new ObjectInputStream(new FileInputStream(filepath));
            x =  file.readObject();
            file.close();

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return x;
    }

    public static Object load(String type) {
        type = type.concat(".bin");
        return read(type);
    }

    public static void save(Object list, String type) {
        type = type.concat(".bin");
        write(type, list);
    }
}
