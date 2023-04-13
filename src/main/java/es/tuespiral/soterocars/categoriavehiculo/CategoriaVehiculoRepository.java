package es.tuespiral.soterocars.categoriavehiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaVehiculoRepository extends CrudRepository<CategoriaVehiculo, Long> {

}
