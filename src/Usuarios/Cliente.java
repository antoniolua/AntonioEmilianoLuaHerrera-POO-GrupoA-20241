package Usuarios;

import Usuarios.utils.Rol;

import java.time.LocalDate;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;


    public Cliente(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String numeroTelefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, rol, fechaNacimiento, numeroTelefono, nombreUsuario, contrasena);
        this.fechaRegistro = LocalDate.now();
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString() {
        return String.format("%s, fecha de registro: %s", super.toString(), fechaRegistro);
    }


}
