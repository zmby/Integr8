package message;

import network.User;

public class UserChatMessage {
	private User user;
	private String msg;
	public UserChatMessage(User u, String s){
		user = u;
		msg = s;
	}
	public User getUser(){
		return user;
	}
	public String getMessage(){
		return msg;
	}
}
