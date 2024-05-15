package Biblioteca.utils;

import Biblioteca.Biblioteca;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
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
        LocalDate fechaNacimiento = obtenerFechaNacimiento();

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

    public static LocalDate obtenerFechaNacimiento(){
        Scanner read= new Scanner(System.in);
        int dia, mes, ano;
        LocalDate fechaNacimiento;
        while (true) {
            try {
                System.out.println("Ingresa el dia de nacimiento: ");
                int numero = read.nextInt();

                if (numero >= 1 && numero <= 31) {
                    dia = numero;
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero entre 01 y 31.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                read.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        while (true) {
            try {
                System.out.println("Ingresa el mes de nacimiento: ");
                int numero = read.nextInt();

                if (numero >= 1 && numero <= 12) {
                    mes = numero;
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero entre 01 y 12.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                read.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        while (true) {
            try {
                System.out.println("Ingresa el año de nacimiento: ");
                int numero = read.nextInt();

                if (numero >= 1920 && numero <= 2006) {
                    ano = numero;
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero entre 1920 y 2006. ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                read.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        return fechaNacimiento = LocalDate.of(ano, mes, dia);
    }

}
