package group5.customerLoginSignup.service;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import group5.customerLoginSignup.repository.CustomerRepository;
import group5.customerLoginSignup.dto.CustomerDTO;
import group5.customerLoginSignup.entity.CustomerEntity;
import group5.customerLoginSignup.exception.UserException;
import group5.customerLoginSignup.exception.WrongEmailException;
import group5.customerLoginSignup.exception.WrongPasswordException;
import group5.customerLoginSignup.exception.AlreadyEmailIdExistException;
import group5.customerLoginSignup.exception.AlreadyMobileNumberExistException;
import group5.customerLoginSignup.exception.InvalidEmailIdException;
import group5.customerLoginSignup.exception.InvalidNameException;
import group5.customerLoginSignup.exception.InvalidPasswordException;
import group5.customerLoginSignup.exception.InvalidMobileNumberException;


@Service
@PropertySource(value = { "classpath:configuration.properties" })
public class CustomerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	public void CustomerSignup(CustomerDTO customerDTO) throws Exception {
		LOGGER.info("Customer details are going to validate");
		validateCustomer(customerDTO);
		LOGGER.info("Customer details are validated successfully");
		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(customerDTO, customerEntity);
		customerRepository.save(customerEntity);
		LOGGER.info("Customer details are saved in DB successfully");
	}

		
	private void validateCustomer(CustomerDTO customerDTO) throws Exception {
			LOGGER.info("Customer details are being validated");
			// TODO Auto-generated method stub
			if(!isValidName(customerDTO.getName()))
				throw new InvalidNameException("CustomerSignup.INVALID_NAME");
			if(!isValidEmail(customerDTO.getEmail()))
				throw new InvalidEmailIdException("CustomerSignup.INVALID_EMAIL");
			if(!isValidMobileNumber(customerDTO.getMobileNumber()))
				throw new InvalidMobileNumberException("CustomerSignup.INVALID_PHONENUMBER");
			if(!isvalidPassword(customerDTO.getPassword()))
				throw new InvalidPasswordException("CustomerSignup.INVALID_PASSWORD");
			if(!isAlreadyMobileNumberExist(customerDTO.getMobileNumber()))
				throw new AlreadyMobileNumberExistException("CustomerSignup.ALREADY_PH_EXISTS");
			if(!isAlreadyEmailIdExist(customerDTO.getEmail()))
				throw new AlreadyEmailIdExistException("CustomerSignup.ALREADY_EMAIL_EXISTS");
	}
	
	private boolean isAlreadyEmailIdExist(String email) {
		
		CustomerEntity customerEntity=customerRepository.findByEmail(email);
		if (customerEntity!=null)
			return false;
		return true;
	}
	
	private boolean isAlreadyMobileNumberExist(String mobileNumber) {
		
		CustomerEntity customerEntity=customerRepository.findByMobileNumber(mobileNumber);
		if (customerEntity!=null)
			return false;
		return true;
	}

	private boolean isvalidPassword(String password) {
		
		return Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{7,20}$",password);
	}

	private boolean isValidMobileNumber(String mobileNumber) {
		
		return Pattern.matches("^\\d{10}$", mobileNumber);
	}

	private boolean isValidEmail(String email) {
		
		return Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$",email);
	}

	private boolean isValidName(String name) {
		
		return Pattern.matches("^[a-zA-Z]+[-a-zA-Z\\s]+([-a-zA-Z]+)$", name);
	}
	
	

	public void CustomerLogin(CustomerDTO customerDTO) throws UserException {

		CustomerEntity customerEntity = customerRepository.findByEmail(customerDTO.getEmail());
		if (customerEntity != null) {
			if (customerEntity.getPassword().equals(customerDTO.getPassword())) {
				
			} else {
				throw new WrongPasswordException("CustomerLogin.INVALID_PASSWORD");
			}

		} else {
			throw new WrongEmailException("CustomerLogin.INVALID_EMAILID");
		}

	}
	

}
