package ec.edu.upse.FEF.modelo;

public class Jugador extends Persona {
    private final PosicionJugador posicion;
    private final int edad;
    private final double peso;

    public Jugador(String ci, String nombres, PosicionJugador posicion, int edad, double peso) {
        super(ci, nombres);
        if (posicion == null) {
            throw new IllegalArgumentException("La posicion es obligatoria");
        }
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor a 0");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a 0");
        }
        this.posicion = posicion;
        this.edad = edad;
        this.peso = peso;
    }

    public PosicionJugador getPosicion() {
        return posicion;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return getCi() + " - " + getNombres() + " (" + posicion + ", " + edad + " anios, " + peso + " kg)";
    }
}

