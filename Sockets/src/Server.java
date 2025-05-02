import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // 1. Erstelle einen ServerSocket auf Port 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        // 2. Warte darauf, dass sich ein Client verbindet
        Socket clientSocket = serverSocket.accept();

        // 3. Erstelle InputStream und OutputStream für den Client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // 4. Lese Nachricht vom Client
        String clientMessage = in.readLine();
        System.out.println("Client sagt: " + clientMessage);

        // 5. Schicke eine Antwort an den Client
        out.println("Server hat deine Nachricht erhalten: " + clientMessage);

        // 6. Schließe die Verbindung
        clientSocket.close();
        serverSocket.close();
    }
}
