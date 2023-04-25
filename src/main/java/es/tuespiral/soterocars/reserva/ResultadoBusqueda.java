package es.tuespiral.soterocars.reserva;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import es.tuespiral.soterocars.sede.Sede;
import es.tuespiral.soterocars.tipovehiculo.TipoVehiculo;
import es.tuespiral.soterocars.vehiculo.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultadoBusqueda {
	private final TipoVehiculo tipo;
	private final Vehiculo vehiculo;
	private final LocalDateTime fechaHoraRecogida;
	private final LocalDateTime fechaHoraDevolucion;
	private final BigDecimal precio;
	private final Sede sede;
}
