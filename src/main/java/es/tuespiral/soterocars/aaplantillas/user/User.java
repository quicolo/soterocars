package es.tuespiral.soterocars.aaplantillas.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.tuespiral.soterocars.aaplantillas.customer.Customer;
import lombok.Data; 

@Entity
@Table(name="USERS")
@Data
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	private String userName;
	
	private String userPassword;
	
	@OneToOne
	private Customer customer;
	
	public User(String userName, String password, Customer c) {
		this.userName = userName;
		userPassword = password;
		customer = c;
	}
}
