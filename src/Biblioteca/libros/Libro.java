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

//    @Override
//    public String String() {
//
//        return "Nombre: " + nombre +
//                ", Autor: " + autor +
//                ", Editorial: " + editorial +
//                ", Fecha de publiacacion: " + fechaDePubliacacion +
//                ", Género: " + genero +
//                ", Precio: $" + String.format("%.2f", precio);
//    }


    protected abstract void filtrarPorPrecio(double precio);
    protected abstract void filtrarPorRangoPrecio(double precio1,double precio2);
    protected abstract void filtrarPorLetra(char letra);





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
                    mostrarLibrosCategoria(Genero.TERROR);
                case "2":
                    mostrarLibrosCategoria(Genero.COMEDIA);
                    break;
                case "3":
                    mostrarLibrosCategoria(Genero.ACCION);
                    break;
                case "4":
                    ListadoGeneral();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        } while (opc != "5");
    }


    public static boolean mostrarLibrosCategoria(Genero genero) {
        boolean hayLibros = false; // Bandera para saber si hay libros del género dado

        System.out.println("Genero: "+genero);
        // Recorre todas las listas de libros en la biblioteca
        for (ArrayList<Libro> listaLibro : Biblioteca.libros.values()) {
            for (Libro libro : listaLibro) {
                // Verifica si el libro es del género deseado
                if (libro.getGenero() == genero) {
                    hayLibros = true; // Indica que se encontró al menos un libro
                    System.out.println(libro.toString());

                    // Si es del género "Terror" y tiene subgénero, muéstralo
                    if (genero == Genero.TERROR && libro instanceof LibroTerror) {
                        LibroTerror libroTerror = (LibroTerror) libro; // Casting a LibroTerror
                        System.out.println("Subgénero: " + libroTerror.getSubGeneroTerror());
                    }
                    System.out.println();

                }

            }

        }

    // Si no se encontraron libros del género dado, muestra un mensaje
        if (!hayLibros) {
            System.out.println("No hay libros en esta categoría.");
     hayLibros = false;
        }
        return hayLibros;
    }

    //Eliminacion de los libros por categoria

    public static void eliminacionPorCategoria(){
        Scanner sc = new Scanner(System.in);
        String opc = null;
        System.out.println("¿Que genero desea eliminar el libro?");
        System.out.println("1. Terror");
        System.out.println("2. Comedia");
        System.out.println("3. Accion");
        System.out.println("4. Salir");
        opc = sc.nextLine();
        do {
            switch (opc) {
                case "1":
                    if (mostrarLibrosCategoria(Genero.TERROR) == false){
                        System.out.println("---Agregue un Libro---");
                        return;
                    }else {
                        eliminarLibro(Genero.TERROR);
                      return;
                    }
                case "2":
                    if (mostrarLibrosCategoria(Genero.COMEDIA) == false){
                        System.out.println("---Agregue un Libro---");
                        return;

                    }else {
                        eliminarLibro(Genero.COMEDIA);
                        eliminacionPorCategoria();
                        return;
                    }
                case "3":
                    if (mostrarLibrosCategoria(Genero.ACCION) == false){
                        System.out.println("---Agregue un Libro---");
                        return;
                    }else {
                        eliminarLibro(Genero.ACCION);
                        return;
                    }
                case "4":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        } while (opc != "4");
    }


    public static void eliminarLibro(Genero genero){
        boolean libroEncontrado=false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del libro que desea eliminar: ");
        String libroEliminar= sc.nextLine();
        for (ArrayList<Libro> listaLibro :Biblioteca.libros.values()){
            Iterator<Libro> iterador = listaLibro.iterator();

            while (iterador.hasNext()) {
                Libro libro = iterador.next();

                if (libro.getNombre().equals(libroEliminar) && libro.getGenero() == genero) {
                    iterador.remove();
                    libroEncontrado = true;
                    System.out.println("Libro '" + libroEliminar + "' eliminado correctamente.");
                    break;
                }
            }

            if (libroEncontrado) {
                break;
            }

        }
        if (!libroEncontrado) {
            System.out.println("Libro '" + libroEliminar + "' no fue encontrado.");
        }

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
