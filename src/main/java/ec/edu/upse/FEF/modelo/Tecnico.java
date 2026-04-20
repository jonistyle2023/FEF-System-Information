package ec.edu.upse.FEF.modelo;

public class Tecnico extends Persona {
    private final String nacionalidad;
    private final String cargo;

    public Tecnico(String ci, String nombres, String nacionalidad, String cargo) {
        super(ci, nombres);
        this.nacionalidad = validarTexto(nacionalidad, "nacionalidad");
        this.cargo = validarTexto(cargo, "cargo");
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return getCi() + " - " + getNombres() + " (" + cargo + ", " + nacionalidad + ")";
    }
}

