package Biblioteca.utils;

import Biblioteca.Biblioteca;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatosComun {

    public static ArrayList<String> obtenerDatosComunes(Rol rol){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datosComunes=new ArrayList<>();
        String rolActual = rol == Rol.ClIENTE ? "Cliente" : rol == Rol.TRABAJADOR ?
                "Trabajador" : "Gerente";
        System.out.printf("Registrar %s \n",rolActual);

        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese su apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (YYYY-MM-DD):");
        LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine());

        String telefono= obtenerNumeroTelefono();
        String nombreUsuario= obtenerNombreUsuario();

        System.out.println("Ingrese su contraseña: ");
        String contrasena = sc.nextLine();

        datosComunes.addAll(Arrays.asList(nombre, apellido,fechaNacimiento.toString(), telefono, nombreUsuario, contrasena));
        return datosComunes;
    }

    private static String obtenerNumeroTelefono() {
        Scanner scanner = new Scanner(System.in);
        boolean numeroExistente = true;
        String telefono = "";
        do {
            System.out.println("Ingresa el numero de telefono");
            telefono = scanner.nextLine();
            numeroExistente = false;
            for (ArrayList<Usuario> listaUsuarios : Biblioteca.usuarios.values()){
                for (Usuario usuario : listaUsuarios){
                    if (usuario.getNumeroTelefono().equals(telefono)){
                        numeroExistente=true;
                    }
                }
            }
            if (numeroExistente) {
                System.out.println("El numero ya existe. Intenta de nuevo\n");
            }
        } while (numeroExistente);
        return telefono;
    }

    private static String obtenerNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean nombreUsuarioExistente = true;
        String nombreUsuario = "";
        do {
            System.out.println("Ingresa el el nombre de usuario");
            nombreUsuario = scanner.nextLine();
            nombreUsuarioExistente = false;
            for (ArrayList<Usuario> listaUsuarios : Biblioteca.usuarios.values()){
                for (Usuario usuario : listaUsuarios){
                    if (usuario.getNombreUsuario().equals(nombreUsuario)){
                        nombreUsuarioExistente = true;
                    }
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("El nombre de usuario ya existe. Intenta de nuevo\n");
            }
        } while (nombreUsuarioExistente);
        return nombreUsuario;
    }

}
