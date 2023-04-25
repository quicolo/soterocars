package es.tuespiral.soterocars.reserva;

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
public class ReservaRestController {
    @Autowired
    ReservaService reservaService;

    // Devuelve el producto con ID 1 desde la ruta: http://localhost:8080/products/1
    @GetMapping("/{tipoVehiculo}/{nombreSede}/{fechaHoraRecogida}/{fechaHoraDevolucion}")
    public ResponseEntity<List<ResultadoBusqueda>> findById(@PathVariable String tipoVehiculo,
                                                            @PathVariable String nombreSede,
                                                            @PathVariable String fechaHoraRecogida,
                                                            @PathVariable String fechaHoraDevolucion) throws ReservaException {
        return new ResponseEntity<>(reservaService.buscarVehiculosDisponibles(tipoVehiculo, nombreSede,
                LocalDateTime.parse(fechaHoraRecogida), LocalDateTime.parse(fechaHoraDevolucion)), HttpStatus.OK);
    }

}
