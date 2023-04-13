package es.tuespiral.soterocars.perfilusuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilUsuarioRepository extends CrudRepository<PerfilUsuario, Long> {

}
