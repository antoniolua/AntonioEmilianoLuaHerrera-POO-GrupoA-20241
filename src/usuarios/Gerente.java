package usuarios;

import usuarios.utils.Rol;

public class Gerente extends Usuario {
    private int anosLealtad;
    private int edad;

    public Gerente(String nombre, String apellido, int anosLealtad, int edad) {
        super(nombre, apellido, Rol.GERENTE);
        this.anosLealtad = anosLealtad;
        this.edad = edad;
    }
}
