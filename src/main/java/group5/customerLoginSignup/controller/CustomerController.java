package group5.customerLoginSignup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import group5.customerLoginSignup.service.AddressService;
import group5.customerLoginSignup.service.CustomerService;
import group5.customerLoginSignup.dto.AddressDTO;
import group5.customerLoginSignup.dto.CustomerDTO;
import group5.customerLoginSignup.controller.CustomerController;

@RestController
@PropertySource("classpath:configuration.properties")
public class CustomerController {
	
	@Autowired
	CustomerService customerservice;
	
	@Autowired
	AddressService addressservice;

	@Autowired
	Environment environment;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping(value = "/customer/login")
	public ResponseEntity<String> customerLogin(@RequestBody CustomerDTO customerDTO) {

		ResponseEntity<String> responseEntity = null;

		try {
			
			customerservice.CustomerLogin(customerDTO);
			String successMessage = environment.getProperty("CustomerLogin.LOGIN_SUCCESS");
			responseEntity = new ResponseEntity<String>(successMessage, HttpStatus.OK);

		} catch (Exception exception) {
			LOGGER.error("Error: " + exception.getMessage(), exception);

			String errorMessage;

			if (exception.getMessage() == null) {
				errorMessage = environment.getProperty("General.EXCEPTION");
				responseEntity = new ResponseEntity<String>(errorMessage, HttpStatus.OK);
				return responseEntity;

			} else {
				errorMessage = environment.getProperty(exception.getMessage());

				if (errorMessage == null)
					errorMessage = environment.getProperty("General.EXCEPTION");
				responseEntity = new ResponseEntity<String>(errorMessage, HttpStatus.OK);
				return responseEntity;

			}
		}

		return responseEntity;
	}


	@PostMapping(value = "customer/signup")
	public ResponseEntity<String> customerSignup(@RequestBody CustomerDTO customerDTO) {
		ResponseEntity<String> responseEntity = null;

		try {
			
			LOGGER.info("Customer Registration is being done by "+customerDTO.getName());
			customerDTO.setActive(true);
			customerservice.CustomerSignup(customerDTO);
			String successMessage = environment.getProperty("BuyerRegistration.REGISTRATION_SUCCESS");
			responseEntity = new ResponseEntity<String>(successMessage, HttpStatus.OK);

		} catch (Exception exception) {
			LOGGER.error("Error: " + exception.getMessage(), exception);

			String errorMessage;

			if (exception.getMessage() == null) {
				errorMessage = environment.getProperty("General.EXCEPTION");
				responseEntity = new ResponseEntity<String>(errorMessage, HttpStatus.OK);
				return responseEntity;

			} else {
				errorMessage = environment.getProperty(exception.getMessage());

				if (errorMessage == null)
					errorMessage = environment.getProperty("General.EXCEPTION");
				responseEntity = new ResponseEntity<String>(errorMessage, HttpStatus.OK);
				return responseEntity;

			}
		}

		return responseEntity;
	}
	
	@PostMapping(value = "customer/signup/{addressId}")
	public ResponseEntity<String> customerSignup(@RequestBody AddressDTO addressDTO) {
		ResponseEntity<String> responseEntity = null;

		try {
			
			LOGGER.info("Address verification is being done by "+addressDTO.getStreet());
			addressDTO.setActive(true);
			addressservice.CustomerSignup(addressDTO);
			String successMessage = environment.getProperty("AddressRegistration.REGISTRATION_SUCCESS");
			responseEntity = new ResponseEntity<String>(successMessage, HttpStatus.OK);

		} catch (Exception exception) {
			LOGGER.error("Error: " + exception.getMessage(), exception);

			String errorMessage;

			if (exception.getMessage() == null) {
				errorMessage = environment.getProperty("General.EXCEPTION");
				responseEntity = new ResponseEntity<String>(errorMessage, HttpStatus.OK);
				return responseEntity;

			} else {
				errorMessage = environment.getProperty(exception.getMessage());

				if (errorMessage == null)
					errorMessage = environment.getProperty("General.EXCEPTION");
				responseEntity = new ResponseEntity<String>(errorMessage, HttpStatus.OK);
				return responseEntity;

			}
		}

		return responseEntity;
	}


}
