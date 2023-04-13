package es.tuespiral.soterocars.aaplantillas.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	public List<Customer> findByEmailAddress(String email);
}