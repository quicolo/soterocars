package es.tuespiral.soterocars.reserva;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import es.tuespiral.soterocars.tipovehiculo.TipoVehiculo;
import es.tuespiral.soterocars.vehiculo.Vehiculo;

public class ReservaHelper {
	// Aplicamos una holgura a las fechas de inicio y devolución
	// para que de tiempo a limpiar el vehículo antes de darlo a
	// otro cliente
	public static long HORAS_HOLGURA = 2;

	public static boolean estaDisponible(Vehiculo v, LocalDateTime inicioParam, LocalDateTime finParam) {
		LocalDateTime inicio = inicioParam.minus(HORAS_HOLGURA, ChronoUnit.HOURS);
		LocalDateTime fin = finParam.plus(HORAS_HOLGURA, ChronoUnit.HOURS);

		boolean libreDeReservas = v.getReservas().stream().allMatch(
				res -> res.getFechaHoraDevolucion().isBefore(inicio) || res.getFechaHoraRecogida().isAfter(fin));

		boolean libreDeAlquileres = v.getAlquileres().stream().allMatch(
				res -> res.getFechaHoraDevolucion().isBefore(inicio) || res.getFechaHoraRecogida().isAfter(fin));

		return libreDeReservas && libreDeAlquileres;
	}

	public static BigDecimal calculaPrecio(final BigDecimal precioPorDia, final BigDecimal precioPorHora,
			final LocalDateTime inicio, final LocalDateTime fin) {

		LocalDateTime auxiliar = LocalDateTime.from(inicio);
		long dias = auxiliar.until(fin, ChronoUnit.DAYS);

		auxiliar = auxiliar.plus(dias, ChronoUnit.DAYS);
		long horas = auxiliar.until(fin, ChronoUnit.HOURS);

		if (dias == 0) {
			return precioPorDia;
		} else {
			BigDecimal precioDias = precioPorDia.multiply(BigDecimal.valueOf(dias));
			BigDecimal precioHoras = precioPorHora.multiply(BigDecimal.valueOf(horas));

			return precioDias.add(precioHoras);
		}
	}
}
