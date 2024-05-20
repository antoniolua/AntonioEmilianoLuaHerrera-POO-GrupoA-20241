package Usuarios;

import Biblioteca.Biblioteca;
import Biblioteca.utils.DatosComun;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Usuario {
     private String fechaRegistro;


    public Cliente(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String numeroTelefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, rol, fechaNacimiento, numeroTelefono, nombreUsuario, contrasena);
        this.fechaRegistro = LocalDate.now().toString();
    }

    public static void registrarCliente() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComunes(Rol.ClIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        LocalDate fechaNacimiento = LocalDate.parse(datosComun.get(2));
        String telefono = datosComun.get(3);
        String nombreUsuario = datosComun.get(4);
        String contrasena = datosComun.get(5);

        Cliente cliente = new Cliente(nombre, apellido, Rol.ClIENTE, fechaNacimiento, telefono, nombreUsuario, contrasena);
        if (!Biblioteca.usuarios.containsKey(Rol.ClIENTE)) {
            Biblioteca.usuarios.put(Rol.ClIENTE, new ArrayList<Usuario>());
        }
        Biblioteca.usuarios.get(Rol.ClIENTE).add(cliente);
        Biblioteca.guardarEnJSON();
        System.out.println("\nCliente Registrado\n");
    }
    public static void mostrarClientes(){
        System.out.println("*** CLIENTES ***");
        if (Biblioteca.usuarios.containsKey(Rol.ClIENTE)){
            for (Usuario clientes : Biblioteca.usuarios.get(Rol.ClIENTE)){
                System.out.println(clientes.toString());
            }
        }else {
            System.out.println("No hay clientes registrados.");
        }

    }
}
