package network;

//Baseclass for User objects, contains information of Users
public class User  {
	private int userId;
	private String userLoginName;
	private String userName;
	private String userLastName;
	private String userMail;
	private String userPassword;
	private String userSkypeName;
	
	
	
	//Constructors for creating userobjects
	public User(){
		
	}
	public User(int userId ){
		this.userId = userId;
	}
	
	public void setLoginName(String loginName){
		this.userLoginName = loginName;
	}
	public void setName(String userName){
		this.userName = userName;
	}
	public void setLastName(String userLastName){
		this.userLastName = userLastName;
	}
	public void setUserMail(String userMail){
		this.userMail = userMail;
	}
	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}
	public void setUserSkypeName(String userSkypeName){
		this.userSkypeName = userSkypeName;
	}
	public int getUserId(){
		return userId;
	}
	public String getUserLoginName(){
		return userLoginName;
	}
	public String getUserName(){
		return userName;
	}
	public String getUserLastName(){
		return userLastName;
	}
	public String getUserMail(){
		return userMail;
	}
	public String getUserPassword(){
		return userPassword;
	}
	public String getUserSkypeName(){
		return userSkypeName;
	}
}
