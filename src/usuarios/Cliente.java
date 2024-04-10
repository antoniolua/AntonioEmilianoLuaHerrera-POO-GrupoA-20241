package usuarios;

import usuarios.utils.Rol;

import java.time.LocalDate;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido) {
        //definimos el rol del cliente
        super(nombre, apellido, Rol.ClIENTE);

        //traerme la fecha actual y asignarla a dicho atributo
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
