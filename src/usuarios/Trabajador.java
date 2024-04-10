package Usuarios;

import usuarios.utils.Rol;

import java.time.LocalDate;

public class Trabajador extends Usuario {
    private float suelo;
    private String rfc;


    public Trabajador(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String contrasena, String nombreUsuario, float suelo, String rfc) {
        super(nombre, apellido, rol, fechaNacimiento, contrasena, nombreUsuario);
        this.suelo = suelo;
        this.rfc = rfc;
    }
}
