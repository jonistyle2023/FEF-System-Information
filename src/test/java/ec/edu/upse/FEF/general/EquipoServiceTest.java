package ec.edu.upse.FEF.general;

import ec.edu.upse.FEF.modelo.Equipo;
import ec.edu.upse.FEF.modelo.EstadoEquipo;
import ec.edu.upse.FEF.modelo.PosicionJugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EquipoServiceTest {

    @Test
    void debeRegistrarEquipoYJugadores() {
        EquipoService service = new EquipoService();
        Equipo equipo = service.registrarEquipo("Emelec", "Guayaquil", EstadoEquipo.ACTIVO);

        service.registrarJugador(equipo, "0901", "Juan Perez", PosicionJugador.DELANTERO, 24, 76.5);

        assertEquals(1, service.listarEquipos().size());
        assertEquals(1, equipo.getJugadores().size());
    }

    @Test
    void noDebePermitirCiRepetidaEnMismoEquipo() {
        EquipoService service = new EquipoService();
        Equipo equipo = service.registrarEquipo("Liga", "Quito", EstadoEquipo.ACTIVO);

        service.registrarDirectivo(equipo, "1001", "Carlos Mena", "Presidente");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.registrarUtilero(equipo, "1001", "Carlos Mena", "Bodega"));

        assertTrue(ex.getMessage().contains("CI"));
    }

    @Test
    void noDebePermitirNombreEquipoRepetido() {
        EquipoService service = new EquipoService();
        service.registrarEquipo("Barcelona", "Guayaquil", EstadoEquipo.ACTIVO);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.registrarEquipo("barcelona", "Guayaquil", EstadoEquipo.INACTIVO));

        assertTrue(ex.getMessage().contains("equipo"));
    }
}

