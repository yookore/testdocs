import static org.junit.Assert.*;

import java.util.HashMap;

import models.User;

import org.junit.Test;


public class VerificationTest {
	private Verification verify = new Verification();
	@Test
	public void testSmsVerifyUser() {
		String verificationCode = "verif123";
		
		User user = new User();
		
		user.setEmail("john@yookos.com");
		user.setFirstname("John");
		user.setLastname("Baptist");
		user.setCountry("Egypt");
		user.setVerified(true);
		
		HashMap<String,String> actual = new HashMap<String, String>();
		
		actual.put("email", user.getEmail());
		actual.put("cellphone", user.getCellphone());
		actual.put("firstname", user.getFirstname());
		actual.put("lastname", user.getLastname());
		actual.put("country", user.getCountry());
		actual.put("verified", "true");
		
		assertEquals("Sms verify User returned unexpected response",
				verify.smsVerifyUser(verificationCode), actual);
	}

	@Test
	public void testEmailVerifyUser() {
		String verificationCode = "verif123";
		User user = new User();
		
		user.setEmail("john@yookos.com");
		user.setFirstname("John");
		user.setLastname("Baptist");
		user.setCountry("Egypt");
		user.setVerified(true);
		
		HashMap<String,String> actual = new HashMap<String, String>();
		
		actual.put("email", user.getEmail());
		actual.put("cellphone", user.getCellphone());
		actual.put("firstname", user.getFirstname());
		actual.put("lastname", user.getLastname());
		actual.put("country", user.getCountry());
		actual.put("verified", "true");
		
		assertEquals("Email verify user returned unexpected response",
				verify.emailVerifyUser(verificationCode), actual);
	}

	@Test
	public void testEmailVerifyAccessToken() {
		String userId = "johnbap";
		String password = "password";
		
		HashMap<String,String> verifiedUser = new HashMap<String,String>();
		verifiedUser.put("access_token", "123");
		verifiedUser.put("sessionid","321");
		verifiedUser.put("firstname", "John");
		verifiedUser.put("lastname", "Baptist");
		verifiedUser.put("clientid","213");
		verifiedUser.put("refresh_token", "312");
		
		assertEquals("Email verify user returned unexpected response",
				verify.emailVerifyAccessToken(userId, password), verifiedUser);
	}

	@Test
	public void testEmailPhoneVerifyUser() {
		String email = "john@yookos.com";
		String cellphone = "+278497";
		
		User user = new User();
		
		user.setEmail(email);
		user.setFirstname("John");
		user.setLastname("Baptist");
		user.setCountry("Egypt");
		user.setVerified(true);
		
		HashMap<String,String> actual = new HashMap<String, String>();
		
		actual.put("email", user.getEmail());
		actual.put("cellphone", user.getCellphone());
		actual.put("firstname", user.getFirstname());
		actual.put("lastname", user.getLastname());
		actual.put("country", user.getCountry());
		actual.put("verified", "true");
		
		assertEquals("Email verify user returned unexpected response",
				verify.emailPhoneVerifyUser(email, cellphone), actual);
	}

}
