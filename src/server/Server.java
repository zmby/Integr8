package server;

import java.net.*;
import java.io.IOException;


//Class for starting the server.
public class Server implements Runnable {

	private ServerSocket serverSocket;
	private int serverPort;
	private boolean isActive = false;
	private Thread runningThread;
	
	public Server(int port) {
		serverPort = port;
	}
	
	private void openServerSocket(){
		try {
			serverSocket = new ServerSocket(serverPort);
		}
		catch(Exception e){
			throw new RuntimeException("Error opening Serversocket!", e);
		}
	}
	
	@Override
	public void run() {
		synchronized(this){
			this.runningThread = Thread.currentThread();
		}
		openServerSocket();
		while(isActive){
			Socket clientSocket = null;
			try {
				clientSocket = serverSocket.accept();
			} catch(IOException e){
				if(!isActive){
					System.out.println("Server stopped");
					return;
				}
				throw new RuntimeException("Cannot accept client connection",e);
			}
			new Thread(new SConnectionHandler(clientSocket)).start();;
			
		}
		
		
	}
	
	
	public synchronized void stopServer(){
		isActive = false;
		try {
			serverSocket.close();
		} catch(IOException e){
			throw new RuntimeException("Cannot close server",e);
		}
	}
	
	
	
	
	

	
}
