import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DataUnserializer {
    public static HelloData unserialize(String fileName) {
        HelloData data = null;
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            data = (HelloData) in.readObject();
            System.out.println("Données dé-sérialisées " + fileName);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return data;
    }
}
