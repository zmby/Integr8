package message;

import network.User;

public class UserMessage {
	private User user;
	public UserMessage(User u){
		user = u;
	}
	public User getUser(){
		return user;
	}
}
