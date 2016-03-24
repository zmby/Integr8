package network;

import java.util.ArrayList;
import java.util.List;

import message.*;
//Contains all the ClientLogic 
public final class ClientLogic {
	
	
	private static List<User> friendsList;
	private static ClientNetwork network;
	private static User currentUser;
	
	
	
	public ClientLogic(ClientNetwork m, User curUser){
		friendsList = new ArrayList<User>();
		network = m;
		currentUser = curUser;
	}
	
	//Adds Users to the FriendsList
	public static boolean addUserToFL(User u){
		friendsList.add(u);
		return true;
	}
	
	//Requests a completly new Friendslist
	public static void requestFL(){
		network.sendObject(new ReqFriendsListMessage(currentUser));
	}
	public static void receiveFriendsList(ArrayList<User> friends){
		for(User u : friends ){
			ClientLogic.addUserToFL(u);
		}
		
	}
}
