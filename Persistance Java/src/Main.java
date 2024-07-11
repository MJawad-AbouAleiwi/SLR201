public class Main {
    public static void main(String[] args) {
        HelloData data1 = new HelloData("Message 1", "Transient Message 1");
        HelloData data2 = new HelloData("Message 2", "Transient Message 2");

        String fileName1 = "helloData1.ser";
        String fileName2 = "helloData2.ser";
        DataSerializer.serialize(data1, fileName1);
        DataSerializer.serialize(data2, fileName2);

        data1.setMessage("Updated Message 1");
        data1.setTransientMessage("Updated Transient Message 1");
        data2.setMessage("Updated Message 2");
        data2.setTransientMessage("Updated Transient Message 2");

        HelloData deserializedData1 = DataUnserializer.unserialize(fileName1);
        HelloData deserializedData2 = DataUnserializer.unserialize(fileName2);

        System.out.println("Objet 1 dé-sérialisé: " + deserializedData1);
        System.out.println("Objet 2 dé-sérialisé: " + deserializedData2);
    }
}
