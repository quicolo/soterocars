package es.tuespiral.soterocars.empresa;

import java.time.LocalDate;
import java.util.List;

import es.tuespiral.soterocars.sede.Sede;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="EMPRESAS")
public class Empresa {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column(nullable=false)
	private String cif;
	
	@Column(nullable=false)
	private String denominacionSocial;
	
	private String domicilio;
	
	private LocalDate fechaConstitucion;
	
	private String direccionWeb;
	
	private String telefono;
	
	private String email;
	
	@OneToMany(mappedBy="empresa")
	private List<Sede> sedes;
	
	
}
