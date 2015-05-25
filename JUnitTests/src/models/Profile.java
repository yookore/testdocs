package models;

public class Profile {
	private String currentCity;
	private String homeCountry;
	private String homeTown;
	private String relationshipStatus;
	private String interests;
	
	public Profile(String currentCity, String homeCountry, String homeTown,
			String relationshipStatus, String interests) {
		super();
		this.currentCity = currentCity;
		this.homeCountry = homeCountry;
		this.homeTown = homeTown;
		this.relationshipStatus = relationshipStatus;
		this.interests = interests;
	}
	
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getHomeCountry() {
		return homeCountry;
	}
	public void setHomeCountry(String homeCountry) {
		this.homeCountry = homeCountry;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	
	
}
