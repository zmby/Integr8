package message;

import java.io.Serializable;

import network.User;

//Used for creating new Users
public class CreateUserMessage implements Serializable {
	private User newUser;
	public CreateUserMessage(User user){
		newUser = user;
	}
	public User GetUser(){
		return newUser;
	}
}
