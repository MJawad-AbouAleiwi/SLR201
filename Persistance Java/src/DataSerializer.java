import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataSerializer {
    public static void serialize(HelloData data, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(data);
            System.out.println("Données sérialisées et enregistrées " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

