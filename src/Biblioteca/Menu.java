package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import utils.UsuarioEnSesion;


public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public static boolean BandCerrarSesion=true;
    public static Biblioteca biblioteca=new Biblioteca();

    //Iniciar Sesion
    public static void iniciarSesion() {
        int cont=0;
        boolean datosCorrectos = false;

        System.out.println("Bienvenido al sistema de la biblioteca");
        System.out.println("Cuentas con 5 oportunidades");
        System.out.println();
        do {
            System.out.println("Oporunidad "+(cont+1));
            System.out.println("Inicia sesión para continuar");
            System.out.println("Ingresa tu usuario:");
            String usuarioActual = sc.nextLine();
            System.out.println("Ingresa tu contraseña:");
            String password = sc.nextLine();
            Usuario usuario = biblioteca.verificarInicioSesion(usuarioActual, password);
            cont++;
            if (usuario != null) {
                UsuarioEnSesion.getInstancia().setUsuario(usuario);
                datosCorrectos = true;
                System.out.println(STR."Inicio de sesión exitoso. ¡Bienvenido, \{usuario.getNombre()}!");
                System.out.println();
                Menu.seleccionarMenu(usuario);
            } else if (cont<5) {
                    System.out.println("Usuario o contraseña incorrectos. Por favor, intenta de nuevo.");
                    System.out.println();
                }else{
                    System.out.println("Terminando el programa...");
                }


        } while (!datosCorrectos && cont<5);
    }


    private static void seleccionarMenu(Usuario usuario){
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()){
            case ClIENTE -> ejecutarMenuCliente();
            case TRABAJADOR -> ejecutarMenuTrabajador();
            case GERENTE -> ejecutarMenuGerente();
        }
    }

    public static void ejecutarMenuCliente(){
        int opc=0;
        do {
            System.out.println("*** MENU CLIENTE ***");
            System.out.println("1. Ver Rentas");
            System.out.println("2. Ver Info");
            System.out.println("3. Ver Libros Disponibles");
            System.out.println("4. Cerrar Sesion");

            System.out.println("Digite su opcion: ");
             opc=sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Opción 1 seleccionada");
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada");
                    break;
                case 3:
                    System.out.println("Opción 3 seleccionada");
                    break;
                case 4:
                    System.out.println("Saliendo del programa..");
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    sc.nextLine();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            System.out.println();
        }while (opc!=4);
    }
    public static void ejecutarMenuTrabajador(){
        int opc=0;
        do {
            System.out.println("*** MENU TRABAJADOR ***");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Actualizar la informacion del cliente");
            System.out.println("3. ELiminar Cliente");
            System.out.println("4. Registrar Libros");
            System.out.println("5. Actualizar la informacion del Libro");
            System.out.println("6. ELiminar Libro");
            System.out.println("7. Cerrar Sesion");

            System.out.println("Digite su opcion: ");
            opc=sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Opción 1 seleccionada");
                    System.out.println("*** REGISTRAR CLIENTE ***");
                    biblioteca.registrarCliente();
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
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    sc.nextLine();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            System.out.println();

        }while (BandCerrarSesion);

    }
    public static void ejecutarMenuGerente(){
        int opc=0;
        do {
            System.out.println("*** MENU GERENTE ***");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registar Trabajador");
            System.out.println("3. Actualizar la informacion del cliente");
            System.out.println("4. ELiminar Cliente");
            System.out.println("5. Eliminar Trabajador");
            System.out.println("6. Registrar Libros");
            System.out.println("7. Actualizar la informacion del Libro");
            System.out.println("8. ELiminar Libro");
            System.out.println("9. Registar Renta");
            System.out.println("10. Cerrar Sesion");

            System.out.println("Digite su opcion: ");
             opc=sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Opción 1 seleccionada");
                    System.out.println("*** REGISTRAR CLIENTE ***");
                    biblioteca.registrarCliente();
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada");
                    System.out.println("*** REGISTRAR TRABAJADOR ***");
                    biblioteca.registrarTrabajador();
                    break;
                case 3:
                    System.out.println("Opción 3 seleccionada.");
                    break;
                case 4:
                    System.out.println("Opción 4 seleccionada");
                    System.out.println("Usuarios disponibles a eliminar: ");
                    biblioteca.mostrarClientes();
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
                    System.out.println("Opción 8 seleccionada");
                    break;
                case 9:
                    System.out.println("Opción 9 seleccionada");
                    biblioteca.motrarTodosLosUsuario();
                    break;
                case 10:
                    System.out.println("Saliendo del programa..");
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    sc.nextLine();
                    iniciarSesion();
                    break;
                    default:
                    System.out.println("Opción inválida");
                    break;
            }
            System.out.println();
        }while (opc!=10);
    }






}
