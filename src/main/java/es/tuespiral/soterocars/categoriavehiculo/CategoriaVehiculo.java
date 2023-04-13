package es.tuespiral.soterocars.categoriavehiculo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CATEGORIAS_VEHICULO")
public class CategoriaVehiculo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column(nullable=false)
	private String nombre;
	
	private String descripcion;
}