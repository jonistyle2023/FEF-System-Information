package ec.edu.upse.FEF.modelo;

public abstract class Persona {
    private final String ci;
    private final String nombres;

    protected Persona(String ci, String nombres) {
        this.ci = validarTexto(ci, "CI");
        this.nombres = validarTexto(nombres, "nombres");
    }

    public String getCi() {
        return ci;
    }

    public String getNombres() {
        return nombres;
    }

    protected static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " es obligatorio");
        }
        return valor.trim();
    }
}

