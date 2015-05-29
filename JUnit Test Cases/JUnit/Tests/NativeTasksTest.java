import static org.junit.Assert.*;

import java.util.HashMap;

import models.User;

import org.junit.Test;


public class NativeTasksTest {
	private NativeTasks nativeTasks = new NativeTasks();
	
	@Test
	public void testCreateAccount() {
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
		
		assertEquals("Native Creating an Account returned unexpected response",
				nativeTasks.createAccount(firstname, lastname, email, country, dob, cellphone, 
						gender, password, verified, locale, timezone, updated, fullnames), actual);
	}

	@Test
	public void testNativeLogin() {
		String email= "john@yookos.com"; 
		String password = "password";
		HashMap<String,String> actual = new HashMap<String,String>();
		actual.put("email", email);
		actual.put("cellphone", "+278497");
		actual.put("firstname", "John");
		actual.put("lastname", "Baptist");
		actual.put("username", "johnbap");
		actual.put("profileimageurl", "https://profileimageurl");
		
		assertEquals("Native logging in returned unexpected response",
				nativeTasks.nativeLogin(email, password), actual);
	}

}
