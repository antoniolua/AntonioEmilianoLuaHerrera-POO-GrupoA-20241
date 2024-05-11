package Biblioteca.libros;

import Biblioteca.Biblioteca;
import Biblioteca.libros.constants.Genero;
import Biblioteca.libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;

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

}
