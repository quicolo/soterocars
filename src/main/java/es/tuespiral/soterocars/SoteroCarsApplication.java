package es.tuespiral.soterocars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.tuespiral.soterocars.aaplantillas.customer.CustomerException;
import es.tuespiral.soterocars.aaplantillas.customer.CustomerService;

@SpringBootApplication
public class SoteroCarsApplication {
	public static void main(String[] args) throws CustomerException {
		SpringApplication.run(SoteroCarsApplication.class, args);
	}

}
