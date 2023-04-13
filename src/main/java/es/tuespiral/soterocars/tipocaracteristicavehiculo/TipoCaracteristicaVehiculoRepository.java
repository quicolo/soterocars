package es.tuespiral.soterocars.tipocaracteristicavehiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCaracteristicaVehiculoRepository extends CrudRepository<TipoCaracteristicaVehiculo, Long> {

}