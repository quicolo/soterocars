package es.tuespiral.soterocars.alquiler;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends CrudRepository<Alquiler, Long> {

}
