package Biblioteca;

import java.time.LocalDate;
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
        Biblioteca biblioteca=new Biblioteca();
        boolean datosCorrectos = false;
        biblioteca.agregarGerente(new Gerente("Juan","perez",Rol.GERENTE,LocalDate.now(),"112345","j","123",5, 333));
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
                UsuarioEnSesion.getInstancia().setUsuario(usuario);
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
                    registrarUsuario(Rol.ClIENTE);
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
                    registrarUsuario(Rol.ClIENTE);
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada");
                    System.out.println("*** REGISTRAR TRABAJADOR ***");
                    registrarUsuario(Rol.TRABAJADOR);
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


    public static void registrarUsuario(Rol usuario){
        sc.nextLine();
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese su apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (YYYY-MM-DD):");
        LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine());

        String telefono= biblioteca.obtenerNumeroTelefono();
        String nombreUsuario= biblioteca.obtenerNombreUsuario();

        System.out.println("Ingrese su contraseña: ");
        String contrasena = sc.nextLine();



        if (usuario==Rol.ClIENTE){
            biblioteca.agregarCLiente(new Cliente(nombre,apellido,Rol.ClIENTE,fechaNacimiento,telefono,nombreUsuario,contrasena));
        } else if (usuario==Rol.TRABAJADOR) {
            System.out.println("Ingrese su suelo");
            float sueldo= sc.nextFloat();
            System.out.println("Ingrese su rfc: ");
            String rfc=sc.nextLine();
            biblioteca.agregarTrabajador(new Trabajador(nombre,apellido,Rol.ClIENTE,fechaNacimiento,telefono,nombreUsuario,contrasena,sueldo,rfc));
        } else if (usuario==Rol.GERENTE) {
            System.out.println("Ingrese los años de lealtad: ");
            int anosLealtad=sc.nextInt();
            System.out.println("Ingrese su suelo");
            float sueldo= sc.nextFloat();
            biblioteca.agregarGerente(new Gerente(nombre,apellido,Rol.ClIENTE,fechaNacimiento,telefono,nombreUsuario,contrasena,anosLealtad,sueldo));
        }
    }


}
