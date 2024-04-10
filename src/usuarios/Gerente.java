package Usuarios;

import usuarios.utils.Rol;

import java.time.LocalDate;

public class Gerente extends Usuario {
    private int anosLealtad;
    private int sueldo;

    public Gerente(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String contrasena, String nombreUsuario, int anosLealtad, int sueldo) {
        super(nombre, apellido, rol, fechaNacimiento, contrasena, nombreUsuario);
        this.anosLealtad = anosLealtad;
        this.sueldo = sueldo;
    }
}
