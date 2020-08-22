package group5.customerLoginSignup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerLoginSignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLoginSignupApplication.class, args);
	}

}
