package es.tuespiral.soterocars.tipocaracteristicavehiculo;

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

import es.tuespiral.soterocars.caracteristicavehiculo.CaracteristicaVehiculo;
import es.tuespiral.soterocars.vehiculo.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TIPOS_CARACTERISTICA_VEHICULO")
public class TipoCaracteristicaVehiculo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	@Column(nullable=false, unique=true)
	private String nombre;
	
	@OneToMany(mappedBy="tipoCaracteristica", cascade=CascadeType.ALL)
	private List<CaracteristicaVehiculo> vehiculos;
}
