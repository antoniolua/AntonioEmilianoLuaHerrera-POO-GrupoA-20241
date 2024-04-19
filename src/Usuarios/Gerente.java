package Usuarios;

import Usuarios.utils.Rol;

import java.time.LocalDate;

public class Gerente extends Usuario {
    private int anosLealtad;
    private float sueldo;

    public Gerente(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String numeroTelefono, String nombreUsuario, String contrasena, int anosLealtad, float sueldo) {
        super(nombre, apellido, rol, fechaNacimiento, numeroTelefono, nombreUsuario, contrasena);
        this.anosLealtad = anosLealtad;
        this.sueldo = sueldo;
    }
}
