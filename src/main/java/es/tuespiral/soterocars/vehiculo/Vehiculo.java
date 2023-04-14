package es.tuespiral.soterocars.vehiculo;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.tuespiral.soterocars.alquiler.Alquiler;
import es.tuespiral.soterocars.caracteristicavehiculo.CaracteristicaVehiculo;
import es.tuespiral.soterocars.tipovehiculo.TipoVehiculo;
import lombok.Data;

@Entity
@Data
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
	
	@OneToMany(mappedBy="vehiculo")
	private List<CaracteristicaVehiculo> caracteristicas;
	
	@OneToMany(mappedBy="vehiculo")
	private List<Alquiler> alquileres;
	
	@ManyToOne
	private TipoVehiculo tipoVehiculo;
}
