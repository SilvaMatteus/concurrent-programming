package nanohttp;

import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class SocketConsumer implements Runnable{
	
	private final BlockingQueue<Socket> q;
	
	private final NanoHTTPd SERVER;
	
	public SocketConsumer(NanoHTTPd server, BlockingQueue<Socket> queue) {
		this.SERVER = server;
		this.q = queue;
	}

	@Override
	public void run() {
		try {
	       while (true) {
	    	   Socket s = q.take();
	    	   SERVER.new HTTPSession(s);
	       }
	     } catch (InterruptedException ex) { }
	}
}
