package myftp.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

public class FileSender extends ReaderSender{
	
	public FileSender(Socket sock, String filePath) throws FileNotFoundException, IOException{
		super(new BufferedInputStream(new FileInputStream(filePath)),
				new BufferedOutputStream(sock.getOutputStream()));
	}
}
