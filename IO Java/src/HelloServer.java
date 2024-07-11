import java.io.*;
import java.net.*;

public class HelloServer {
    public static void main(String[] args) {
        int port = 345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serveur en attente de connexion sur le port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    
                    String message = in.readLine();
                    String response = "Hello " + message + "!";
                    out.println(response);
                    System.out.println("Message reçu: " + message + " | Réponse envoyée: " + response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
