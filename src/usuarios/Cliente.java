package Usuarios;

import usuarios.utils.Rol;

import java.time.LocalDate;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String contrasena, String nombreUsuario, LocalDate fechaRegistro) {
        //definimos el rol del cliente
        super(nombre, apellido, rol, fechaNacimiento, contrasena, nombreUsuario);
        //traerme la fecha actual y asignarla a dicho atributo
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString() {
        return String.format("%s, fecha de registro: %s", super.toString(), fechaRegistro);
    }
}
