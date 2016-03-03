package myftp.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public abstract class ReaderSender {
	
	private BufferedInputStream _in;
	private BufferedOutputStream _out;
	
	ReaderSender(BufferedInputStream in, BufferedOutputStream out) {
		_in = in;
		_out = out;
	}
	
	public long transfer() throws IOException{
	    byte[] buf = new byte[1024];
	    int bytesRead;
	    long startTime = System.currentTimeMillis(); // the time before sending/receiving the data
	    
	  	while((bytesRead = _in.read(buf)) > 0){
	    	_out.write(buf, 0, bytesRead);
	    }
	  	_out.flush();
	  	
	  	long endTime = System.currentTimeMillis(); // the time after sending/receiving the data
	  	
	  	return endTime - startTime;
	}
	
}
