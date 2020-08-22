package group5.customerLoginSignup.dto;

public class CustomerDTO {
	
	private int customerId;
	private String name;
	private String gender;
	private String email;
	private String mobileNumber;
	private String password;
	private boolean isActive;
	
	public CustomerDTO() {
		super();
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", gender=" + gender + " , email=" + email + ", mobileNumber="
				+ mobileNumber + ", password=" + password + ", isActive=" + isActive + "]";
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
