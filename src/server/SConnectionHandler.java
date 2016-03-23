package server;
import java.net.*;
import java.io.*;

import message.*;


//Class for reading/writing to/from Clients
public class SConnectionHandler implements Runnable{
	private Socket clientSocket = null;
	private ObjectInputStream in;
	private ObjectOutputStream ou;
	
	public SConnectionHandler(Socket client){
		clientSocket = client;
		try {
			in = new ObjectInputStream(clientSocket.getInputStream());
			ou = new ObjectOutputStream(clientSocket.getOutputStream());
			}
			catch(IOException e){
			System.out.println("Error at creating ObjectStreams");	
			}
	}
	
	
	@Override
	public void run() {
		
		while(clientSocket.isConnected()){
			try {
				Object input = in.readObject();
				readObject(input);
			} catch (ClassNotFoundException e) {
				System.out.println("Clientsent object not found! Check Versions!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	
	public void readObject(Object o){
		
		if(o instanceof LoginMessage){
			ServerLogic.userauth((LoginMessage) o);
		}
		if(o instanceof UserMessage){
			
		}
		
		
	}
	
	
	public void writeObject(Object o){
		
		
	}
	
	

	
	
	
}
