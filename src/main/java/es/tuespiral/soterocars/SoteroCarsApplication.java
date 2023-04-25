package es.tuespiral.soterocars;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.tuespiral.soterocars.empresa.Empresa;
import es.tuespiral.soterocars.empresa.EmpresaRepository;
import es.tuespiral.soterocars.sede.SedeException;
import es.tuespiral.soterocars.sede.SedeService;

@SpringBootApplication
public class SoteroCarsApplication {
	public static void main(String[] args) throws SedeException {
		ApplicationContext context =  SpringApplication.run(SoteroCarsApplication.class, args);
	}

}
