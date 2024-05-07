package Biblioteca.libros;

import Biblioteca.libros.constants.Genero;
import Biblioteca.libros.constants.SubGeneroTerror;
import Biblioteca.libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class LibroTerror  extends Libro{
    private SubGeneroTerror subGeneroTerror;

    public LibroTerror(String nombre, String autor, String editorial, LocalDate fechaDePubliacacion, Genero genero, double precio, int stock, SubGeneroTerror subGeneroTerror) {
        super(nombre, autor, editorial, fechaDePubliacacion, Genero.TERROR, precio, stock);
        this.subGeneroTerror = subGeneroTerror;
    }

    public static void registrarLibro(){
        ArrayList<String> datosComun = LibrosUtils.obtenerDatosComun();
        String nombre= datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaDePubliacacion = LocalDate.parse(datosComun.get(3));
        double precio=Double.parseDouble(datosComun.get(4));
        int stock=Integer.parseInt(datosComun.get(5));

        System.out.println("Ingrese el subgenero del libro");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Psicologico");
        System.out.println("2. Crimen");

        int opcionSubgenero = 0;
        SubGeneroTerror subgeneroInput = null;
        if (opcionSubgenero == 1) {
            subgeneroInput = SubGeneroTerror.PSICOLOGICO;
        } else {
            subgeneroInput = SubGeneroTerror.CRIMEN;
        }

    }
}
