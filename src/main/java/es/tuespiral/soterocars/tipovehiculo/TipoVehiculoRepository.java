package es.tuespiral.soterocars.tipovehiculo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoVehiculoRepository extends CrudRepository<TipoVehiculo, Long> {
	public Optional<TipoVehiculo> findByNombre(String nombre);
}
