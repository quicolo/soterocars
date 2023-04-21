package es.tuespiral.soterocars.sede;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends CrudRepository<Sede, Long> {
	public Optional<Sede> findByNombre(String nombre);
}