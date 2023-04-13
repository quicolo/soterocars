package es.tuespiral.soterocars.vehiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Long> {

}