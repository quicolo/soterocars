package es.tuespiral.soterocars.tarifatipovehiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaTipoVehiculoRepository extends CrudRepository<TarifaTipoVehiculo, Long> {

}