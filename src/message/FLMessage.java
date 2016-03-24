package message;

import java.io.Serializable;
import java.util.ArrayList;

import network.User;

public class FLMessage implements Serializable{
	private ArrayList<User> friends;
	public FLMessage(ArrayList<User> list){
		
	}
	public ArrayList<User> getList(){
		return friends;
	}


}
