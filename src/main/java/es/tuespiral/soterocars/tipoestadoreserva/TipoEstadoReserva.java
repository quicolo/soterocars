package es.tuespiral.soterocars.tipoestadoreserva;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.tuespiral.soterocars.reserva.Reserva;
import lombok.Data;

@Entity
@Data
@Table(name="TIPOS_ESTADO_RESERVA")
public class TipoEstadoReserva {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false, unique=true)
	private String nombre;
	
	private String descripcion;
	
	@OneToMany(mappedBy="estado")
	private List<Reserva> reservas;
	
}
