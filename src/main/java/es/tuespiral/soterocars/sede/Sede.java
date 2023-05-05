package es.tuespiral.soterocars.sede;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.tuespiral.soterocars.alquiler.Alquiler;
import es.tuespiral.soterocars.empleado.Empleado;
import es.tuespiral.soterocars.empresa.Empresa;
import es.tuespiral.soterocars.reserva.Reserva;
import es.tuespiral.soterocars.vehiculo.Vehiculo;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SEDES")
public class Sede {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column(nullable=false, unique=true)
	private String nombre;
	
	private String domicilio;
	
	private LocalDate fechaApertura;
	
	private String horario;
	
	private String direccionWeb;
	
	private String telefono;
	
	private String email;
	
	@ManyToOne
	@JsonIgnore	
	private Empresa empresa;
	
	@OneToMany(mappedBy="trabajaEnSede")
	@JsonIgnore
	private List<Empleado> empleados;
	
	@OneToMany(mappedBy="sedeRecogida")
	@JsonIgnore
	private List<Reserva> reservasConRecogida;
	
	@OneToMany(mappedBy="sedeDevolucion")
	@JsonIgnore
	private List<Reserva> reservasConDevolucion;
	
	@OneToMany(mappedBy="sedeRecogida")
	@JsonIgnore
	private List<Alquiler> alquileresConRecogida;
	
	@OneToMany(mappedBy="sedeDevolucion")
	@JsonIgnore
	private List<Alquiler> alquileresConDevolucion;
	
	@OneToMany(mappedBy="sedePropietaria")
	@JsonIgnore
	private List<Vehiculo> vehiculosEnPropiedad;
	
	@OneToMany(mappedBy="sedeUbicacionActual")
	@JsonIgnore
	private List<Vehiculo> vehiculosUbicadosActual;

	public Sede(@NonNull Long id, @NonNull String nombre, String domicilio, LocalDate fechaApertura, String horario, String direccionWeb,
			String telefono, String email, @NonNull Empresa empresa) {

		this.id = id;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.fechaApertura = fechaApertura;
		this.horario = horario;
		this.direccionWeb = direccionWeb;
		this.telefono = telefono;
		this.email = email;
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Sede{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", domicilio='" + domicilio + '\'' +
				", fechaApertura=" + fechaApertura +
				", horario='" + horario + '\'' +
				", direccionWeb='" + direccionWeb + '\'' +
				", telefono='" + telefono + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
