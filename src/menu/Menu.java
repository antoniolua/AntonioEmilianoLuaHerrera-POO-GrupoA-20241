package menu;

import productos.Alimento;
import productos.Belleza;
import productos.Electrodomestico;
import productos.Limpieza;
import tienda.Tienda;
import usuarios.Cliente;

import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public static Tienda tienda = new Tienda();

    public  static void MenuPrincipal(){
        boolean banSalir = true;
        System.out.println("*** BIENVENIDO A MI CHILCHOTA ***");
        do {
            System.out.println();
            System.out.println("SELECCIONA UNA OPCION: ");
            System.out.println("1. Registrar un producto nuevo. ");
            System.out.println("2. Registrar a un cliente nuevo. ");
            System.out.println("3. Comprar un producto.");
            System.out.println("4. Ver todos los productos comprados. ");
            System.out.println("5. Ver todas las compras de un cliente en especifico. ");
            System.out.println("6. Eliminar un producto.");
            System.out.println("7. Eliminar a un cliente. ");
            System.out.println("8. Ver el numero de clientes. ");
            System.out.println("9. Ver el numero de productos. ");
            System.out.println("10. Mostrar a todos los productos: ");
            System.out.println("11. SALIR");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    registrarCliente();
                    break;
                case 3:
                   comprarProducto();
                    break;
                case 4:
                    Tienda.productosComprados();
                    break;
                case 5:
                   comprasUsuarioEspecifico();
                    break;
                case 6:
                    eliminarProducto();
                    break;
                case 7:
                    eliminarCliente();
                    break;
                case 8:
                    Tienda.numeroClientes();
                    break;
                case 9:
                    Tienda.numeroProductos();
                    break;
                case 10:
                    Tienda.mostrarTodosLosProductosPorCategoria();
                    break;
                case 11:
                    System.out.println("Saliendo del sistema.");
                    banSalir = false;
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }

        } while (banSalir);
    }
    public static void inisiarSesion(){

        String password;
        int cont = 1;
        System.out.println("Bienvenido al sistema del mi chilchota, por favor ingresa la contraseña para poder acceder al menú, tienes 5 intentos");
        do {
            System.out.println("intento numero: " + cont);
            password = sc.nextLine();
            cont++;
            if (cont == 6) {
                System.out.println("A sobre pasado el  numero de intentos");
                return;
            }
        } while (!Tienda.checkPaswword(password));

        MenuPrincipal();
    }

    public static void registrarProducto() {
        sc.nextLine();
        int opc;
        System.out.println("Ingresa el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el precio del producto: ");
        float precio = sc.nextFloat();
        sc.nextLine();
        System.out.println("Ingresa la fecha de importacion  XX/XX/XXXX: ");
        String fechaImport = sc.nextLine();
        System.out.println("Ingresa el numero de serie: ");
        int numSerie = sc.nextInt();
        System.out.println("Ingresa el stock deseado del producto: ");
        int stock = sc.nextInt();
        sc.nextLine();
        do {
            System.out.println("Selecciona el tipo de producto a registrar: ");
            System.out.println("1. Electrodomesticos");
            System.out.println("2. Limpieza");
            System.out.println("3. Belleza");
            System.out.println("4. Alimentos");
            opc = sc.nextInt();
            sc.nextLine();
        } while (opc < 1 || opc > 4);

        switch(opc) {
            case 1:
                System.out.println("Ingresa la marca del electrodomestico: ");
                String marca = sc.nextLine();
                tienda.addElectrodomestico(new Electrodomestico(nombre,precio, fechaImport, numSerie, stock, marca));

                break;
            case 2:
                System.out.println("Ingresa el aroma del producto: ");
                String aroma = sc.nextLine();
                tienda.addLimpieza(new Limpieza(nombre, precio, fechaImport, numSerie, stock,aroma));

                break;
            case 3:
                System.out.println("Ingresa el tono de piel: ");
                String tonoPiel = sc.nextLine();
                tienda.addBelleza(new Belleza(nombre, precio, fechaImport, numSerie, stock, tonoPiel));
                break;
            case 4:
                System.out.println("Ingresa la fecha de caducidad: ");
                String fechaCaducidad = sc.nextLine();
                tienda.addAlimeto(new Alimento(nombre, precio, fechaImport, numSerie, stock, fechaCaducidad));
                break;
        }

    }
    public static void registrarCliente(){
        sc.nextLine();

        System.out.println("Ingresa el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el apellido del cliente:");
        String apellido = sc.nextLine();
        System.out.println("Ingresa la edad del cliente: ");
        int edad = sc.nextInt();
        sc.nextLine();
        tienda.addCliente(new Cliente(nombre,apellido,edad));
    }

    public static void comprarProducto(){
        Tienda.mostrarCliente();
        System.out.println("Selecciona el cliente con el que deseas comprar un producto: ");
        int indexCliente=sc.nextInt();
        System.out.println("*** Productos Disponibles ***");
        Tienda.mostrarTodosLosProductos();
        System.out.println("Ingresa el indice del producto que deseas comprar: ");
        int indexCompra = sc.nextInt();
        Tienda.comprarProducto(indexCliente,indexCompra);
    }
    public static void comprasUsuarioEspecifico(){
        Tienda.mostrarCliente();
        System.out.println("Digite el indice del Cliente: ");
        int indexCliente= sc.nextInt();
        Cliente cliente=Tienda.clientes.get(indexCliente);
        System.out.println("Compras de "+cliente.getName());
        cliente.mostrarCompras();
    }

    public static void eliminarProducto(){
        Tienda.mostrarTodosLosProductos();
        System.out.println("Digite el indice del producto a remover");
        int indexRemover=sc.nextInt();
        Tienda.removerProducto(indexRemover);
    }
    public static void eliminarCliente(){
        Tienda.mostrarCliente();
        System.out.println("Digite el indice del cliente a remover");
        int indexRemover=sc.nextInt();
        Tienda.removerCliente(indexRemover);
    }
}
