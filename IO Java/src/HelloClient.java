import java.io.*;
import java.net.*;

public class HelloClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 345;

        try (Socket socket = new Socket(hostname, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            String message = "World";
            out.println(message);

            String response = in.readLine();
            System.out.println("Réponse du serveur: " + response);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

