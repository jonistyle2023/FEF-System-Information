package ec.edu.upse.FEF.modelo;

public class Utilero extends Persona {
    private final String ocupacion;

    public Utilero(String ci, String nombres, String ocupacion) {
        super(ci, nombres);
        this.ocupacion = validarTexto(ocupacion, "ocupacion");
    }

    public String getOcupacion() {
        return ocupacion;
    }

    @Override
    public String toString() {
        return getCi() + " - " + getNombres() + " (" + ocupacion + ")";
    }
}

