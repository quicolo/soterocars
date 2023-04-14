package es.tuespiral.soterocars.tipoestadoreserva;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEstadoReservaRepository extends CrudRepository<TipoEstadoReserva, Long> {

}
