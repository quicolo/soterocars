package es.tuespiral.soterocars.vehiculo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.tuespiral.soterocars.tipovehiculo.TipoVehiculo;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Long> {
	public List<Vehiculo> findByTipoVehiculo(TipoVehiculo tipo);
}