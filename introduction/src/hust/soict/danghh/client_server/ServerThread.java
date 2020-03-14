package src.hust.soict.danghh.client_server;

import src.hust.soict.danghh.helper.SelectionSorter;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class ServerThread extends Thread {
    private Socket socket;
    private int client_id;

    public ServerThread(Socket socket, int client_id) {
        this.socket = socket;
        this.client_id = client_id;
    }

    private String handle_request(String request) {
        // Split request string into an array list
        try {
            ArrayList<String> str_array = new ArrayList<>(Arrays.asList(request.split(" ")));
            ArrayList<Integer> int_array = new ArrayList<>();
            for (String str : str_array) {
                int_array.add(Integer.parseInt(str));
            }
            // Sort array
            new SelectionSorter().sort(int_array);
            StringBuilder result = new StringBuilder();
            for (int i : int_array) {
                result.append(i).append(" ");
            }
            return result.toString();
        } catch (NumberFormatException e) {
            return "Data must be an int array";
        }
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintStream writer = new PrintStream(socket.getOutputStream());

            // Read first message from client
            String request = reader.readLine();
            System.out.println("Client send message: " + request);
            writer.println("Hi, you are client: #" + this.client_id);

            // Always listen request from client and response
            while (true) {
                request = reader.readLine();
                if (request == null){
                    System.out.println("Client #" + this.client_id + " disconnected");
                    break;
                }
                String response = handle_request(request);
                writer.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
