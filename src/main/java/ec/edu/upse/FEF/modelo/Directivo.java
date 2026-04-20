package ec.edu.upse.FEF.modelo;

public class Directivo extends Persona {
    private final String cargo;

    public Directivo(String ci, String nombres, String cargo) {
        super(ci, nombres);
        this.cargo = validarTexto(cargo, "cargo");
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return getCi() + " - " + getNombres() + " (" + cargo + ")";
    }
}

