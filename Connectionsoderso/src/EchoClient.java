import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        System.out.println("Client started");
        try {
            Socket socket = new Socket("localhost", 1234);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please enter some random text lol: ");
            String userText = userInput.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(userText);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
