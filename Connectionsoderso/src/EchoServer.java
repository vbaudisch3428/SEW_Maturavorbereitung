import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        System.out.println("Waiting for clients...");
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from client");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String userText = in.readLine();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Server says: "+userText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
