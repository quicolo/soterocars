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
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
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
	private List<Empleado> empleados;
	
	@OneToMany(mappedBy="sedeRecogida")
	private List<Reserva> reservasConRecogida;
	
	@OneToMany(mappedBy="sedeDevolucion")
	private List<Reserva> reservasConDevolucion;
	
	@OneToMany(mappedBy="sedeRecogida")
	private List<Alquiler> alquileresConRecogida;
	
	@OneToMany(mappedBy="sedeDevolucion")
	private List<Alquiler> alquileresConDevolucion;
	
	@OneToMany(mappedBy="sedePropietaria")
	private List<Vehiculo> vehiculosEnPropiedad;
	
	@OneToMany(mappedBy="sedeUbicacionActual")
	private List<Vehiculo> vehiculosUbicadosActual;
	
	public Sede() {}
	
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
}
