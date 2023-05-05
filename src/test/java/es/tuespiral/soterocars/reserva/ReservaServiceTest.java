package es.tuespiral.soterocars.reserva;

import es.tuespiral.soterocars.empresa.Empresa;
import es.tuespiral.soterocars.sede.Sede;
import es.tuespiral.soterocars.sede.SedeRepository;
import es.tuespiral.soterocars.tarifatipovehiculo.TarifaTipoVehiculo;
import es.tuespiral.soterocars.tarifatipovehiculo.TarifaTipoVehiculoRepository;
import es.tuespiral.soterocars.tipovehiculo.TipoVehiculo;
import es.tuespiral.soterocars.tipovehiculo.TipoVehiculoRepository;
import es.tuespiral.soterocars.vehiculo.Vehiculo;
import es.tuespiral.soterocars.vehiculo.VehiculoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ReservaServiceTest {

    @InjectMocks
    ReservaService reservaService;
    @Mock
    TipoVehiculoRepository tipoVehiculoRepo;
    @Mock
    VehiculoRepository vehiculoRepo;
    @Mock
    SedeRepository sedeRepo;
    @Mock
    TarifaTipoVehiculoRepository tarifaRepo;

    @Test
    void testBuscarVehiculosDisponiblesDebeLanzarExcepcionCuandoFechasEstenInvertidas() {
        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2023, 1, 2, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 1, 1, 10, 0);

        // Act & Assert
        assertThrows(ReservaException.class, ()  -> reservaService.buscarVehiculosDisponibles(1L, 1L, inicio, fin));
    }

    @Test
    void testBuscarVehiculosDisponiblesDebeDevolverSoloUnVehiculoDisponible() throws ReservaException {

        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2023, 1, 2, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 1, 3, 10, 0);

        Empresa emp = Empresa.builder()
                .id(1L)
                .denominacionSocial("SoteroCars")
                .cif("CIF")
                .build();

        Sede sede = Sede.builder()
                .id(1L)
                .nombre("San Juan")
                .empresa(emp)
                .build();

        Mockito.when(sedeRepo.findById(1L)).thenReturn(Optional.of(sede));


        TipoVehiculo tipoVehiculo = TipoVehiculo.builder()
                .id(1L)
                .nombre("Económico")
                .build();
        Mockito.when(tipoVehiculoRepo.findById(1L)).thenReturn(Optional.of(tipoVehiculo));


        TarifaTipoVehiculo tarifa = TarifaTipoVehiculo.builder()
                .id(1L)
                .nombre("Económica")
                .precioPorDia(BigDecimal.valueOf(24))
                .precioPorHora(BigDecimal.valueOf(1))
                .limiteKilometraje(BigDecimal.valueOf(500))
                .build();
        Mockito.when(tarifaRepo.findByTipoVehiculo(tipoVehiculo)).thenReturn(Optional.of(tarifa));

        Vehiculo v1 = Vehiculo.builder()
                .id(1L)
                .matricula("1234-FRT")
                .marca("Seat")
                .modelo("Altea")
                .fechaAlta(LocalDate.of(2022, 1, 1))
                .reservas(Collections.EMPTY_LIST)
                .alquileres(Collections.EMPTY_LIST)
                .build();

        Reserva reserva = Reserva.builder()
                .id(1L)
                .fechaHoraRecogida(LocalDateTime.of(2023, 1, 2, 10, 0))
                .fechaHoraDevolucion(LocalDateTime.of(2023, 1, 5, 10, 0))
                .build();

        Vehiculo v2 = Vehiculo.builder()
                .id(2L)
                .matricula("4321-FRT")
                .marca("Seat")
                .modelo("Ibiza")
                .fechaAlta(LocalDate.of(2023, 1, 1))
                .reservas(Arrays.asList(reserva))
                .alquileres(Collections.EMPTY_LIST)
                .build();
        Mockito.when(vehiculoRepo.findByTipoVehiculo(tipoVehiculo)).thenReturn(Arrays.asList(v1, v2));

        // Act
        List<ResultadoBusqueda> lista = reservaService.buscarVehiculosDisponibles(1L, 1L, inicio, fin);

        // Assert
        assert(lista.size() == 1);
        assert(lista.get(0).getVehiculo().getId() == 1L);
    }

}