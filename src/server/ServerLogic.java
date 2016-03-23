package server;

import message.*;

//Utility class for dealing with messages
public final class ServerLogic {

	private ServerLogic(){
		
	}
	
	public static boolean userauth(LoginMessage m){
		//Example for Logic, Datenbasestuff here
		if(m.getUser().getUserLoginName() == "HansApfel"){
			
		}
		
		
		return true;
	}
	
	public static boolean receiveUser(UserMessage m){
		//Datenbasestuff here
		return true;
	}
	public static boolean receiveUserChat(UserChatMessage m){
		//Datenbasestuff here
		return true;
	}
	
	
	
	
	
	
	
}
