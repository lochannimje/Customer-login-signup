package group5.customerLoginSignup.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import group5.customerLoginSignup.entity.AddressEntity;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", nullable = false, updatable = false)
	private int customerId;
	
	@Column(name = "customer_name",nullable = false)
	private String name;
	
	@Column(name = "gender",nullable = false)
	private String gender;
	
	@Column(name = "email_id",nullable = false)
	private String email;
	
	@Column(name = "mobile_no",nullable = false)
	private String mobileNumber;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "isactive")
	private boolean isActive;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false)
	private AddressEntity addressEntity;
	
	
	public CustomerEntity() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customerId + ", customer_name=" + name + ", gender=" + gender + " , email_id=" + email + ", mobile_no="
				+ mobileNumber + ", password=" + password + ", isActive=" + isActive + ", address_id=" + addressEntity + "]";
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
	
	public AddressEntity getAddressEntity() {
		return addressEntity;
	}
	
	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}
}
