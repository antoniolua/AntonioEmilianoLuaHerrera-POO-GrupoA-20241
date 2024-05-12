package Usuarios.Empleados;

import Banco.Banco;
import Usuarios.Empleado;
import Usuarios.Usuario;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursal;
import Utils.UsuarioEnSesion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static Banco.Banco.usuarios;
import static Utils.Utils.obtenerDatosComun;

public class EjecutivoDeCuenta extends Empleado {

    public EjecutivoDeCuenta(String nombre, String apellido, LocalDate fechaNacimiento, String ciudad, String estado, String rfc, String curp, String direccion, String contrasena, Sucursal sucursal, String usuario, double salario, LocalDate fechaInicio) {
        super(nombre, apellido, fechaNacimiento, ciudad, estado, rfc, curp, direccion, contrasena, Rol.EjecutivoDeCuenta, sucursal, salario, fechaInicio, usuario);
    }

    public static void registrarEjecutivo(){
        System.out.println("Has seleccionado la opcion de registrar un Ejecutivo de cuenta. ");
        ArrayList<String> datosComun = obtenerDatosComun(Rol.EjecutivoDeCuenta);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        LocalDate fechaNacimiento = LocalDate.parse(datosComun.get(2));
        String ciudad = datosComun.get(3);
        String estado = datosComun.get(4);
        String rfc = datosComun.get(5);
        String curp = datosComun.get(6);
        String direccion = datosComun.get(7);
        String contrasena = datosComun.get(8);
        Sucursal sucursal = UsuarioEnSesion.getUsuarioActual().getSucursal();

        EjecutivoDeCuenta ejecutivoDeCuenta = new EjecutivoDeCuenta(nombre, apellido, fechaNacimiento, ciudad, estado, rfc, curp, direccion, contrasena, sucursal, datosComun.get(9), Empleado.obtenerSalario(), Empleado.obtenerFechaInicio());

        if (!usuarios.containsKey(sucursal)) {
            usuarios.put(sucursal, new HashMap<>());
        }
        if (!usuarios.get(sucursal).containsKey(Rol.EjecutivoDeCuenta)) {
            usuarios.get(sucursal).put(Rol.EjecutivoDeCuenta, new ArrayList<>());
        }

        usuarios.get(sucursal).get(Rol.EjecutivoDeCuenta).add(ejecutivoDeCuenta);


    }

    public static void mostrarAllEjecutivoDeCuenta() {
        ArrayList<Usuario> usuarios = Banco.usuarios.get(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal()).get(Rol.EjecutivoDeCuenta);
        String sucursal = UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal().name();
        if (usuarios.isEmpty()) {
            System.out.println("No hay ejecutivos de cuenta en la sucursal " + sucursal);
        }
        else {
            System.out.println("Ejecutivos de cuenta en la sucursal " + sucursal + ":");
            for (Usuario usuario : usuarios){
                EjecutivoDeCuenta ejecutivoDeCuenta = (EjecutivoDeCuenta) usuario;
                System.out.printf("Nombre: %s %s\n" +
                                "Fecha de nacimiento: %s Ciudad y estado: %s, %s\n" +
                                "RFC: %s CURP: %s Direccion: %s\n", ejecutivoDeCuenta.getNombre(), ejecutivoDeCuenta.getApellido(),
                        ejecutivoDeCuenta.getFechaNacimiento().toString(), ejecutivoDeCuenta.getCiudad(), ejecutivoDeCuenta.getEstado(),
                        ejecutivoDeCuenta.getRfc(), ejecutivoDeCuenta.getCurp(), ejecutivoDeCuenta.getDireccion());
            }
        }
    }
}
