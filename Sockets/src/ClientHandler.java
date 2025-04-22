import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private final Socket socket; // Socket für den einzelnen Client

    public ClientHandler(Socket socket) {
        this.socket = socket; // Verbindung speichern
    }

    @Override
    public void run() {
        try (
                // Eingabestream vom Client
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Ausgabestream zum Client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            // Begrüßung senden
            out.println("Willkommen! Gib 'exit' ein zum Beenden.");

            String line; // Eingehende Nachricht vom Client

            // Solange der Client Nachrichten sendet
            while ((line = in.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) break; // Verbindungsende
                out.println("Empfangen: " + line);        // Echo zurücksenden
            }

        } catch (IOException e) {
            // Fehlerbehandlung bei I/O-Problemen
            System.out.println("Fehler: " + e.getMessage());
        } finally {
            try {
                socket.close(); // Verbindung schließen
            } catch (IOException e) {
                System.out.println("Fehler beim Schließen: " + e.getMessage());
            }
        }
    }
}
