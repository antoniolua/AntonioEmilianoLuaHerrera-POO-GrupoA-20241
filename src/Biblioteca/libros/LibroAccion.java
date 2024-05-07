package Biblioteca.libros;

import Biblioteca.libros.constants.Genero;

import java.time.LocalDate;

public class LibroAccion extends Libro{
    public LibroAccion(String nombre, String autor, String editorial, LocalDate fechaDePubliacacion, Genero genero, double precio, int stock) {
        super(nombre, autor, editorial, fechaDePubliacacion, Genero.ACCION, precio, stock);
    }
}
