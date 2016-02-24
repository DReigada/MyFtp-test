package myftp.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileReceiver extends ReaderSender {

	public FileReceiver(Socket sock, String filePath) throws FileNotFoundException, IOException{
		super(new BufferedInputStream(sock.getInputStream()),
				new BufferedOutputStream(new FileOutputStream(filePath)));
	}
}
