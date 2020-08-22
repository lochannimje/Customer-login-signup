package group5.customerLoginSignup.repository;

import org.springframework.data.repository.CrudRepository;
import group5.customerLoginSignup.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
	
	public CustomerEntity findByCustomerId(int Id);
	public CustomerEntity findByEmail(String emailId);
	public CustomerEntity findByMobileNumber(String mobileNumber);

}
