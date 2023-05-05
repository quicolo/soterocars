package es.tuespiral.soterocars.estadoalquiler;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.tuespiral.soterocars.alquiler.Alquiler;
import es.tuespiral.soterocars.tipoestadoalquiler.TipoEstadoAlquiler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ESTADOS_ALQUILER")
public class EstadoAlquiler {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Alquiler alquiler;
	
	@ManyToOne
	private TipoEstadoAlquiler estado;
	
	@Column(nullable=false)
	private LocalDateTime fechaHora;
}
