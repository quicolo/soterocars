package es.tuespiral.soterocars.perfilusuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.tuespiral.soterocars.usuario.Usuario;

import java.util.List;

import lombok.Data;

@Entity
@Data
@Table(name="PERFILES_USUARIO")
public class PerfilUsuario {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	private String descripcion;
	
	@Column(nullable=false)
	private String codigoPerfil;
	
	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuarios;
}
