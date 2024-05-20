package Biblioteca.libros;

import Biblioteca.Biblioteca;
import Biblioteca.libros.constants.Genero;
import Biblioteca.libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroAccion extends Libro {
    public LibroAccion(String nombre, String autor, String editorial, LocalDate fechaDePubliacacion, Genero genero, double precio, int stock) {
        super(nombre, autor, editorial, fechaDePubliacacion, Genero.ACCION, precio, stock);
    }

    public static void registrarLibro() {
        ArrayList<String> datosComun = LibrosUtils.obtenerDatosComun();
        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaDePubliacacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));


        LibroAccion libroAccion = new LibroAccion(nombre, autor, editorial, fechaDePubliacacion, Genero.ACCION, precio, stock);
    }

    @Override
    public void filtrarPorPrecio(double precio) {
        Biblioteca.libros.get(Genero.ACCION).stream() //convierte
                .filter(libro -> libro.getPrecio() >= precio) //filtra
                .forEach(libro -> System.out.println(libro.toString())); //imprime

    }

    @Override
    public void filtrarPorRangoPrecio(double precio1, double precio2) {
        Biblioteca.libros.get(Genero.ACCION).stream()
                .filter(libro -> libro.getPrecio() >= precio1 && libro.getPrecio() <= precio2)
                .forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    public void filtrarPorLetra(char letra) {
        Biblioteca.libros.get(Genero.ACCION).stream()
                .filter(libro -> libro.getNombre().charAt(0) == letra)
                .forEach(libro -> System.out.println(libro.toString()));
    }


    public static void mostrarLibrosAccion() {
        System.out.println("Genero: " + Genero.ACCION);
        ArrayList<Libro> listaLibros = Biblioteca.libros.get(Genero.ACCION);
        if (listaLibros.isEmpty()) {
            System.out.println("---Agregue un Libro---");
        } else {
            for (Libro librosAccion : listaLibros) {
                LibroAccion libroAccion = (LibroAccion) librosAccion;
                System.out.println(libroAccion.toString());
            }
        }
    }

    public static void eliminarLibroAccion() {
        mostrarLibrosAccion();
        boolean libroEncontrado = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del libro que desea eliminar: ");
        String libroEliminar = sc.nextLine();

        for (Libro listaLibro : Biblioteca.libros.get(Genero.ACCION)) {
            LibroAccion librosAccion = (LibroAccion) listaLibro;
            if (librosAccion.getNombre().equals(libroEliminar)) {
                libroEncontrado = true;
                Biblioteca.libros.get(Genero.ACCION).remove(librosAccion);
                System.out.println("Libro eliminado");
                return;
            }

        }
        if (!libroEncontrado) {
            System.out.println("Libro no encontrado");
        }
    }


}
