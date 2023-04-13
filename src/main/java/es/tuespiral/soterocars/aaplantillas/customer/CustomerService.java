package es.tuespiral.soterocars.aaplantillas.customer;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import es.tuespiral.soterocars.utils.mail.EmailService;
import es.tuespiral.soterocars.utils.mail.Message;
import lombok.NonNull;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repo;
	@Autowired
	private EmailService emailService;
	
	@Value("${demo.servicios.email.from}")
	private String emailFrom; 
	
	public void createCustomer(@NonNull String name, @NonNull String lastName, 
							   @NonNull String email, LocalDate birthDate)
							   throws CustomerException {
		if (!emailService.validateAddress(email)) {
			throw new CustomerException("El email "+email+" no es válido");
		}
		
		if(!repo.findByEmailAddress(email).isEmpty()) {
			throw new CustomerException("El cliente con "+email+" ya existe");
		}
		
		Customer c = new Customer(name, lastName, email, birthDate);
		repo.save(c);
		Message msg = emailService.buildMessageOf(emailFrom, email, "Good news!", "The customer was created successfully");
		emailService.send(msg);
	}
}
