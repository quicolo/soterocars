package es.tuespiral.soterocars.tarifacategoriavehiculo;

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

import es.tuespiral.soterocars.categoriavehiculo.CategoriaVehiculo;
import lombok.Data;

@Entity
@Data
@Table(name="TARIFAS_CATEGORIAS_VEHICULO")
public class TarifaCategoriaVehiculo {
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
	private CategoriaVehiculo categoria; 
}
