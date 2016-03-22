package network;

import java.io.IOException;
import java.io.Serializable;
import java.net.*;



public class ClientNetwork implements Runnable {
	private Inet4Address serverIP;
	private static Socket netSocket;
	private int sport;
	
	public ClientNetwork(byte[] ip, int port, int param) throws IOException {
		
		Inet4Address serverIP = (Inet4Address) Inet4Address.getByAddress(ip);
		int sport = port;
		
	}
	
	public boolean connect() throws IOException{
		netSocket = new Socket(serverIP, sport);
		if(netSocket.isConnected()){
			netSocket.setKeepAlive(true);
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public void run() {

		System.out.println("lel");
		System.out.println("lel");
		System.out.println("lel");
		System.out.println("lel");
		System.out.println("lel");

		
	}

	
}
