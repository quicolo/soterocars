package es.tuespiral.soterocars.sede;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tuespiral.soterocars.empresa.Empresa;
import lombok.NonNull;

@Service
public class SedeService {
	@Autowired
	private SedeRepository repo;
	
	public void creaSede(@NonNull String nombre, String domicilio, 
			              LocalDate fechaApertura, String horario, 
			              String direccionWeb, String telefono, 
			              String email, @NonNull Empresa emp) throws SedeException {
		
		if(repo.findByNombre(nombre).isPresent()) {
			throw new SedeException("Ya existe una sede con el nombre "+nombre);
		}
		
		Sede sede = new Sede(null, nombre, domicilio, fechaApertura, horario, direccionWeb, telefono, email, emp);
		repo.save(sede);
	}
	

}
