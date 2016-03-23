package server;
import java.net.*;

//Class for main Server Logic
public class SConnectionHandler implements Runnable{
	private Socket clientSocket = null;
	
	public SConnectionHandler(Socket client){
		clientSocket = client;
	}
	
	
	@Override
	public void run() {
		
		
	}
	
	

	
	
	
}
