package es.tuespiral.soterocars.tipoestadoalquiler;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import es.tuespiral.soterocars.estadoalquiler.EstadoAlquiler;
import lombok.Data;

@Entity
@Data
@Table(name="TIPOS_ESTADO_ALQUILER")
public class TipoEstadoAlquiler {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false, unique=true)
	private String nombre;
	
	private String descripcion;
	
	@OneToMany(mappedBy="estado", cascade=CascadeType.ALL)
	private List<EstadoAlquiler> alquileres;
	
}
