package es.tuespiral.soterocars.empleado;

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

import es.tuespiral.soterocars.empresa.Empresa;
import es.tuespiral.soterocars.sede.Sede;
import lombok.Data;

@Entity
@Data
@Table(name="EMPLEADOS")
public class Empleado {
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
	
	@Column(nullable=false)
	private BigDecimal salario;
	
	private String email;
	
	@Column(nullable=false)
	private LocalDate fechaContratacion;
	
	private LocalDate fechaCese;
	
	@ManyToOne
	@JsonIgnore	
	private Sede trabajaEnSede;
}
