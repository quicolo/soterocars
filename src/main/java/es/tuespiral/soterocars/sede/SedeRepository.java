package es.tuespiral.soterocars.sede;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends CrudRepository<Sede, Long> {

}