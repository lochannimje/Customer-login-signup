package group5.customerLoginSignup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "address_id", nullable = false)
	private int addressId;
	
	@Column(name = "street",nullable = false)
	private String street;
	
	@Column(name = "house",nullable = false)
	private String house;
	
	@Column(name = "district",nullable = false)
	private String district;
	
	@Column(name = "state",nullable = false)
	private String state;
	
	@Column(name = "landmark",nullable = false)
	private String landmark;
	
	@Column(name = "pincode",nullable = false)
	private int pincode;
	
	public AddressEntity() {
		super();
	}

	@Override
	public String toString() {
		return "Address [address_id=" + addressId + ", street=" + street + ", house=" + house + " , district=" + district + ", state="
				+ state + ", landmark=" + landmark + ", pincode=" + pincode + "]";
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
	
	public String getLandMark() {
		return landmark;
	}
	
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	public int getPinCode() {
		return pincode;
	}
	
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	

}
