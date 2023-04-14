package es.tuespiral.soterocars.alquiler;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import es.tuespiral.soterocars.cliente.Cliente;
import es.tuespiral.soterocars.empleado.Empleado;
import es.tuespiral.soterocars.estadoalquiler.EstadoAlquiler;
import es.tuespiral.soterocars.reserva.Reserva;
import es.tuespiral.soterocars.sede.Sede;
import es.tuespiral.soterocars.tipoestadoalquiler.TipoEstadoAlquiler;
import es.tuespiral.soterocars.usuario.Usuario;
import es.tuespiral.soterocars.vehiculo.Vehiculo;
import lombok.Data;

@Entity
@Data
@Table(name="ALQUILERES")
public class Alquiler {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Empleado empleado;
	
	@OneToMany(mappedBy="alquiler")
	private List<EstadoAlquiler> estados;
	
	@OneToOne
	private Reserva reserva;
	
	@ManyToOne
	private Vehiculo vehiculo;
	
	@ManyToOne
	private Sede sedeRecogida;
	
	@ManyToOne
	private Sede sedeDevolucion;
	
	@Column(nullable=false)
	private LocalDateTime fechaHoraRecogida;
	
	@Column(nullable=false)
	private LocalDateTime fechaHoraDevolucion;
	
	@Column(nullable=false)
	private LocalDateTime fechaHoraCreacion;
	
	private LocalDateTime fechaHoraModificacion;
}
