package es.tuespiral.soterocars.reserva;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.tuespiral.soterocars.alquiler.Alquiler;
import es.tuespiral.soterocars.cliente.Cliente;
import es.tuespiral.soterocars.empleado.Empleado;
import es.tuespiral.soterocars.sede.Sede;
import es.tuespiral.soterocars.tipoestadoreserva.TipoEstadoReserva;
import es.tuespiral.soterocars.tipovehiculo.TipoVehiculo;
import lombok.Data;

@Entity
@Data
@Table(name="RESERVAS")
public class Reserva {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private TipoEstadoReserva estado;
	
	@ManyToOne
	private TipoVehiculo tipoVehiculo;
	
	@ManyToOne
	private Sede sedeRecogida;
	
	@ManyToOne
	private Sede sedeDevolucion;
	
	@OneToOne(mappedBy="reserva")
	private Alquiler alquiler;
	
	@Column(nullable=false)
	private LocalDateTime fechaHoraRecogida;
	
	@Column(nullable=false)
	private LocalDateTime fechaHoraDevolucion;
	
	@Column(nullable=false)
	private LocalDateTime fechaHoraCreacion;
	
	private LocalDateTime fechaHoraModificacion;
}
