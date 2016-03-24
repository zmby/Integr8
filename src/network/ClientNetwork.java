package network;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

import server.SConnectionHandler;
import message.*;




public class ClientNetwork {
	
	private Inet4Address serverIP;
	private static Socket netSocket;
	private int sport;
	private ClientWorkThread clientWorker;
	private Thread runningSubThread;
	
	
	public ClientNetwork(byte[] ip, int port) throws IOException {
		
		Inet4Address serverIP = (Inet4Address) Inet4Address.getByAddress(ip);
		int sport = port;
		
	}
	
	
	public boolean connect() throws IOException {
		netSocket = new Socket(serverIP, sport);
		clientWorker = new ClientWorkThread(netSocket);
		runningSubThread = new Thread(clientWorker);
		runningSubThread.start();
		return true;
		
	}
	public void sendObject(Object o){
		clientWorker.sendObject(o);
	}



	
	
	
	//Inner Class for sending/receiving and managing Data calling ClientLogic methods
	
	private class ClientWorkThread implements Runnable{
		private Socket toServer;
		private ObjectOutputStream os;
		private ObjectInputStream is;
		private Thread runningThread;
		public ClientWorkThread(Socket toServer){
			this.toServer = toServer;
			try{
				os = new ObjectOutputStream(toServer.getOutputStream());
				is = new ObjectInputStream(toServer.getInputStream());
			} catch(IOException e){
				System.out.println("Couldn't initialize Stream to Server");
			}
		}
		public void sendObject(Object o){
			try {
				os.writeObject(o);
			} catch (IOException e) {
				System.out.println("Client could not send Object!");
				e.printStackTrace();
			}
		}
		
		//Method for dealing with incoming objects! Used to call ClientLogik methods!
		
		private synchronized void readObject(Object o){
			if(o instanceof FLMessage){
				FLMessage f = (FLMessage) o;
				ArrayList<User> li = f.getList();
				ClientLogic.receiveFriendsList(li);
			}
			if(o instanceof UserChatMessage){
				//toComplete
				
			}
			if(o instanceof UserMessage){
				//toComplete
			}
			
		}
		public Thread getCurrent(){
			return runningThread;
		}
		@Override
		public void run() {
			synchronized(this){
				this.runningThread = Thread.currentThread();
			}
			while(toServer.isConnected()){
				try {
					Object input = is.readObject();
					readObject(input);
					
				} catch (ClassNotFoundException e) {
					System.out.println("Clientsent object not found! Check Versions!");
					try {
						toServer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
				
				  catch (IOException e) {
					e.printStackTrace();
					try {
						toServer.close();
					} catch (IOException e1) {
					
						e1.printStackTrace();
					}
					
				}
				
				
			}
				
				
				
			}
			
		}
}
