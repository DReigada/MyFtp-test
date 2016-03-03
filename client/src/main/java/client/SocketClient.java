package client;

import java.io.IOException;
import java.net.Socket;

import myftp.core.FileReceiver;
import myftp.core.FileSender;
import myftp.core.ReaderSender;


public class SocketClient {

    public static void main( String[] args ) throws IOException {
        // Check arguments
        if (args.length != 4) {
            System.err.println("Argument(s) missing!");
            System.err.printf("Usage: java %s host port mode filepath%n", SocketClient.class.getName());
            return;
        }

        String host = args[0];
        // Convert port from String to int
        int port = Integer.parseInt(args[1]);
        int mode = Integer.parseInt(args[2]);
        String filePath = args[3];
      
        if(mode != 0 && mode != 1){
        	System.err.printf("Please insert a valid mode (0-receive, 1-send)");
        	return;
        }

        // Create client socket
        Socket socket = new Socket(host, port);
        System.out.printf("Connected to server %s on port %d %n", host, port);
        
        ReaderSender transferer;
        switch (mode){
        	case 0: //receive mode
        		transferer = new FileReceiver(socket, filePath);
        		break;
        	case 1: // send mode
        		transferer = new FileSender(socket, filePath);
        		break;
        	default: return;
        }
        
        System.out.print("Starting to transfer the file... \n");
        long transferTime = transferer.transfer();
        System.out.printf("Finished transfering file. Elapsed time: " + transferTime/1000 + "," + transferTime%1000 + "s\n");
        
        // Close client socket
        socket.close();
        System.out.println("Connection closed");
    }
}
