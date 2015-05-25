import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.User;

import org.junit.Test;


public class FriendsTasksTest {
	private FriendsTasks friendsTasks = new FriendsTasks();

	@Test
	public void testBlockFriend() {
		String username = "johnbap"; String targetUsername = "ginald";
		//System.out.println("Block Friend");
		HashMap<String, String> actual = new HashMap<String, String>();
		actual.put("username", targetUsername);
		actual.put("status", "blocked");
		assertEquals("Blocking a Friend returned unexpected response",
				friendsTasks.blockFriend(username, targetUsername), actual);
	}

	@Test
	public void testSendFriendRequest() {
		String username = "johnbap"; String targetUsername = "ginald";
		HashMap<String, String> actual = new HashMap<String, String>();
		actual.put("username", targetUsername);
		actual.put("status", "pending");
		assertEquals("Sending a Friend request returned unexpected response",
				friendsTasks.sendFriendRequest(username, targetUsername), actual);
	}

	@Test
	public void testInviteFriend() {
		String email = "johnbap@yookos.com";
		HashMap<String, String> actual = new HashMap<String, String>();
		actual.put("status", "sent");
		assertEquals("Blocking a Friend returned unexpected response",
				friendsTasks.inviteFriend(email), actual);
	}

	@Test
	public void testFindFriendRequest() {
		HashMap<String,String> actual = new HashMap<String, String>();
		User user = new User();
		
		user.setEmail("john@yookos.com");
		user.setFirstname("John");
		user.setLastname("Baptist");
		
		actual.put("email", user.getEmail());
		actual.put("firstname", user.getFirstname());
		actual.put("lastname", user.getLastname());
		
		assertEquals("Finding a Friend returned unexpected response",
				friendsTasks.findFriendRequest("friendRequests"), actual);
	}

	@Test
	public void testUserExists() {
		String email = "john@yookos.com";
		HashMap<String,String> actual = new HashMap<String, String>();
		User user = new User();
		
		user.setEmail(email);
		user.setFirstname("John");
		user.setLastname("Baptist");
		
		actual.put("email", user.getEmail());
		actual.put("firstname", user.getFirstname());
		actual.put("lastname", user.getLastname());
		
		assertEquals("Finding a Friend returned unexpected response",
				friendsTasks.userExists(email), actual);
	}

	@Test
	public void testGetListOfFriends() {
		String username = "johnbap";
		String filter = "all";
		HashMap<String,Object> actual = new HashMap<String, Object>();
		List<HashMap<String,String>> friendsList = new ArrayList<HashMap<String,String>>();
		
		actual.put("list", friendsList);
		actual.put("username", username);
		actual.put("friendaccount", "");
		
		assertEquals("Finding a Friend returned unexpected response",
				friendsTasks.getListOfFriends(username, filter), actual);
	}

	@Test
	public void testAcceptFriend() {
		String username = "johnbap"; String targetUsername = "ginald";
		HashMap<String, String> actual = new HashMap<String, String>();
		actual.put("username", targetUsername);
		actual.put("status", "accepted");
		assertEquals("Accepting Friend request returned unexpected response",
				friendsTasks.acceptFriend(username, targetUsername), actual);
	}

	@Test
	public void testRejectFriend() {
		String username = "johnbap"; String targetUsername = "ginald";
		HashMap<String, String> actual = new HashMap<String, String>();
		actual.put("username", targetUsername);
		actual.put("status", "rejected");
		assertEquals("Rejecting a Friend request returned unexpected response",
				friendsTasks.rejectFriend(username, targetUsername), actual);
	}

}
