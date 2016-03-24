package message;

import java.io.Serializable;

import network.User;

public class UserMessage implements Serializable {
	private User user;
	public UserMessage(User u){
		user = u;
	}
	public User getUser(){
		return user;
	}
}
