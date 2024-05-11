package Biblioteca.libros.utils;

import Biblioteca.libros.Libro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrosUtils {
    public static ArrayList<String> obtenerDatosComun() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();

        System.out.println("Ingresa el nombre del libro: ");
        String nombre = sc.nextLine();

        System.out.println("Ingresa el autor del libro: ");
        String autor = sc.nextLine();

        System.out.println("Ingresa el editorial del libro: ");
        String editorial = sc.nextLine();

        LocalDate fechaDePublicacion = obtenerFechaDePublicacion();

        System.out.println("Ingresa el precio del libro: ");
        double precio = sc.nextDouble();

        System.out.println("Ingresa el stock del libro: ");
        int stock = sc.nextInt();

        datosComun.addAll(Arrays.asList(nombre, autor, editorial, fechaDePublicacion.toString(), String.valueOf(precio),String.valueOf(stock)));

        return datosComun;

    }

    public static LocalDate obtenerFechaDePublicacion(){
        Scanner read= new Scanner(System.in);
        int dia, mes, ano;
        LocalDate fechaNacimiento;
        while (true) {
            try {
                System.out.println("Ingresa el dia de publicacion del libro: ");
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
                System.out.println("Ingresa el mes de publicacion del libro:  ");
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
                System.out.println("Ingresa el año de publicacion del libro: ");
                int numero = read.nextInt();

                if (numero >= 1920 && numero <= 2024) {
                    ano = numero;
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero entre 1920 y 2024. ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                read.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        return fechaNacimiento = LocalDate.of(ano, mes, dia);
    }


}
