package models;

public class User {
	private String firstname;
	private String lastname;
	private String email;
	private String country;
	private String dob;
	private String cellphone;
	private String gender;
	private String password;
	private int externalId;
	private String provider;
	private boolean verified;
	private String locale;
	private int timezone;
	private String updated;
	private String fullnames;
	
	
	public User() {
		super();
	}

	public User(String firstname, String lastname, String email,
			String country, String dob, String cellphone, String gender,
			String password,boolean verified, String locale, int timezone, String updated,
			String fullnames) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.dob = dob;
		this.cellphone = cellphone;
		this.gender = gender;
		this.password = password;
		this.verified = verified;
		this.locale = locale;
		this.timezone = timezone;
		this.updated = updated;
		this.fullnames = fullnames;
	}
	
	public User(String firstname, String lastname, String email,
			String country, String dob, String cellphone, String gender,
			String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.dob = dob;
		this.cellphone = cellphone;
		this.gender = gender;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getExternalId() {
		return externalId;
	}

	public void setExternalId(int externalId) {
		this.externalId = externalId;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getFullnames() {
		return fullnames;
	}

	public void setFullnames(String fullnames) {
		this.fullnames = fullnames;
	}
	
	

}
