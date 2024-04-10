package Usuarios;

import usuarios.utils.Rol;

import java.time.LocalDate;

public class Usuario {
    private static int CANTIDAD_USUARIO = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private LocalDate fechaNacimiento;
    private String contrasena;
    private String nombreUsuario;

    public Usuario(String nombre, String apellido, Rol rol,LocalDate fechaNacimiento,String contrasena,String nombreUsuario) {
        this.id = CANTIDAD_USUARIO;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        CANTIDAD_USUARIO++;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Nombre completo: %s , Apellido: %s, rol: %s", id, nombre, apellido, rol);
    }
}
