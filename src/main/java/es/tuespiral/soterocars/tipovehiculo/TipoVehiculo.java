package es.tuespiral.soterocars.tipovehiculo;

import javax.persistence.Column;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.tuespiral.soterocars.reserva.Reserva;
import es.tuespiral.soterocars.tarifatipovehiculo.TarifaTipoVehiculo;
import es.tuespiral.soterocars.vehiculo.Vehiculo;
import lombok.Data;

@Entity
@Data
@Table(name="TIPOS_VEHICULO")
public class TipoVehiculo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column(nullable=false, unique=true)
	private String nombre;
	
	private String descripcion;
	
	private String nombreFicheroImagen;
	
	@OneToMany(mappedBy="tipoVehiculo")
	@JsonIgnore
	private List<TarifaTipoVehiculo> tarifas;
	
	@OneToMany(mappedBy="tipoVehiculo")
	@JsonIgnore
	private List<Vehiculo> vehiculos;	
}
