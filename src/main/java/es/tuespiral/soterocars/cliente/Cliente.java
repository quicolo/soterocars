package es.tuespiral.soterocars.cliente;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.tuespiral.soterocars.alquiler.Alquiler;
import es.tuespiral.soterocars.reserva.Reserva;
import es.tuespiral.soterocars.sede.Sede;
import es.tuespiral.soterocars.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CLIENTES")
public class Cliente {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false, unique = true)
	private String dni; 
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellido1;
	
	private String apellido2;
	
	private String telefono;
	
	private String domicilio;
	
	private String email;
	
	@Column(nullable=false)
	private LocalDate fechaAlta;
	
	private LocalDate fechaBaja;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy="cliente")
	private List<Alquiler> alquileres;
}
