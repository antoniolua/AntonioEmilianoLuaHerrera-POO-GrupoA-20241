package Biblioteca;

import java.time.LocalDate;
import java.util.Scanner;

import Usuarios.Cliente;
import Usuarios.Usuario;
import Usuarios.utils.Rol;


public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public static boolean BandCerrarSesion=true;


    //Iniciar Sesion
    public static void iniciarSesion() {
        int cont=0;
        Biblioteca biblioteca=new Biblioteca();
        boolean datosCorrectos = false;
        biblioteca.agregarCLiente(new Cliente("Juan","perez",Rol.ClIENTE,LocalDate.now(),"123","j",LocalDate.now()));
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
            if (usuario != null) {
                datosCorrectos = true;
                System.out.println(STR."Inicio de sesión exitoso. ¡Bienvenido, \{usuario.getNombre()}!");
                System.out.println();
                Menu.seleccionarMenu(usuario);
            } else {
                cont++;
                if (cont<5) {
                    System.out.println("Usuario o contraseña incorrectos. Por favor, intenta de nuevo.");
                    System.out.println();
                }else{
                    System.out.println("Terminando el programa...");
                }
            }

        } while (!datosCorrectos && cont<5);
    }
    //Cerrar sesion
    public static void cerrarSesion(){
        BandCerrarSesion=false;
        System.out.println();
        iniciarSesion();
    }

    private static void seleccionarMenu(Usuario usuario){
        switch (usuario.getRol()){
            case ClIENTE -> ejecutarMenuCliente();
            case TRABAJADOR -> ejecutarMenuTrabajador();
            case GERENTE -> ejecutarMenuGerente();
        }
    }

    public static void ejecutarMenuCliente(){
        do {
            System.out.println("*** MENU CLIENTE ***");
            System.out.println("1. Ver Rentas");
            System.out.println("2. Ver Info");
            System.out.println("3. Ver Libros Disponibles");
            System.out.println("4. Cerrar Sesion");

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
                    System.out.println("Opción 3 seleccionada");
                    break;
                case 4:
                    System.out.println("Saliendo del programa..");
                   cerrarSesion();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

        }while (BandCerrarSesion);
    }
    public static void ejecutarMenuTrabajador(){
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
                   cerrarSesion();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

        }while (BandCerrarSesion);

    }
    public static void ejecutarMenuGerente(){
        do {
            System.out.println("*** MENU GERENTE ***");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Actualizar la informacion del cliente");
            System.out.println("3. ELiminar Cliente");
            System.out.println("4. Registrar Libros");
            System.out.println("5. Actualizar la informacion del Libro");
            System.out.println("6. ELiminar Libro");
            System.out.println("7. Registar Renta");
            System.out.println("8. Cerrar Sesion");

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
                    cerrarSesion();
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }

        }while (BandCerrarSesion);
    }
}
