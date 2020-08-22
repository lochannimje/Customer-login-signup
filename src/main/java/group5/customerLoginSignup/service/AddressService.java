package group5.customerLoginSignup.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import group5.customerLoginSignup.repository.AddressRepository;
import group5.customerLoginSignup.dto.AddressDTO;
import group5.customerLoginSignup.entity.AddressEntity;
import group5.customerLoginSignup.exception.require6digitsException;

@Service
@PropertySource(value = { "classpath:configuration.properties" })
public class AddressService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);
	
	@Autowired
	AddressRepository addressRepository;
	
	public void CustomerSignup(AddressDTO addressDTO) throws Exception {
		LOGGER.info("Customer details are going to validate");
		validatePincode(addressDTO);
		LOGGER.info("Customer details are validated successfully");
		AddressEntity addressEntity = new AddressEntity();
		BeanUtils.copyProperties(addressDTO, addressEntity);
		addressRepository.save(addressEntity);
		LOGGER.info("Address details are saved in DB successfully");
	}
	
	
	private void validatePincode(AddressDTO addressDTO) throws Exception {
			LOGGER.info("Address details are being validated");
			if(!require6digits(addressDTO.getPincode()))
				throw new require6digitsException("CustomerSignup.REQUIRED_6_DIGITS");
	}
	
	private boolean require6digits(int pincode) {
		
		AddressEntity addressEntity=addressRepository.findByPincode(pincode);
		if (addressEntity!=null)
			return false;
		return true;
	}
	

}
