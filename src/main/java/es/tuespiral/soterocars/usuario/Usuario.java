package es.tuespiral.soterocars.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.tuespiral.soterocars.cliente.Cliente;
import es.tuespiral.soterocars.empleado.Empleado;
import es.tuespiral.soterocars.perfilusuario.PerfilUsuario;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="USUARIOS")
public class Usuario {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false, unique=true)
	private String nombre;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private boolean cuentaExpirada;
	
	@Column(nullable=false)
	private boolean cuentaBloqueada;
	
	@Column(nullable=false)
	private boolean passwordExpirado;
	
	@Column(nullable=false)
	private boolean cuentaActiva;
	
	@ManyToOne
	private PerfilUsuario perfil;
	
	@OneToOne(mappedBy="usuario")
	private Empleado empleado;
	
	@OneToOne(mappedBy="usuario")
	private Cliente cliente;
}
