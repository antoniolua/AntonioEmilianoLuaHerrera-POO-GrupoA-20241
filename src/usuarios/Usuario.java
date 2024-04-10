package usuarios;

import usuarios.utils.Rol;

public class Usuario {
    private static int CANTIDAD_USUARIO = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;

    public Usuario(String nombre, String apellido, Rol rol) {
        this.id = CANTIDAD_USUARIO;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        CANTIDAD_USUARIO++;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Nombre completo: %s , Apellido: %s, rol: %s", id, nombre, apellido, rol);
    }
}
