package Biblioteca.libros;

import Biblioteca.libros.constants.Genero;

import java.time.LocalDate;

public abstract class Libro {
    private static  int CANTIDAD_LIBROS = 1;
    private int id;
    private String nombre;
    private String autor;
    private  String editorial;
    private  LocalDate fechaDePubliacacion;
    private Genero genero;
    private  double precio;
    private int stock;

    public Libro(String nombre, String autor, String editorial, LocalDate fechaDepubliacacion, Genero genero, double precio, int stock) {
        this.id = CANTIDAD_LIBROS;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaDePubliacacion = fechaDePubliacacion;
        this.genero = genero;
        this.precio = precio;
        this.stock = stock;
        CANTIDAD_LIBROS++;
    }
    protected abstract void filtrarPorPrecio(double precio);

    public  double getPrecio(){
        return precio;
    }
}
