package es.tuespiral.soterocars.caracteristicavehiculo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.tuespiral.soterocars.tipocaracteristicavehiculo.TipoCaracteristicaVehiculo;
import es.tuespiral.soterocars.vehiculo.Vehiculo;

import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CARACTERISTICAS_VEHICULO")
public class CaracteristicaVehiculo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JsonIgnore
	private TipoCaracteristicaVehiculo tipoCaracteristica;
	
	@ManyToOne
	@JsonIgnore
	private Vehiculo vehiculo;
	
	@Column(nullable=false)
	private String valor;
}
