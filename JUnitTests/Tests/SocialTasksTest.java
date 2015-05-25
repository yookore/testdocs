import static org.junit.Assert.*;

import java.util.HashMap;

import models.User;

import org.junit.Test;


public class SocialTasksTest {
	SocialTasks socialTask = new SocialTasks();
	
	@Test
	public void testCreateSocialAccount() {
		String firstname = "John";
		String lastname = "Baptist";
		String email = "john@yookos.com";
		String country = "Egypt";
		String dob = "1979/05/17";
		String cellphone = "+278497";
		String gender = "Male";
		String password = "password";
		boolean verified = false;
		String locale = "GMT+2";
		int timezone = 2;
		String updated = "17/05/2015";
		String fullnames = "John Baptist";
		
		User newUser = new User(firstname, lastname, email, country, dob, cellphone, gender, password,
				verified, locale, timezone, updated, fullnames);
		
		User user = new User();
		
		user.setEmail(newUser.getEmail());
		user.setCellphone(newUser.getCellphone());
		user.setFirstname(newUser.getFirstname());
		user.setLastname(newUser.getLastname());
		
		HashMap<String,String> actual = new HashMap<String, String>();
		
		
		actual.put("email", user.getEmail());
		actual.put("cellphone", user.getCellphone());
		actual.put("firstname", user.getFirstname());
		actual.put("lastname", user.getLastname());
		
		assertEquals("Social Creating an Account returned unexpected response",
				socialTask.createSocialAccount(firstname, lastname, email, country, dob, cellphone, 
						gender, password, verified, locale, timezone, updated, fullnames), actual);
	}

	@Test
	public void testSocialLogin() {
		String socialProviderEmail = "johnbap@yookos.com";
		String password = "password";
		HashMap<String,String> authenticatedUser = new HashMap<String,String>();
		authenticatedUser.put("email", socialProviderEmail);
		authenticatedUser.put("cellphone", "+278497");
		authenticatedUser.put("firstname", "John");
		authenticatedUser.put("lastname", "Baptist");
		authenticatedUser.put("username", "johnbap");
		authenticatedUser.put("profileimageurl", "https://profileimageurl");
		
		assertEquals("Social logging in returned unexpected response",
				socialTask.socialLogin(socialProviderEmail, password), authenticatedUser);
	}

}
