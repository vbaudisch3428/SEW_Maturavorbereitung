import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // 1. Erstelle einen Socket und verbinde dich mit dem Server (localhost, Port 1234)
        Socket socket = new Socket("localhost", 1234);

        // 2. Erstelle InputStream und OutputStream für die Kommunikation
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // 3. Erstelle einen Scanner, um Benutzereingaben zu lesen
        Scanner scanner = new Scanner(System.in);

        // 4. Fordere den Benutzer auf, eine Nachricht einzugeben
        System.out.print("Gib eine Nachricht ein, die an den Server gesendet wird: ");
        String userMessage = scanner.nextLine();

        // 5. Sende die Nachricht an den Server
        out.println(userMessage);

        // 6. Lese Antwort vom Server
        String serverMessage = in.readLine();
        System.out.println("Server sagt: " + serverMessage);

        // 7. Schließe den Scanner und den Socket
        scanner.close();
        socket.close();
    }
}
