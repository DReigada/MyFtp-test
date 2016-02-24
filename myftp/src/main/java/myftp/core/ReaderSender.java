package myftp.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

class ReaderSender {
	
	private BufferedInputStream _in;
	private BufferedOutputStream _out;
	
	ReaderSender(BufferedInputStream in, BufferedOutputStream out) {
		_in = in;
		_out = out;
	}
	
	public void transfer() throws IOException{
	    byte[] buf = new byte[1024];
	    int bytesRead;
	    
	  	while((bytesRead = _in.read(buf)) > 0){
	    	_out.write(buf, 0, bytesRead);
	    }
	  	_out.flush();
	}
	
}
