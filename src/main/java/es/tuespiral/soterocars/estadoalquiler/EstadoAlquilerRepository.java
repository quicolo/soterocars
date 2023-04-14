package es.tuespiral.soterocars.estadoalquiler;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoAlquilerRepository extends CrudRepository<EstadoAlquiler, Long> {

}