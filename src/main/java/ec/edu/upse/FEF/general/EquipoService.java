package ec.edu.upse.FEF.general;

import ec.edu.upse.FEF.modelo.Directivo;
import ec.edu.upse.FEF.modelo.Equipo;
import ec.edu.upse.FEF.modelo.EstadoEquipo;
import ec.edu.upse.FEF.modelo.Jugador;
import ec.edu.upse.FEF.modelo.PosicionJugador;
import ec.edu.upse.FEF.modelo.Tecnico;
import ec.edu.upse.FEF.modelo.Utilero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EquipoService {
    private final List<Equipo> equipos = new ArrayList<>();

    private Equipo validarEquipo(Equipo equipo) {
        if (equipo == null) {
            throw new IllegalArgumentException("Debe seleccionar un equipo");
        }
        return equipo;
    }

    public Equipo registrarEquipo(String nombreEQ, String ciudad, EstadoEquipo estado) {
        boolean existe = equipos.stream().anyMatch(e -> e.getNombreEQ().equalsIgnoreCase(nombreEQ.trim()));
        if (existe) {
            throw new IllegalArgumentException("Ya existe un equipo con ese nombre");
        }

        Equipo equipo = new Equipo(nombreEQ, ciudad, estado);
        equipos.add(equipo);
        return equipo;
    }

    public List<Equipo> listarEquipos() {
        return Collections.unmodifiableList(equipos);
    }

    public void registrarUtilero(Equipo equipo, String ci, String nombres, String ocupacion) {
        validarEquipo(equipo).agregarUtilero(new Utilero(ci, nombres, ocupacion));
    }

    public void registrarDirectivo(Equipo equipo, String ci, String nombres, String cargo) {
        validarEquipo(equipo).agregarDirectivo(new Directivo(ci, nombres, cargo));
    }

    public void registrarTecnico(Equipo equipo, String ci, String nombres, String nacionalidad, String cargo) {
        validarEquipo(equipo).agregarTecnico(new Tecnico(ci, nombres, nacionalidad, cargo));
    }

    public void registrarJugador(Equipo equipo, String ci, String nombres, PosicionJugador posicion, int edad, double peso) {
        validarEquipo(equipo).agregarJugador(new Jugador(ci, nombres, posicion, edad, peso));
    }

    public String construirResumen(Equipo equipo) {
        equipo = validarEquipo(equipo);
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo: ").append(equipo.getNombreEQ())
          .append(" | Ciudad: ").append(equipo.getCiudad())
          .append(" | Estado: ").append(equipo.getEstado()).append('\n');

        sb.append("Utileria (").append(equipo.getUtileros().size()).append("): ").append(equipo.getUtileros()).append('\n');
        sb.append("Directivos (").append(equipo.getDirectivos().size()).append("): ").append(equipo.getDirectivos()).append('\n');
        sb.append("Equipo tecnico (").append(equipo.getTecnicos().size()).append("): ").append(equipo.getTecnicos()).append('\n');
        sb.append("Jugadores (").append(equipo.getJugadores().size()).append("): ").append(equipo.getJugadores()).append('\n');
        return sb.toString();
    }

    public String construirNominaCompleta(Equipo equipo) {
        equipo = validarEquipo(equipo);
        StringBuilder sb = new StringBuilder();
        sb.append("NOMINA COMPLETA DEL EQUIPO").append('\n');
        sb.append("Equipo: ").append(equipo.getNombreEQ())
                .append(" | Ciudad: ").append(equipo.getCiudad())
                .append(" | Estado: ").append(equipo.getEstado()).append("\n\n");

        sb.append("PERSONAL DE UTILERIA").append('\n');
        if (equipo.getUtileros().isEmpty()) {
            sb.append("- Sin registros").append("\n\n");
        } else {
            for (int i = 0; i < equipo.getUtileros().size(); i++) {
                sb.append(i + 1).append(". ").append(equipo.getUtileros().get(i)).append('\n');
            }
            sb.append('\n');
        }

        sb.append("DIRECTIVOS").append('\n');
        if (equipo.getDirectivos().isEmpty()) {
            sb.append("- Sin registros").append("\n\n");
        } else {
            for (int i = 0; i < equipo.getDirectivos().size(); i++) {
                sb.append(i + 1).append(". ").append(equipo.getDirectivos().get(i)).append('\n');
            }
            sb.append('\n');
        }

        sb.append("EQUIPO TECNICO").append('\n');
        if (equipo.getTecnicos().isEmpty()) {
            sb.append("- Sin registros").append("\n\n");
        } else {
            for (int i = 0; i < equipo.getTecnicos().size(); i++) {
                sb.append(i + 1).append(". ").append(equipo.getTecnicos().get(i)).append('\n');
            }
            sb.append('\n');
        }

        sb.append("JUGADORES").append('\n');
        if (equipo.getJugadores().isEmpty()) {
            sb.append("- Sin registros").append('\n');
        } else {
            for (int i = 0; i < equipo.getJugadores().size(); i++) {
                sb.append(i + 1).append(". ").append(equipo.getJugadores().get(i)).append('\n');
            }
        }
        return sb.toString();
    }
}


