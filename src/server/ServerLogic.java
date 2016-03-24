package server;
import java.sql.*;
import java.util.ArrayList;

import network.User;
import message.*;

//Utility class for dealing with messages
public final class ServerLogic {

	private ServerLogic() throws SQLException{
		// Connection myConn = DriverManager.getConnection("mysql://localhost:3306/server, Username, Password");
		
	}
	
	public static boolean userauth(LoginMessage m){
		//Example for Logic, Datenbasestuff here
		if(m.getUser().getUserLoginName() == "HansApfel"){
		//	Statement myStmt = myConn.createStatement();
		//	ResultSet userName = myStmt.executeQuery("select LOGINNAME from USERS where ID is " + m.getUser().getUserId());
		}
		
		
		return true;
	}
	
	public static boolean receiveUserFLreq(UserMessage m){
		
		return true;
	}
	public static boolean receiveUserChat(UserChatMessage m){
		//Datenbasestuff here
		return true;
	}
	public static synchronized ArrayList<User> receiveUsersFriends(User m){
		return null;
	}
	public static boolean addnewUser(CreateUserMessage m){
		return true;
	}
	
	
	
	
	
	
}
