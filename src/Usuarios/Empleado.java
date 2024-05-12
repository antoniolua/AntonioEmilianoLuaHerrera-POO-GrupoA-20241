package Usuarios;

import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursal;
import java.util.Scanner;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class Empleado extends Usuario {
    protected double salario;
    protected LocalDate fechaInicio;

    public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String ciudad, String estado, String rfc, String curp, String direccion, String contrasena, Rol rol, Sucursal sucursal, double salario, LocalDate fechaInicio , String usuario) {
        super(nombre, apellido, fechaNacimiento, ciudad, estado, rfc, curp, direccion, contrasena, rol, sucursal , usuario);
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }

    public static LocalDate obtenerFechaInicio(){
        Scanner read = new Scanner(System.in);
        int dia, mes, ano;
        LocalDate fechaInicio;
        while (true) {
            try {
                System.out.println("Ingresa la fecha de inicio de trabajo: ");
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
                System.out.println("Ingresa el mes de inicio de trabajo: ");
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
                System.out.println("Ingresa el año de inicio de trabajo: ");
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
        return fechaInicio = LocalDate.of(ano, mes, dia);
    }

    public static double obtenerSalario(){
        Scanner read = new Scanner(System.in);
        System.out.println("Ingresa el salario deseado para este empleado: ");
        double salario = read.nextDouble();
        return salario;
    }

}
