package example;

import java.io.IOException;
import java.net.Socket;

import myftp.core.FileSender;


public class SocketClient {

    public static void main( String[] args ) throws IOException {
        // Check arguments
        if (args.length != 3) {
            System.err.println("Argument(s) missing!");
            System.err.printf("Usage: java %s host port filepath%n", SocketClient.class.getName());
            return;
        }

        String host = args[0];
        // Convert port from String to int
        int port = Integer.parseInt(args[1]);
        String filePath = args[2];
      

        // Create client socket
        Socket socket = new Socket(host, port);
        System.out.printf("Connected to server %s on port %d %n", host, port);
        
        FileSender sender = new FileSender(socket, filePath);
        sender.transfer();
        
        // Close client socket
        socket.close();
        System.out.println("Connection closed");
    }
}
