package message;
import network.User;
import java.io.Serializable;

public class ReqFriendsListMessage implements Serializable {
 private User requester;
 public ReqFriendsListMessage(User req){
	 requester = req;
 }
 public User getUser(){
	 return requester;
 }
}
