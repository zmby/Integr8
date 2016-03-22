package server;

import java.net.*;
import java.util.Vector;

public class Server implements Runnable{

	private Socket socket;
	private boolean active;
	private Vector clients;
	private ServerSocket ssocket;
	private StartServerThread sst;
	
	
	private class StartServerThread extends Thread {
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
