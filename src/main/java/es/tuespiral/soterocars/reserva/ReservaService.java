package es.tuespiral.soterocars.reserva;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.tuespiral.soterocars.alquiler.AlquilerRepository;
import es.tuespiral.soterocars.sede.Sede;
import es.tuespiral.soterocars.sede.SedeRepository;
import es.tuespiral.soterocars.tarifatipovehiculo.TarifaTipoVehiculo;
import es.tuespiral.soterocars.tarifatipovehiculo.TarifaTipoVehiculoRepository;
import es.tuespiral.soterocars.tipovehiculo.TipoVehiculo;
import es.tuespiral.soterocars.tipovehiculo.TipoVehiculoRepository;
import es.tuespiral.soterocars.vehiculo.Vehiculo;
import es.tuespiral.soterocars.vehiculo.VehiculoRepository;
import lombok.NonNull;

@Service
@Transactional
@Slf4j
public class ReservaService {
	@Autowired
	private TipoVehiculoRepository tipoVehiculoRepo;
	@Autowired
	private VehiculoRepository vehiculoRepo;
	@Autowired
	private SedeRepository sedeRepo;
	@Autowired
	private TarifaTipoVehiculoRepository tarifaRepo;

	public List<ResultadoBusqueda> buscarVehiculosDisponibles(@NonNull Long idTipoVehiculo,
			@NonNull Long idSede, @NonNull LocalDateTime fechaHoraRecogida,
			@NonNull LocalDateTime fechaHoraDevolucion) throws ReservaException {

		TipoVehiculo tipoVehiculo = tipoVehiculoRepo.findById(idTipoVehiculo)
				.orElseThrow(() -> new ReservaException("No existe el tipo de vehículo con ID " + idTipoVehiculo));

		Sede sede = sedeRepo.findById(idSede)
				.orElseThrow(() -> new ReservaException("No existe la sede con ID " + idSede));

		TarifaTipoVehiculo tarifa = tarifaRepo.findByTipoVehiculo(tipoVehiculo)
				.orElseThrow(() -> new ReservaException("No existe una tarifa para los tipos de vehículos con ID " + idTipoVehiculo));
		
		if (fechaHoraRecogida.isAfter(fechaHoraDevolucion) || fechaHoraRecogida.isEqual(fechaHoraDevolucion)) {
			throw new ReservaException("La fecha de devolución debe ser posterior a la de recogida");
		}

		BigDecimal precio = ReservaHelper.calculaPrecio(tarifa.getPrecioPorDia(), tarifa.getPrecioPorHora(),
				fechaHoraRecogida, fechaHoraDevolucion);

		List<Vehiculo> vehiculos = vehiculoRepo.findByTipoVehiculo(tipoVehiculo);
		
		List<Vehiculo> candidatos = vehiculos.stream().filter(veh -> veh.getFechaBaja() == null)
				.filter(veh -> ReservaHelper.estaDisponible(veh, fechaHoraRecogida, fechaHoraDevolucion))
				.collect(Collectors.toList());

		List<ResultadoBusqueda> lista = candidatos.stream()
				.map(veh -> new ResultadoBusqueda(tipoVehiculo, veh, fechaHoraRecogida, fechaHoraDevolucion, precio, sede))
				.collect(Collectors.toList());

		return lista;
	}
}
