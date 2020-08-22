package group5.customerLoginSignup.repository;

import org.springframework.data.repository.CrudRepository;

import group5.customerLoginSignup.entity.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {
	
//	public AddressEntity findByAddressId(int Id);
	public AddressEntity findByPincode(int pincode);
//	public AddressEntity findByMobileNumber(String mobileNumber);

}
