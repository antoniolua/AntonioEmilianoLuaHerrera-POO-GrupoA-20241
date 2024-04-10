package Biblioteca;

import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public  static  void ejecutarMenu(){
        //Cliente
        //ver sus rentas, su info, ver libros disponibles

        //Trabajador
        //registrar libros y registra usuarios (CRUD)

        //Gerente
        //Todo lo del trabajador mas el registro de las rentas
    }
    public void ejecutarMenuCliente(){
        boolean band =  true;
        do {
            System.out.println("*** MENU CLIENTE ***");
            System.out.println("1. Ver Rentas");
            System.out.println("2. Ver Info");
            System.out.println("3. Ver Libros Disponibles");
            System.out.println("4. Salir");

            System.out.println("Digite su opcion: ");
            int opc=sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Opción 1 seleccionada");
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada");
                    break;
                case 3:
                    System.out.println("Saliendo del programa..");
                    break;
                case 4:
                    System.out.println("Opción 4 seleccionada");
                    band = false;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

        }while (band);
    }
    public static void ejecutarMenuTrabajador(){
        boolean band =  true;
        do {
            System.out.println("*** MENU TRABAJADOR ***");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Actualizar la informacion del cliente");
            System.out.println("3. ELiminar Cliente");
            System.out.println("4. Registrar Libros");
            System.out.println("5. Actualizar la informacion del Libro");
            System.out.println("6. ELiminar Libro");
            System.out.println("7. Salir del Programa");

            System.out.println("Digite su opcion: ");
            int opc=sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Opción 1 seleccionada");
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada");
                    break;
                case 3:
                    System.out.println("Opción 3 seleccionada.");
                    break;
                case 4:
                    System.out.println("Opción 4 seleccionada");
                    break;
                case 5:
                    System.out.println("Opción 5 seleccionada");
                    break;
                case 6:
                    System.out.println("Opción 6 seleccionada");
                    break;
                case 7:
                    System.out.println("Saliendo del programa..");
                    band = false;
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }

        }while (band);

    }
    public static void ejecutarMenuGerente(){
        boolean band =  true;
        do {
            System.out.println("*** MENU GERENTE ***");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Actualizar la informacion del cliente");
            System.out.println("3. ELiminar Cliente");
            System.out.println("4. Registrar Libros");
            System.out.println("5. Actualizar la informacion del Libro");
            System.out.println("6. ELiminar Libro");
            System.out.println("7. Registar Renta");
            System.out.println("8. Salir del Programa");

            System.out.println("Digite su opcion: ");
            int opc=sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Opción 1 seleccionada");
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada");
                    break;
                case 3:
                    System.out.println("Opción 3 seleccionada.");
                    break;
                case 4:
                    System.out.println("Opción 4 seleccionada");
                    break;
                case 5:
                    System.out.println("Opción 5 seleccionada");
                    break;
                case 6:
                    System.out.println("Opción 6 seleccionada");
                    break;
                case 7:
                    System.out.println("Opción 7 seleccionada");
                    break;
                case 8:
                    System.out.println("Saliendo del programa..");
                    band = false;
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }

        }while (band);
    }
}
