import java.util.HashMap;

import models.Profile;


public class ProfileManager {
	
	public HashMap<String,String> updateProfileNative(String currentCity, String homeCountry, String homeTown,
			String relationshipStatus, String interests)
	{
		HashMap<String,String> basicProfile = new HashMap<String,String>();
		Profile updatedProfile = new Profile(currentCity, homeCountry, homeTown, relationshipStatus, interests);
		basicProfile.put("userid", "23");
		basicProfile.put("sessionid", "321");
		return basicProfile;
	}
	
	public HashMap<String,String> updateProfileResponsiveWeb(String email, String dob, String relationshipStatus,
			String currentCountry, String biography, String cellphone, String firstname, String lastname, 
			String gender, String alternativeemail, String homeCountry, String timezone, String imagUrl, String title,
			String lastUpdated, String homeTown, String username, String interests, String currentCity)
	{
		HashMap<String,String> message = new HashMap<String,String>();
		message.put("userid", "23");
		message.put("sessionid", "321");
		return message;
	}
	
	public HashMap<String,String> profilePicRequest(String imageUrl, String username)
	{
		HashMap<String,String> basicProfile = new HashMap<String,String>();
		basicProfile.put("userid", "23");
		basicProfile.put("sessionid", "321");
		return basicProfile;
	}

	public HashMap<String,String> getProfile(String username)
	{
		HashMap<String,String> profile = new HashMap<String,String>();
		profile.put("email","john@yookos.com");
		profile.put("dob", "1950/05/17");
		profile.put("relationshipstatus", "single");
		profile.put("currentcountry", "Egypt");
		profile.put("biography", "Jesus's deciple");
		profile.put("cellphone", "+278497");
		profile.put("firstname", "John");
		profile.put("lastname", "Baptist");
		profile.put("gender", "Male");
		profile.put("alternativeemai", "john@gmail.com");
		profile.put("homecountry", "Egypt");
		profile.put("timezone", "Africa");
		profile.put("imageurl", "https://imageurl");
		profile.put("title", "Apostle");
		profile.put("lastupdated", "17/05/2015");
		profile.put("hometown", "Galilee");
		profile.put("currentcity", "Egypt City");
		profile.put("username", "johnbap");
		profile.put("interests", "Jesus");
		return profile;
	}
}
