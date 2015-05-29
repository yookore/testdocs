import java.util.HashMap;

import models.User;


public class Verification {

	public HashMap<String,String> smsVerifyUser(String verificationCode)
	{
		User user = new User();
		
		user.setEmail("john@yookos.com");
		user.setFirstname("John");
		user.setLastname("Baptist");
		user.setCountry("Egypt");
		user.setVerified(true);
		
		HashMap<String,String> verifiedUser = new HashMap<String, String>();
		
		verifiedUser.put("email", user.getEmail());
		verifiedUser.put("cellphone", user.getCellphone());
		verifiedUser.put("firstname", user.getFirstname());
		verifiedUser.put("lastname", user.getLastname());
		verifiedUser.put("country", user.getCountry());
		verifiedUser.put("verified", "true");
		
		return verifiedUser;
	}

	public HashMap<String,String> emailVerifyUser(String verificationCode)
	{
		User user = new User();
		
		user.setEmail("john@yookos.com");
		user.setFirstname("John");
		user.setLastname("Baptist");
		user.setCountry("Egypt");
		user.setVerified(true);
		
		HashMap<String,String> verifiedUser = new HashMap<String, String>();
		
		verifiedUser.put("email", user.getEmail());
		verifiedUser.put("cellphone", user.getCellphone());
		verifiedUser.put("firstname", user.getFirstname());
		verifiedUser.put("lastname", user.getLastname());
		verifiedUser.put("country", user.getCountry());
		verifiedUser.put("verified", "true");
		
		return verifiedUser;
	}

	public HashMap<String,String> emailVerifyAccessToken(String userId, String password)
	{
		HashMap<String,String> verifiedUser = new HashMap<String,String>();
		verifiedUser.put("access_token", "123");
		verifiedUser.put("sessionid","321");
		verifiedUser.put("firstname", "John");
		verifiedUser.put("lastname", "Baptist");
		verifiedUser.put("clientid","213");
		verifiedUser.put("refresh_token", "312");
		
		return verifiedUser;
	}

	public HashMap<String,String> emailPhoneVerifyUser(String email, String cellphone)
	{
		User user = new User();
		
		user.setEmail(email);
		user.setFirstname("John");
		user.setLastname("Baptist");
		user.setCountry("Egypt");
		user.setVerified(true);
		
		HashMap<String,String> verifiedUser = new HashMap<String, String>();
		
		verifiedUser.put("email", user.getEmail());
		verifiedUser.put("cellphone", user.getCellphone());
		verifiedUser.put("firstname", user.getFirstname());
		verifiedUser.put("lastname", user.getLastname());
		verifiedUser.put("country", user.getCountry());
		verifiedUser.put("verified", "true");
		
		return verifiedUser;
	}

}
