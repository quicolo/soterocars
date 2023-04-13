package es.tuespiral.soterocars.caracteristicavehiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaVehiculoRepository extends CrudRepository<CaracteristicaVehiculo, Long> {

}

