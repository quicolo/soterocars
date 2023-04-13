package es.tuespiral.soterocars.categoriavehiculo;

import javax.persistence.Column;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.tuespiral.soterocars.tarifacategoriavehiculo.TarifaCategoriaVehiculo;
import es.tuespiral.soterocars.vehiculo.Vehiculo;
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
	
	private String nombreFicheroImagen;
	
	@OneToMany(mappedBy="categoria")
	private List<TarifaCategoriaVehiculo> tarifas;
	
	@OneToMany(mappedBy="categoria")
	private List<Vehiculo> vehiculos;
}
