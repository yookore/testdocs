import java.util.HashMap;

import models.User;


public class NativeTasks {

	public HashMap<String,String> createAccount(String firstname, String lastname, String email,
			String country, String dob, String cellphone, String gender,
			String password,boolean verified, String locale, int timezone, String updated,
			String fullnames)
	{
		User newUser = new User(firstname, lastname, email, country, dob, cellphone, gender, password, verified, locale, timezone, updated, fullnames);
		
		User user = new User();
		
		user.setEmail(newUser.getEmail());
		user.setCellphone(newUser.getCellphone());
		user.setFirstname(newUser.getFirstname());
		user.setLastname(newUser.getLastname());
		
		HashMap<String,String> createdUser = new HashMap<String, String>();
		
		createdUser.put("email", user.getEmail());
		createdUser.put("cellphone", user.getCellphone());
		createdUser.put("firstname", user.getFirstname());
		createdUser.put("lastname", user.getLastname());
		
		return createdUser;
	}

	public HashMap<String,String> nativeLogin(String email, String password)
	{
		HashMap<String,String> authenticatedUser = new HashMap<String,String>();
		authenticatedUser.put("email", email);
		authenticatedUser.put("cellphone", "+278497");
		authenticatedUser.put("firstname", "John");
		authenticatedUser.put("lastname", "Baptist");
		authenticatedUser.put("username", "johnbap");
		authenticatedUser.put("profileimageurl", "https://profileimageurl");
		return authenticatedUser;
	}

}
