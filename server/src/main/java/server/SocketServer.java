package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import myftp.core.FileReceiver;
import myftp.core.FileSender;
import myftp.core.ReaderSender;


public class SocketServer
{
    public static void main( String[] args ) throws IOException {
        // Check arguments
        if (args.length != 3) {
            System.err.println("Argument(s) missing!");
            System.err.printf("Usage: java %s port mode filepath%n", SocketServer.class.getName());
            return;
        }

        // Convert port from String to int
        int port = Integer.parseInt(args[0]);
        int mode = Integer.parseInt(args[1]);
        String filePath = args[2];
        
        if(mode != 0 && mode != 1){
        	System.err.printf("Please insert a valid mode (0-receive, 1-send)");
        	return;
        }

        // Create server socket
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.printf("Server accepting connections on port %d %n", port);

        // wait for and then accept client connection
        // a socket is created to handle the created connection
        Socket clientSocket = serverSocket.accept();
        System.out.printf("Connected to client %s on port %d %n",
            clientSocket.getInetAddress().getHostAddress(), clientSocket.getPort());

        ReaderSender transferer;
        switch (mode){
        	case 0: // receive mode
        		transferer = new FileReceiver(clientSocket, filePath);
        		break;
        	case 1: // send mode
        		transferer = new FileSender(clientSocket, filePath);
        		break;
        	default: return;
        }
        
        System.out.print("Starting to transfer the file... \n");
        long transferTime = transferer.transfer();
        System.out.printf("Finished transfering file. Elapsed time: " + transferTime/1000 + "," + transferTime%1000 + "s\n");
        
        // Close connection to current client
        clientSocket.close();
        System.out.println("Closed connection with client");

        // Close server socket
        serverSocket.close();
        System.out.println("Closed server socket");
    }
}
