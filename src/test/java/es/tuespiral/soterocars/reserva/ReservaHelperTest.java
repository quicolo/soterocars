package es.tuespiral.soterocars.reserva;

import es.tuespiral.soterocars.vehiculo.Vehiculo;
import es.tuespiral.soterocars.vehiculo.VehiculoRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservaHelperTest {

    @Test
    void testEstaDisponibleDebeRetornarFalsoCuandoElVehiculoTieneReservasQueSePisanConElInicioContandoConLaHolgura() {
        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2023, 2, 1, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 2, 2, 10, 0);

        Reserva r1 = new Reserva();
        r1.setFechaHoraRecogida(LocalDateTime.of(2023, 1, 31, 9, 0));
        r1.setFechaHoraDevolucion(LocalDateTime.of(2023, 2, 1, 9, 0));
        Reserva r2 = new Reserva();
        r2.setFechaHoraRecogida(LocalDateTime.of(2023, 1, 15, 9, 0));
        r2.setFechaHoraDevolucion(LocalDateTime.of(2023, 1, 17, 9, 0));
        Vehiculo v = new Vehiculo();
        v.setReservas(Arrays.asList(r1, r2));
        v.setAlquileres(Collections.EMPTY_LIST);

        // Act
        boolean actual = ReservaHelper.estaDisponible(v, inicio, fin);

        // Assert
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void testEstaDisponibleDebeRetornarFalsoCuandoElVehiculoTieneReservasQueSePisanConElInicioSinContarConLaHolgura() {
        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2023, 2, 1, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 2, 2, 10, 0);

        Reserva r1 = new Reserva();
        r1.setFechaHoraRecogida(LocalDateTime.of(2023, 1, 31, 9, 0));
        r1.setFechaHoraDevolucion(LocalDateTime.of(2023, 2, 1, 15, 0));
        Reserva r2 = new Reserva();
        r2.setFechaHoraRecogida(LocalDateTime.of(2023, 1, 15, 9, 0));
        r2.setFechaHoraDevolucion(LocalDateTime.of(2023, 1, 17, 9, 0));
        Vehiculo v = new Vehiculo();
        v.setReservas(Arrays.asList(r1, r2));
        v.setAlquileres(Collections.EMPTY_LIST);

        // Act
        boolean actual = ReservaHelper.estaDisponible(v, inicio, fin);

        // Assert
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void testEstaDisponibleDebeRetornarFalsoCuandoElVehiculoTieneReservasQueSePisanConElFinContandoConLaHolgura() {
        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2023, 2, 1, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 2, 2, 10, 0);

        Reserva r1 = new Reserva();
        r1.setFechaHoraRecogida(LocalDateTime.of(2023, 1, 31, 9, 0));
        r1.setFechaHoraDevolucion(LocalDateTime.of(2023, 2, 2, 11, 0));
        Reserva r2 = new Reserva();
        r2.setFechaHoraRecogida(LocalDateTime.of(2023, 1, 15, 9, 0));
        r2.setFechaHoraDevolucion(LocalDateTime.of(2023, 1, 17, 9, 0));
        Vehiculo v = new Vehiculo();
        v.setReservas(Arrays.asList(r1, r2));
        v.setAlquileres(Collections.EMPTY_LIST);

        // Act
        boolean actual = ReservaHelper.estaDisponible(v, inicio, fin);

        // Assert
        boolean expected = false;
        assertEquals(expected, actual);
    }


    @Test
    void testEstaDisponibleDebeRetornarFalsoCuandoElVehiculoTieneReservasQueSePisanConElFinSinContarConLaHolgura() {
        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2023, 2, 1, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 2, 2, 10, 0);

        Reserva r1 = new Reserva();
        r1.setFechaHoraRecogida(LocalDateTime.of(2023, 1, 31, 9, 0));
        r1.setFechaHoraDevolucion(LocalDateTime.of(2023, 2, 2, 9, 0));
        Reserva r2 = new Reserva();
        r2.setFechaHoraRecogida(LocalDateTime.of(2023, 1, 15, 9, 0));
        r2.setFechaHoraDevolucion(LocalDateTime.of(2023, 1, 17, 9, 0));
        Vehiculo v = new Vehiculo();
        v.setReservas(Arrays.asList(r1, r2));
        v.setAlquileres(Collections.EMPTY_LIST);

        // Act
        boolean actual = ReservaHelper.estaDisponible(v, inicio, fin);

        // Assert
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void testEstaDisponibleDebeRetornarCiertoCuandoElVehiculoNoTieneReservasQueSePisan() {
        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2023, 2, 1, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 2, 2, 10, 0);

        Reserva r1 = new Reserva();
        r1.setFechaHoraRecogida(LocalDateTime.of(2023, 2, 20, 9, 0));
        r1.setFechaHoraDevolucion(LocalDateTime.of(2023, 3, 2, 9, 0));
        Reserva r2 = new Reserva();
        r2.setFechaHoraRecogida(LocalDateTime.of(2023, 1, 15, 9, 0));
        r2.setFechaHoraDevolucion(LocalDateTime.of(2023, 1, 17, 9, 0));
        Vehiculo v = new Vehiculo();
        v.setReservas(Arrays.asList(r1, r2));
        v.setAlquileres(Collections.EMPTY_LIST);

        // Act
        boolean actual = ReservaHelper.estaDisponible(v, inicio, fin);

        // Assert
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void testCalculaPrecioDebeRetornarElPrecioDeUnDiaCuandoElPeriodoEsMenor24Horas() {
        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2023, 1, 1, 9, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 1, 1, 21, 0);
        BigDecimal precioPorDia = BigDecimal.valueOf(24L);
        BigDecimal precioPorHora = BigDecimal.valueOf(1L);

        // Act
        BigDecimal actual = ReservaHelper.calculaPrecio(precioPorDia, precioPorHora, inicio, fin);

        // Assert
        BigDecimal expected = BigDecimal.valueOf(24L);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculaPrecioDebeRetornarElPrecioDe2DiasY2Horas() {
        // Arrange
        LocalDateTime inicio = LocalDateTime.of(2023, 1, 1, 9, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 1, 3, 11, 10);
        BigDecimal precioPorDia = BigDecimal.valueOf(24L);
        BigDecimal precioPorHora = BigDecimal.valueOf(1L);

        // Act
        BigDecimal actual = ReservaHelper.calculaPrecio(precioPorDia, precioPorHora, inicio, fin);

        // Assert
        BigDecimal expected = BigDecimal.valueOf(50L);
        assertEquals(expected, actual);
    }
}