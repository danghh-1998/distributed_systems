package src.hust.soict.danghh.client_server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private ServerSocket server_socket;

    public Server(int port) throws IOException {
        this.server_socket = new ServerSocket(port);
    }

    public void serve() throws IOException {
        System.out.println("Server is running at port " + this.server_socket.getLocalPort());
        int client_id = 0;
        while (client_id < 10) {
            new ServerThread(this.server_socket.accept(), client_id++).start();
        }
    }

    public static void main(String[] args) throws IOException{
        Server server = new Server(5000);
        server.serve();
    }
}
