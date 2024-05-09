package model;

public class profile {
	private String username;
    private String phoneNumber;
    private String email;
    private String address;
    private String dob;
    private String profileImageUrl;
	public profile(String username, String phoneNumber, String email, String address, String dob,
			String profileImageUrl) {
		super();
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.dob = dob;
		this.profileImageUrl = profileImageUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
    

}
