package Biblioteca.libros;

import Biblioteca.Biblioteca;
import Biblioteca.libros.constants.Genero;
import Usuarios.Usuario;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public abstract class Libro {
    private static int CANTIDAD_LIBROS = 1;
    private int id;
    private String nombre;
    private String autor;
    private String editorial;
    private String fechaDePubliacacion;
    private Genero genero;
    private double precio;
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


    public String toString() {
        return String.format("Libro{id=%d, nombre='%s', autor='%s', editorial='%s', fechaDePublicacion='%s', genero=%s, precio=%.2f, stock=%d}",
                id, nombre, autor, editorial, fechaDePubliacacion, genero, precio, stock);
    }

    protected abstract void filtrarPorPrecio(double precio);
    protected abstract void filtrarPorRangoPrecio(double precio1,double precio2);
    protected abstract void filtrarPorLetra(char letra);

    //Mostrar Libro de acuerdo a su categoria




    //listado de los libros general, y de acuerdo a su categoria
    public static void ListadoGeneral() {
        System.out.println("**+ Listado General ***");
        for (ArrayList<Libro> listaLibros : Biblioteca.libros.values()) {
            for (Libro libro : listaLibros) {
                System.out.println(libro.toString());
                System.out.println();
            }
        }
    }

    public static void ListadoGenero() {
        Scanner sc = new Scanner(System.in);
        String opc = null;
        System.out.println("¿Que genero desea listar?");
        System.out.println("1. Terror");
        System.out.println("2. Comedia");
        System.out.println("3. Accion");
        System.out.println("4. Listado General");
        System.out.println("5. Salir");
        opc = sc.nextLine();
        do {
            switch (opc) {
                case "1":

                   break;
                case "2":
                    break;
                case "3":

                    break;
                case "4":
                    ListadoGeneral();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        } while (opc != "5");
    }






    //Eliminacion de los libros por categoria

    public static void eliminacionPorCategoria(){
        Scanner sc = new Scanner(System.in);
        String opc = null;
        do {
            System.out.println("\n¿Que genero desea eliminar el libro?");
            System.out.println("1. Terror");
            System.out.println("2. Comedia");
            System.out.println("3. Accion");
            System.out.println("4. Salir");
            opc = sc.nextLine();
            System.out.println();
            switch (opc) {
                case "1":
                    LibroTerror.eliminarLibroTerror();
                      break;
                case "2":
                    LibroComedia.eliminarLibroComedia();
                    break;
                case "3":
                    LibroAccion.eliminarLibroAccion();
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("opcion invalida");
                    break;
            }

        } while (opc != "4");
    }



    //Registrar LIbro de acuerdo a su categoria
    public static void registrarLibroCategoria(){

        Scanner sc = new Scanner(System.in);
        String opc = null;
        do {
            System.out.println("\n *** Registrar Libro por Categoria ***");
        System.out.println("¿Que genero desea registrar el libro?");
        System.out.println("1. Terror");
        System.out.println("2. Comedia");
        System.out.println("3. Accion");
        System.out.println("4. Salir");
        opc = sc.nextLine();

            switch (opc) {
                case "1":
                    LibroTerror.registrarLibro();
                    break;
                case "2":
                    LibroComedia.registrarLibro();
                    break;
                case "3":
                    LibroAccion.registrarLibro();
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
            }

        } while (!opc.equals("4"));
    }

    //GETTER
    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getFechaDePubliacacion() {
        return fechaDePubliacacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }


}
