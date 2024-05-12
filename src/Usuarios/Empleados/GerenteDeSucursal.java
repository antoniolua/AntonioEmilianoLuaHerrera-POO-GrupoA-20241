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
import java.util.Map;

import static Banco.Banco.usuarios;
import static Utils.Utils.obtenerDatosComun;

public class GerenteDeSucursal extends Empleado {

    public GerenteDeSucursal(String nombre, String apellido, LocalDate fechaNacimiento, String ciudad, String estado, String rfc, String curp, String direccion, String contrasena, Sucursal sucursal, String usuario, double salario, LocalDate fechaInicio) {
        super(nombre, apellido, fechaNacimiento, ciudad, estado, rfc, curp, direccion, contrasena, Rol.GerenteDeSucursal, sucursal, salario, fechaInicio, usuario);
    }

    public static void registrarGerente(){
        System.out.println("Has seleccionado la opcion de registrar un Gerente de sucursal. ");
        ArrayList<String> datosComun = obtenerDatosComun(Rol.GerenteDeSucursal);

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
        Double salario = obtenerSalario();
        LocalDate fechaInicio = obtenerFechaInicio();

        GerenteDeSucursal gerenteDeSucursal = new GerenteDeSucursal(nombre, apellido, fechaNacimiento, ciudad, estado, rfc, curp, direccion, contrasena, sucursal, datosComun.get(9), salario, fechaInicio);

        if (!usuarios.containsKey(sucursal)) {
            usuarios.put(sucursal, new HashMap<>());
        }
        if (!usuarios.get(sucursal).containsKey(Rol.GerenteDeSucursal)) {
            usuarios.get(sucursal).put(Rol.GerenteDeSucursal, new ArrayList<>());
        }

        usuarios.get(sucursal).get(Rol.GerenteDeSucursal).add(gerenteDeSucursal);

    }

    public static void mostrarAllGerenteDeSucursal() {
        HashMap<Sucursal, HashMap<Rol, ArrayList<Usuario>>> usuariosPorSucursal = Banco.usuarios;
        for (Map.Entry<Sucursal, HashMap<Rol, ArrayList<Usuario>>> sucursalEntry : usuariosPorSucursal.entrySet()) {
            Sucursal sucursal = sucursalEntry.getKey();
            HashMap<Rol, ArrayList<Usuario>> rolesPorSucursal = sucursalEntry.getValue();

            // Verificar si la sucursal actual contiene gerentes de sucursal
            if (rolesPorSucursal.containsKey(Rol.GerenteDeSucursal)) {
                ArrayList<Usuario> gerentesDeSucursal = rolesPorSucursal.get(Rol.GerenteDeSucursal);
                System.out.println("Gerentes de sucursal en la sucursal " + sucursal + ":");
                for (Usuario gerente : gerentesDeSucursal) {
                    System.out.printf("Nombre: %s %s\n" +
                                    "Fecha de nacimiento: %s Ciudad y estado: %s, %s\n" +
                                    "RFC: %s CURP: %s Direccion: %s\n", gerente.getNombre(), gerente.getApellido(),
                            gerente.getFechaNacimiento().toString(), gerente.getCiudad(), gerente.getEstado(),
                            gerente.getRfc(), gerente.getCurp(), gerente.getDireccion());
                    // Aquí puedes agregar más detalles si deseas mostrarlos
                }
            } else {
                System.out.println("No hay gerentes de sucursal en la sucursal " + sucursal);
            }
        }
    }


}
