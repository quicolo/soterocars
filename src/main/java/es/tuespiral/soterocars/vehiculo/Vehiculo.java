package es.tuespiral.soterocars.vehiculo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.tuespiral.soterocars.alquiler.Alquiler;
import es.tuespiral.soterocars.caracteristicavehiculo.CaracteristicaVehiculo;
import es.tuespiral.soterocars.reserva.Reserva;
import es.tuespiral.soterocars.sede.Sede;
import es.tuespiral.soterocars.tipovehiculo.TipoVehiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="VEHICULOS")
public class Vehiculo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	@Column(nullable=false)
	private String matricula;
	
	@Column(nullable=false)
	private String marca;
	
	@Column(nullable=false)
	private String modelo;
	
	@Column(nullable=false)
	private LocalDate fechaAlta;
	
	private LocalDate fechaBaja;
	
	@OneToMany(mappedBy="vehiculo", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<CaracteristicaVehiculo> caracteristicas;
	
	@OneToMany(mappedBy="vehiculo")
	@JsonIgnore
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy="vehiculo")
	@JsonIgnore
	private List<Alquiler> alquileres;
	
	@ManyToOne
	@JsonIgnore
	private TipoVehiculo tipoVehiculo;
	
	@ManyToOne
	@JsonIgnore
	private Sede sedePropietaria;
	
	@ManyToOne
	@JsonIgnore
	private Sede sedeUbicacionActual;

	@Override
	public String toString() {
		return "Vehiculo{" +
				"id=" + id +
				", matricula='" + matricula + '\'' +
				", marca='" + marca + '\'' +
				", modelo='" + modelo + '\'' +
				", fechaAlta=" + fechaAlta +
				", fechaBaja=" + fechaBaja +
				'}';
	}
}
