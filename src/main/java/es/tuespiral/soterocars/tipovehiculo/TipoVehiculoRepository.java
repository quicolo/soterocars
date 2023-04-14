package es.tuespiral.soterocars.tipovehiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoVehiculoRepository extends CrudRepository<TipoVehiculo, Long> {

}
