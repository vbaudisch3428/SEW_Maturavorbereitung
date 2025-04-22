import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIp = "localhost"; // IP-Adresse des Servers
        int port = 12345;              // Portnummer

        // Verbindung zum Server herstellen
        try (
                Socket socket = new Socket(serverIp, port);
                // Eingabestream vom Server
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Ausgabestream zum Server
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                // Eingabe vom Benutzer lesen
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String fromServer; // Nachricht vom Server

            // Solange der Server etwas schickt
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer); // Serverausgabe anzeigen
                System.out.print("Du: ");                   // Eingabeaufforderung

                String input = userInput.readLine();         // Eingabe vom Nutzer
                if (input == null || input.equalsIgnoreCase("exit")) break; // Beenden
                out.println(input);                          // An Server senden
            }
        }
    }
}