import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 12345; // Portnummer für den Server
        ServerSocket serverSocket = new ServerSocket(port); // Server starten
        System.out.println("Server läuft auf Port " + port);

        ExecutorService pool = Executors.newCachedThreadPool(); // Threadpool

        // Auf Clients warten
        while (true) {
            Socket clientSocket = serverSocket.accept(); // Verbindung annehmen
            pool.execute(new ClientHandler(clientSocket)); // Handler starten
        }
    }
}
