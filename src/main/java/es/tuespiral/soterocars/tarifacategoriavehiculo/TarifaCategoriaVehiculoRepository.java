package es.tuespiral.soterocars.tarifacategoriavehiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaCategoriaVehiculoRepository extends CrudRepository<TarifaCategoriaVehiculo, Long> {

}