package es.tuespiral.soterocars.tipoestadoalquiler;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEstadoAlquilerRepository extends CrudRepository<TipoEstadoAlquiler, Long> {

}
