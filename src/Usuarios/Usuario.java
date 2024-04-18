package Usuarios;

import Usuarios.utils.Rol;

import java.time.LocalDate;

public class Usuario {
    private static int CANTIDAD_USUARIO = 0;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private LocalDate fechaNacimiento;
    private String contrasena;
    private String nombreUsuario;
    private String numeroTelefono;

    public Usuario(String nombre, String apellido, Rol rol,LocalDate fechaNacimiento,String numeroTelefono,String nombreUsuario,String contrasena) {
        this.id = CANTIDAD_USUARIO;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.numeroTelefono=numeroTelefono;
        CANTIDAD_USUARIO++;
    }



    @Override
    public String toString() {
        return String.format("ID: %d, Nombre completo: %s , Apellido: %s, Numero de telefono: %s, rol: %s", id, nombre, apellido,numeroTelefono, rol);
    }


    public static int getCantidadUsuario() {
        return CANTIDAD_USUARIO;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }
}
