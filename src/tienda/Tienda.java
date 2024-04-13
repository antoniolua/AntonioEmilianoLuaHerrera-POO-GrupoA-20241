package tienda;

import productos.*;
import usuarios.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    private static final String password ="123";
    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
    public static ArrayList<Limpieza> limpiezas = new ArrayList<>();
    public static ArrayList<Belleza> bellezas = new ArrayList<>();
    public static ArrayList<Alimento> alimentos = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Producto> productos = new ArrayList<>();


//Productos

    //Electrodomestico
    public static void addElectrodomestico(Electrodomestico electrodomestico){
        electrodomesticos.add(electrodomestico);
        productos.add(electrodomestico);
        System.out.println("Producto de Electrodomestico añdadido correcatamente");
    }
    public static void mostrarElectrodomestico(){
        System.out.println("*** Productos de Electrodomestico ***");
        for (int i = 0; i < electrodomesticos.size(); i++) {
            System.out.println("["+i+"]"+"- Nombre: "+electrodomesticos.get(i).getNombre()+", Precio: "+electrodomesticos.get(i).getPrecio()+", Fechade importacion: "+ LocalDate.now()+", Numero Serie: "+electrodomesticos.get(i).getNumeroSerie()+", StockDisponible: "+electrodomesticos.get(i).getStock()+", Marca: "+electrodomesticos.get(i).getMarca());
        }
        System.out.println();
    }

    //Limpieza
    public static void addLimpieza(Limpieza limpieza){
        limpiezas.add(limpieza);
        productos.add(limpieza);
        System.out.println("Producto de Limpieza añdadido correcatamente");

    }

    public static void mostrarLimpieza() {
        System.out.println("*** Productos de Limpieza ***");
        for (int i = 0; i < limpiezas.size(); i++) {
            System.out.println("["+i+"]" + "- Nombre: " + limpiezas.get(i).getNombre() + ", Precio: " + limpiezas.get(i).getPrecio() + ", Fecha de importación: " + LocalDate.now() + ", Numero Serie: " + limpiezas.get(i).getNumeroSerie() + ", Stock Disponible: " + limpiezas.get(i).getStock()+", Aroma: "+limpiezas.get(i).getAroma());
        }
        System.out.println();
    }
    //Belleza
    public static void addBelleza(Belleza belleza){
        bellezas.add(belleza);
        productos.add(belleza);
        System.out.println("Producto de Belleza añdadido correcatamente");
    }

    public static void mostrarBelleza() {
        System.out.println("*** Productos de Belleza ***");
        for (int i = 0; i < bellezas.size(); i++) {
            System.out.println("["+i+"]"+ "- Nombre: " + bellezas.get(i).getNombre() + ", Precio: " + bellezas.get(i).getPrecio() + ", Fecha de importación: " + LocalDate.now() + ", Numero Serie: " + bellezas.get(i).getNumeroSerie() + ", Stock Disponible: " + bellezas.get(i).getStock()+", Tono de Piel: "+bellezas.get(i).getTonoPiel());
        }
        System.out.println();
    }
    //Alimento
    public static void addAlimeto(Alimento alimento){
        alimentos.add(alimento);
        productos.add(alimento);
        System.out.println("Producto de Alimento añdadido correcatamente");
    }
    public static void mostrarAlimento() {
        System.out.println("*** Productos de Alimentos ***");
        for (int i = 0; i < alimentos.size(); i++) {
            System.out.println("["+i+"]"+ "- Nombre: " + alimentos.get(i).getNombre() + ", Precio: " + alimentos.get(i).getPrecio() + ", Fecha de importación: " + LocalDate.now() + ", Numero Serie: " + alimentos.get(i).getNumeroSerie() + ", Stock Disponible: " + alimentos.get(i).getStock()+", Fecha de Caducidad: "+alimentos.get(i).getFechaCaducidad());
        }
        System.out.println();
    }


    public static void mostrarTodosLosProductosPorCategoria() {
        mostrarAlimento();
        mostrarBelleza();
        mostrarElectrodomestico();
        mostrarLimpieza();
    }
    public static void mostrarTodosLosProductos() {
        for (Producto producto : productos) {
            if (!producto.isComprado() || producto.getStock()>0) {
                System.out.println( "["+productos.indexOf(producto)+"]" + producto.getNombre() + "\n" + "Precio: " + producto.getPrecio() + ", Fecha de Importacion: " + producto.getFechaImportacion() + "\n" + "Cantidad en stock: " + producto.getStock() + ", Esta comprado? " + producto.isComprado() + ", Numero de serie: " + producto.getNumeroSerie() + "\n");
            }
        }
    }
    public static void removerProducto(int indexRemover){
       Producto producto=productos.get(indexRemover);
       if (!producto.isComprado()){
           productos.remove(indexRemover);
           System.out.println("Producto Removido Exitosamente");
           if (alimentos.contains(producto)){
               alimentos.remove(producto);
           } else if (bellezas.contains(producto)) {
               bellezas.remove(producto);
           } else if (electrodomesticos.contains(producto)) {
               electrodomesticos.remove(producto);
           } else if (limpiezas.contains(producto)) {
               limpiezas.contains(producto);
           }
       }else if (producto.isComprado()){
           System.out.println("No se puede eliminar el producto, el producto esta asociado a compras de los clientes");
       }else{
           System.out.println("indice invalido");
       }

    }

//Cliente
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente agregado correctamente. ");
    }


    public static void removerCliente(int indexRemover){
        Cliente cliente=clientes.get(indexRemover);
        if (cliente.getCompras().isEmpty()){
            clientes.remove(indexRemover);
            System.out.println("Cliente Removido Exitosamente");
        }else{
            System.out.println("No se puede eliminar el cliente, el cliente tiene compras asociadas");
        }

    }
    public static void mostrarCliente(){
        System.out.println("*** Clientes ***");
        for (int i = 0; i <clientes.size() ; i++) {
            System.out.println("["+i+"]- "+clientes.get(i).getName()+" "+clientes.get(i).getApellido());
        }
    }

    public static void numeroClientes(){
        System.out.println("El numero de clientes es: "+clientes.size());
    }
    public static void numeroProductos(){
        System.out.println("El numero de productos es: "+productos.size());
    }


    public static boolean checkPaswword(String contra){
        return contra.equals(password);
    }

    //comprar productos
    public static void comprarProducto(int indexCliente,int indexProducto ){
        Producto producto= productos.get(indexProducto);

        if  (producto.isComprado() && producto.getStock()<1){
            System.out.println("Producto no disponible");
        }
        else if (producto.getStock()>0){

            producto.setComprado();
            producto.removerStock(1);
            Cliente cliente=clientes.get(indexCliente);
            LocalDate fecha = LocalDate.now();
            cliente.anadirProducto(producto,fecha);
            System.out.println("!Producto comprado¡");
        }
        else{
            System.out.println("No hay stock disponible");
        }

    }
    public static void productosComprados(){
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente=clientes.get(i);
            System.out.println("Compras realizadas por: " + cliente.getName()+" "+cliente.getApellido());
            cliente.mostrarCompras();
            System.out.println();
        }
    }

}
