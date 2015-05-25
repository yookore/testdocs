import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.User;


public class FriendsTasks {
	public HashMap<String, String> blockFriend(String username, String targetUsername)
	{
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("username", targetUsername);
		response.put("status", "blocked");
		return response;
	}
	
	public HashMap<String, String> sendFriendRequest(String username, String targetUsername)
	{
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("username", targetUsername);
		response.put("status", "pending");
		return response;
	}
	
	public HashMap<String,String> inviteFriend(String email){
		HashMap<String,String> response = new HashMap<String,String>();
		response.put("status","sent");
		return response;
	}
	
	public HashMap<String, String> findFriendRequest(String friends)
	{
		HashMap<String,String> invitedUser = new HashMap<String, String>();
		User user = new User();
		
		user.setEmail("john@yookos.com");
		user.setFirstname("John");
		user.setLastname("Baptist");
		
		invitedUser.put("email", user.getEmail());
		invitedUser.put("firstname", user.getFirstname());
		invitedUser.put("lastname", user.getLastname());
		
		return invitedUser;
	}
	
	public HashMap<String,String> userExists(String email)
	{
		HashMap<String,String> invitedUser = new HashMap<String, String>();
		User user = new User();
		
		user.setEmail(email);
		user.setFirstname("John");
		user.setLastname("Baptist");
		
		invitedUser.put("email", user.getEmail());
		invitedUser.put("firstname", user.getFirstname());
		invitedUser.put("lastname", user.getLastname());
		
		return invitedUser;
	}
	
	public HashMap<String,Object> getListOfFriends(String username, String filter)
	{
		HashMap<String,Object> friendsListResponse = new HashMap<String, Object>();
		List<HashMap<String,String>> friendsList = new ArrayList<HashMap<String,String>>();
		
		friendsListResponse.put("list", friendsList);
		friendsListResponse.put("username", username);
		friendsListResponse.put("friendaccount", "");
		
		return friendsListResponse;
	}
	
	public HashMap<String, String> acceptFriend(String username, String targetUsername)
	{
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("username", targetUsername);
		response.put("status", "accepted");
		return response;
	}
	
	public HashMap<String, String> rejectFriend(String username, String targetUsername)
	{
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("username", targetUsername);
		response.put("status", "rejected");
		return response;
	}
}
