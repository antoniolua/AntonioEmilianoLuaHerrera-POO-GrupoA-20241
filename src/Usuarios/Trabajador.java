package Usuarios;

import Biblioteca.Biblioteca;
import Biblioteca.utils.DatosComun;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Trabajador extends Usuario {
    private float suelo;
    private String rfc;


    public Trabajador(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String numeroTelefono, String nombreUsuario, String contrasena, float suelo, String rfc) {
        super(nombre, apellido, rol, fechaNacimiento, numeroTelefono, nombreUsuario, contrasena);
        this.suelo = suelo;
        this.rfc = rfc;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", RFC: %s, Sueldo: %.2f", rfc, suelo);
    }

    public float getSuelo() {
        return suelo;
    }

    public void setSuelo(float suelo) {
        this.suelo = suelo;
    }


    public static void registrarTrabajador() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datosComun = DatosComun.obtenerDatosComunes(Rol.TRABAJADOR);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        LocalDate fechaNacimiento = LocalDate.parse(datosComun.get(2));
        String telefono = datosComun.get(3);
        String nombreUsuario = datosComun.get(4);
        String contrasena = datosComun.get(5);

        System.out.println("Ingrese su suelo");
        float sueldo = sc.nextFloat();
        System.out.println("Ingrese su rfc: ");
        sc.nextLine();
        String rfc = sc.nextLine();
        Trabajador trabajador = new Trabajador(nombre, apellido, Rol.TRABAJADOR, fechaNacimiento, telefono, nombreUsuario, contrasena, sueldo, rfc);

        if (!Biblioteca.usuarios.containsKey(Rol.TRABAJADOR)) {
            Biblioteca.usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        }
        Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
        System.out.println("\nCliente Registrado\n");
    }

    public static void mostrarTrabajador() {
        System.out.println("*** TRABAJADORES ***");
        if (Biblioteca.usuarios.containsKey(Rol.TRABAJADOR)) {
            for (Usuario trabajador : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {
                System.out.println(trabajador.toString());
            }
        } else {
            System.out.println("No hay trabajadores registrados.");
        }

    }

    public static void cambiarSueldo(String nombreUsuario, float nuevoSueldo) {
        boolean trabajadorEncontrado = false;
        if (Biblioteca.usuarios.containsKey(Rol.TRABAJADOR)) {
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    if (usuario instanceof Trabajador) {
                        Trabajador trabajador = (Trabajador) usuario;
                        trabajador.setSuelo(nuevoSueldo);
                        trabajadorEncontrado= true;
                        System.out.println("Sueldo del trabajador '" + nombreUsuario + "' ha sido actualizado.");
                    }
                    break;
                }
            }
        }else {
            System.out.println("No hay trabajadores registrados.");
        }
        if (!trabajadorEncontrado){
            System.out.println("Trabajador '" + nombreUsuario + "' no fue encontrado.");
        }
    }


}
