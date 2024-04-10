package usuarios;

import usuarios.utils.Rol;

public class Trabajador extends Usuario {
    private float suelo;
    private String rfc;

    public Trabajador(String nombre, String apellido, float suelo, String rfc) {
        super(nombre, apellido, Rol.TRABAJADOR);
        this.suelo = suelo;
        this.rfc = rfc;
    }
}
