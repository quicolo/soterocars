package es.tuespiral.soterocars.tarifatipovehiculo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.tuespiral.soterocars.tipovehiculo.TipoVehiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TARIFAS_TIPO_VEHICULO")
public class TarifaTipoVehiculo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column(nullable=false)
	private String nombre;
	
	private String descripcion;

	@Column(nullable=false)
	private LocalDate fechaInicioAplicacion;
	
	private LocalDate fechaFinAplicacion;
	
	@Column(nullable=false)
	private BigDecimal precioPorDia;
	
	@Column(nullable=false)
	private BigDecimal precioPorHora;
	
	@Column(nullable=false)
	private BigDecimal limiteKilometraje;
	
	@ManyToOne
	@JsonIgnore
	private TipoVehiculo tipoVehiculo;

	@Override
	public String toString() {
		return "TarifaTipoVehiculo{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", descripcion='" + descripcion + '\'' +
				", fechaInicioAplicacion=" + fechaInicioAplicacion +
				", fechaFinAplicacion=" + fechaFinAplicacion +
				", precioPorDia=" + precioPorDia +
				", precioPorHora=" + precioPorHora +
				", limiteKilometraje=" + limiteKilometraje +
				'}';
	}
}
