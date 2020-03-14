package src.hust.soict.danghh.client_server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void connect() throws IOException {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream writer = new PrintStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        // Send hello to server
        writer.println("Hello, server");
        // Listen from server
        System.out.println(reader.readLine());
        String request = scanner.nextLine();

        // Send request to server until message equals to empty string
        while (!request.equals("")) {
            writer.println(request);
            String response = reader.readLine();
            if (!response.equals("")) {
                System.out.println(response);
            }
            request = scanner.nextLine();
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.connect();
    }
}
