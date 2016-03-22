package message;

import network.User;



public class LoginMessage extends ServerMessage {
	private User userlogin;
	private static final long serialVersionUID = 1L;
	public LoginMessage(User userlogin){
		this.userlogin = userlogin;
	}
	public User getUser(){
		return userlogin;
	}
}
