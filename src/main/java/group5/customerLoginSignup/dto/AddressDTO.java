package group5.customerLoginSignup.dto;

public class AddressDTO {
	
	private int addressId;
	private String street;
	private String house;
	private String district;
	private String state;
	private String landmark;
	private int pincode;
	private boolean isActive;
	
	public AddressDTO() {
		super();
	}

	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", street=" + street + ", house=" + house + " , district=" + district + ", state="
				+ state + ", landmark=" + landmark + ", pincode=" + pincode + ", isActive=" + isActive + "]";
	}
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
