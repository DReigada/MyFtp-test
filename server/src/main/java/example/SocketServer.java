package example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import myftp.core.FileReceiver;



public class SocketServer
{
    public static void main( String[] args ) throws IOException {
        // Check arguments
        if (args.length != 2) {
            System.err.println("Argument(s) missing!");
            System.err.printf("Usage: java %s port filepath%n", SocketServer.class.getName());
            return;
        }

        // Convert port from String to int
        int port = Integer.parseInt(args[0]);
        String filePath = args[1];

        // Create server socket
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.printf("Server accepting connections on port %d %n", port);

        // wait for and then accept client connection
        // a socket is created to handle the created connection
        Socket clientSocket = serverSocket.accept();
        System.out.printf("Connected to client %s on port %d %n",
            clientSocket.getInetAddress().getHostAddress(), clientSocket.getPort());

        
        FileReceiver receiver = new FileReceiver(clientSocket, filePath); 
    	receiver.transfer();
       
        // Close connection to current client
        clientSocket.close();
        System.out.println("Closed connection with client");

        // Close server socket
        serverSocket.close();
        System.out.println("Closed server socket");
    }
}
