package Usuarios;

import Usuarios.utils.Rol;

import java.time.LocalDate;

public class Trabajador extends Usuario {
    private float suelo;
    private String rfc;


    public Trabajador(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String numeroTelefono, String nombreUsuario, String contrasena, float suelo, String rfc) {
        super(nombre, apellido, rol, fechaNacimiento, numeroTelefono, nombreUsuario, contrasena);
        this.suelo = suelo;
        this.rfc = rfc;
    }
}
