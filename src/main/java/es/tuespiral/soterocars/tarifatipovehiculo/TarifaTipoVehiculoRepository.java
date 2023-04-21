package es.tuespiral.soterocars.tarifatipovehiculo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.tuespiral.soterocars.tipovehiculo.TipoVehiculo;

@Repository
public interface TarifaTipoVehiculoRepository extends CrudRepository<TarifaTipoVehiculo, Long> {
	public Optional<TarifaTipoVehiculo> findByTipoVehiculo(TipoVehiculo tipo);
}