package es.tuespiral.soterocars.reserva;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("reservas")
@Slf4j
public class ReservaRestController {
    @Autowired
    ReservaService reservaService;

    // Ejemplo de ruta: http://localhost:8080/reservas/1/1/2023-04-25T09:00:00/2023-04-27T09:00:00
    @GetMapping("/{idTipoVehiculo}/{idSede}/{fechaHoraRecogida}/{fechaHoraDevolucion}")
    public ResponseEntity<List<ResultadoBusqueda>> findById(@PathVariable Long idTipoVehiculo,
                                                            @PathVariable Long idSede,
                                                            @PathVariable String fechaHoraRecogida,
                                                            @PathVariable String fechaHoraDevolucion) throws ReservaException {
        return new ResponseEntity<>(reservaService.buscarVehiculosDisponibles(idTipoVehiculo, idSede,
                LocalDateTime.parse(fechaHoraRecogida), LocalDateTime.parse(fechaHoraDevolucion)), HttpStatus.OK);
    }

}
