package ec.edu.upse.FEF.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipo {
    private final String nombreEQ;
    private final String ciudad;
    private final EstadoEquipo estado;

    private final List<Utilero> utileros = new ArrayList<>();
    private final List<Directivo> directivos = new ArrayList<>();
    private final List<Tecnico> tecnicos = new ArrayList<>();
    private final List<Jugador> jugadores = new ArrayList<>();

    public Equipo(String nombreEQ, String ciudad, EstadoEquipo estado) {
        this.nombreEQ = validarTexto(nombreEQ, "nombreEQ");
        this.ciudad = validarTexto(ciudad, "ciudad");
        if (estado == null) {
            throw new IllegalArgumentException("El estado del equipo es obligatorio");
        }
        this.estado = estado;
    }

    private String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " es obligatorio");
        }
        return valor.trim();
    }

    public String getNombreEQ() {
        return nombreEQ;
    }

    public String getCiudad() {
        return ciudad;
    }

    public EstadoEquipo getEstado() {
        return estado;
    }

    public List<Utilero> getUtileros() {
        return Collections.unmodifiableList(utileros);
    }

    public List<Directivo> getDirectivos() {
        return Collections.unmodifiableList(directivos);
    }

    public List<Tecnico> getTecnicos() {
        return Collections.unmodifiableList(tecnicos);
    }

    public List<Jugador> getJugadores() {
        return Collections.unmodifiableList(jugadores);
    }

    public void agregarUtilero(Utilero utilero) {
        validarPersona(utilero.getCi());
        utileros.add(utilero);
    }

    public void agregarDirectivo(Directivo directivo) {
        validarPersona(directivo.getCi());
        directivos.add(directivo);
    }

    public void agregarTecnico(Tecnico tecnico) {
        validarPersona(tecnico.getCi());
        tecnicos.add(tecnico);
    }

    public void agregarJugador(Jugador jugador) {
        validarPersona(jugador.getCi());
        jugadores.add(jugador);
    }

    private void validarPersona(String ci) {
        boolean repetido = utileros.stream().anyMatch(u -> u.getCi().equals(ci))
                || directivos.stream().anyMatch(d -> d.getCi().equals(ci))
                || tecnicos.stream().anyMatch(t -> t.getCi().equals(ci))
                || jugadores.stream().anyMatch(j -> j.getCi().equals(ci));

        if (repetido) {
            throw new IllegalArgumentException("Ya existe una persona registrada con la CI " + ci + " en este equipo");
        }
    }

    @Override
    public String toString() {
        return nombreEQ + " - " + ciudad + " (" + estado + ")";
    }
}

