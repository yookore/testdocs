import static org.junit.Assert.*;

import java.util.HashMap;

import models.Profile;

import org.junit.Test;


public class ProfileManagerTest {
	private ProfileManager profileManager = new ProfileManager();

	@Test
	public void testUpdateProfileNative() {
		String currentCity ="Egypt City";
		String homeCountry = "Eqypt";
		String homeTown = "Galilee";
		String relationshipStatus = "Single";
		String interests = "Jesus";
		
		HashMap<String,String> basicProfile = new HashMap<String,String>();
		Profile updatedProfile = new Profile(currentCity, homeCountry, homeTown, relationshipStatus, interests);
		basicProfile.put("userid", "23");
		basicProfile.put("sessionid", "321");
		
		assertEquals("Updating profile returned unexpected response",
				profileManager.updateProfileNative(currentCity, homeCountry, homeTown, relationshipStatus, interests)
				, basicProfile);
	}
	@Test
	public void testUpdateProfileResponsiveWeb() {
		String currentCity ="Egypt City";
		String homeCountry = "Eqypt";
		String homeTown = "Galilee";
		String relationshipStatus = "Single";
		String interests = "Jesus";
		
		HashMap<String,String> basicProfile = new HashMap<String,String>();
		Profile updatedProfile = new Profile(currentCity, homeCountry, homeTown, relationshipStatus, interests);
		basicProfile.put("userid", "23");
		basicProfile.put("sessionid", "321");
		
		String email = "john@yookos.com";
		String dob = "1950/05/17";
		String currentCountry = "Egypt";
		String biography = "Jesus's deciple";
		String cellphone = "+278497";
		String firstname = "John";
		String lastname = "Baptist";
		String gender = "Male";
		String alternativeemail = "john@gmail.com";
		String timezone = "Africa";
		String imagUrl =  "https://imageurl";
		String title = "Apostle";
		String lastUpdated = "17/05/2015";
		String username = "johnbap";
		assertEquals("Updating profile returned unexpected response",
				profileManager.updateProfileResponsiveWeb(email, dob, relationshipStatus, currentCountry, biography, cellphone, firstname, lastname, gender, alternativeemail, homeCountry, timezone, imagUrl, title, lastUpdated, homeTown, username, interests, currentCity)
				, basicProfile);
	}
	@Test
	public void testProfilePicRequest() {
		String imageUrl = "imgUrl"; 
		String username = "johnbap";
		
		HashMap<String,String> basicProfile = new HashMap<String,String>();
		basicProfile.put("userid", "23");
		basicProfile.put("sessionid", "321");
		
		assertEquals("Updating profile returned unexpected response",
				profileManager.profilePicRequest(imageUrl, username)
				, basicProfile);
	}

	@Test
	public void testGetProfile() {
		String username = "johnbap";
		
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
		
		assertEquals("Updating profile returned unexpected response",
				profileManager.getProfile(username)
				, profile);
	}

}
