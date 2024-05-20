package Biblioteca.libros;

import Biblioteca.Biblioteca;
import Biblioteca.libros.constants.Genero;
import Biblioteca.libros.utils.LibrosUtils;
import Usuarios.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroComedia extends Libro {
    public LibroComedia(String nombre, String autor, String editorial, LocalDate fechaDePubliacacion, Genero genero, double precio, int stock) {
        super(nombre, autor, editorial, fechaDePubliacacion, Genero.COMEDIA, precio, stock);
    }

    public static void registrarLibro() {
        ArrayList<String> datosComun = LibrosUtils.obtenerDatosComun();
        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaDePubliacacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        LibroComedia libroTerror = new LibroComedia(nombre, autor, editorial, fechaDePubliacacion, Genero.COMEDIA, precio, stock);
    }

    @Override
    public void filtrarPorPrecio(double precio) {
        Biblioteca.libros.get(Genero.COMEDIA).stream() //convierte
                .filter(libro -> libro.getPrecio() >= precio) //filtra
                .forEach(libro -> System.out.println(libro.toString())); //imprime

    }



    public void filtrarPorRangoPrecio(double precio1,double precio2){
        Biblioteca.libros.get(Genero.COMEDIA).stream()
                .filter(libro -> libro.getPrecio() >= precio1 && libro.getPrecio()<=precio2)
                .forEach(libro -> System.out.println(libro.toString()));
    }

    public void filtrarPorLetra(char letra){
        Biblioteca.libros.get(Genero.COMEDIA).stream()
                .filter(libro -> libro.getNombre().charAt(0) == letra)
                .forEach(libro -> System.out.println(libro.toString()));
    }

    public void mostrarLibros() {
        System.out.println("Genero: " + Genero.ACCION);
        ArrayList<Usuario> listaUsuario = Biblioteca.usuarios.get(Genero.ACCION);
        if (listaUsuario.isEmpty()) {
            System.out.println("---Agregue un Libro---");
        } else {
            for (Usuario usuarios : listaUsuario) {
                System.out.println(usuarios.toString());
            }
        }

    }

    public static void mostrarLibrosComedia() {
        System.out.println("Genero: " + Genero.COMEDIA);
        ArrayList<Libro> listaLibros = Biblioteca.libros.get(Genero.COMEDIA);
        if (listaLibros.isEmpty()) {
            System.out.println("---Agregue un Libro---");
        } else {
            for (Libro librosComedia : listaLibros) {
                LibroComedia libroComedia = (LibroComedia) librosComedia;
                System.out.println(libroComedia.toString());
            }
        }
    }
    public static void eliminarLibroComedia() {
        mostrarLibrosComedia();
        boolean libroEncontrado = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del libro que desea eliminar: ");
        String libroEliminar = sc.nextLine();

        for (Libro listaLibro : Biblioteca.libros.get(Genero.COMEDIA)) {
            LibroComedia librosComedia = (LibroComedia) listaLibro;
            if (librosComedia.getNombre().equals(libroEliminar)){
                libroEncontrado = true;
                Biblioteca.libros.get(Genero.COMEDIA).remove(librosComedia);
                System.out.println("Libro eliminado");
                return;
            }

        }
        if (!libroEncontrado) {
            System.out.println("Libro no encontrado");
        }
    }


}
