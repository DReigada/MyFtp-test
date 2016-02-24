package example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;


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
        
        
        // Create stream to receive data from server
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath));
        
        // Create stream to send data to server
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        
        
        byte[] buf = new byte[1024];
        int bytesRead;
      	while((bytesRead = in.read(buf)) > 0){
        	out.write(buf);
        }
      	out.flush();

      	System.in.read();
        // Receive the confirmation message from the server
        /*String confirmationMessage = in.readLine();
        System.out.printf("Confirmation message received: %s%n", confirmationMessage);*/
        

        // Close client socket
        socket.close();
        in.close();
        System.out.println("Connection closed");
    }
}
