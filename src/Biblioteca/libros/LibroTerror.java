package Biblioteca.libros;

import Biblioteca.Biblioteca;
import Biblioteca.libros.constants.Genero;
import Biblioteca.libros.constants.SubGeneroTerror;
import Biblioteca.libros.utils.LibrosUtils;
import Usuarios.Usuario;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class LibroTerror extends Libro {
    private SubGeneroTerror subGeneroTerror;

    public LibroTerror(String nombre, String autor, String editorial, LocalDate fechaDePubliacacion, Genero genero, double precio, int stock, SubGeneroTerror subGeneroTerror) {
        super(nombre, autor, editorial, fechaDePubliacacion, Genero.TERROR, precio, stock);
        this.subGeneroTerror = subGeneroTerror;
    }

    public SubGeneroTerror getSubGeneroTerror() {
        return subGeneroTerror;
    }

    public static void registrarLibro() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datosComun = LibrosUtils.obtenerDatosComun();
        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaDePubliacacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        System.out.println("Ingrese el subgenero del libro");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Psicologico");
        System.out.println("2. Crimen");

        int opcionSubgenero = 0;
        opcionSubgenero = sc.nextInt();
        SubGeneroTerror subgeneroInput = null;
        if (opcionSubgenero == 1) {
            subgeneroInput = SubGeneroTerror.PSICOLOGICO;

        } else {
            subgeneroInput = SubGeneroTerror.CRIMEN;
        }


        LibroTerror libroTerror = new LibroTerror(nombre, autor, editorial, fechaDePubliacacion, Genero.TERROR, precio, stock, subgeneroInput);
        System.out.println("Libro " + libroTerror.getNombre() + " registrado exitosamente");
    }

    @Override
    public void filtrarPorPrecio(double precio) {
        Biblioteca.libros.get(Genero.TERROR).stream()
                .filter(libro -> libro.getPrecio() >= precio)
                .forEach(libro -> System.out.println(libro.toString()));

        //conviertes, filtras, imprimes
    }

    public void filtrarPorRangoPrecio(double precio1, double precio2) {
        Biblioteca.libros.get(Genero.TERROR).stream()
                .filter(libro -> libro.getPrecio() >= precio1 && libro.getPrecio() <= precio2)
                .forEach(libro -> System.out.println(libro.toString()));
    }

    public void filtrarPorLetra(char letra) {
        Biblioteca.libros.get(Genero.TERROR).stream()
                .filter(libro -> libro.getNombre().charAt(0) == letra)
                .forEach(libro -> System.out.println(libro.toString()));
    }


    public static void mostrarLibrosTerror() {
        System.out.println("Genero: " + Genero.TERROR);
        ArrayList<Libro> listaLibros = Biblioteca.libros.get(Genero.TERROR);
        if (listaLibros.isEmpty()) {
            System.out.println("---Agregue un Libro---");
        } else {
            for (Libro librosTerror : listaLibros) {
                LibroTerror libroTerror = (LibroTerror) librosTerror;
                System.out.println(libroTerror.toString());
            }
        }
    }
    public static void eliminarLibroTerror() {
        mostrarLibrosTerror();
        boolean libroEncontrado = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del libro que desea eliminar: ");
        String libroEliminar = sc.nextLine();

        for (Libro listaLibro : Biblioteca.libros.get(Genero.TERROR)) {
            LibroTerror librosTerror = (LibroTerror) listaLibro;
            if (librosTerror.getNombre().equals(libroEliminar)){
                libroEncontrado = true;

                Biblioteca.libros.get(Genero.TERROR).remove(librosTerror);
                System.out.println("Libro eliminado");
                return;
            }

        }
        if (!libroEncontrado) {
            System.out.println("Libro no encontrado");
        }
    }

}
