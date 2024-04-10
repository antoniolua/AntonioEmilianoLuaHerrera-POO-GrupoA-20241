package tienda;

import productos.Alimento;
import productos.Belleza;
import productos.Electrodomestico;
import productos.Limpieza;

import java.util.ArrayList;

public class Tienda {
    private static final String password ="123";
    public static ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
    public static ArrayList<Limpieza> limpiezas = new ArrayList<>();
    public static ArrayList<Belleza> bellezas = new ArrayList<>();
    public static ArrayList<Alimento> alimentos = new ArrayList<>();


    public void addElectrodomestico(Electrodomestico electrodomestico){
        electrodomesticos.add(electrodomestico);
        System.out.println("Producto de Electrodomestico añdadido correcatamente");
    }
    public void addLimpieza(Limpieza limpieza){
        limpiezas.add(limpieza);
        System.out.println("Producto de Limpieza añdadido correcatamente");

    }
    public void addBelleza(Belleza belleza){
        bellezas.add(belleza);
        System.out.println("Producto de Belleza añdadido correcatamente");
    }
    public void addAlimeto(Alimento alimento){
        alimentos.add(alimento);
        System.out.println("Producto de Alimento añdadido correcatamente");
    }


    public static boolean checkPaswword(String contra){
        if (contra.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

}
