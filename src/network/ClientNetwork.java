package network;

import java.io.IOException;
import java.io.Serializable;
import java.net.*;



public class ClientNetwork implements Runnable {
	private Inet4Address serverIP;
	private Socket netSocket;
	private int sport;
	
	public ClientNetwork(byte[] ip, int port) throws UnknownHostException {
		
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
		try {
			while (connect()){
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
