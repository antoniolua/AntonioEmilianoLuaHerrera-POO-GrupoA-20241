package Biblioteca.libros;

import Biblioteca.libros.constants.Genero;

import java.time.LocalDate;

public class LibroComedia extends Libro{
    public LibroComedia(String nombre, String autor, String editorial, LocalDate fechaDePubliacacion, Genero genero, double precio, int stock) {
        super(nombre, autor, editorial, fechaDePubliacacion, Genero.COMEDIA, precio, stock);
    }
}
