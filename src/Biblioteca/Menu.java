package Biblioteca;

import java.time.LocalDate;
import java.util.*;

import Biblioteca.libros.Libro;
import Biblioteca.libros.LibroTerror;
import Biblioteca.libros.constants.Genero;
import Biblioteca.libros.constants.SubGeneroTerror;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import utils.UsuarioEnSesion;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;


public class Menu {
    public static Scanner sc = new Scanner(System.in);
    public static boolean BandCerrarSesion = true;
    public static Biblioteca biblioteca = new Biblioteca();

    //Iniciar Sesion
    public static void iniciarSesion() {

        AgregarUsuarios();
        int cont = 0;
        boolean datosCorrectos = false;

        System.out.println("Bienvenido al sistema de la biblioteca");
        System.out.println("Cuentas con 5 oportunidades");
        System.out.println();
        do {
            System.out.println("Oporunidad " + (cont + 1));
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
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido," + usuario.getNombre());
                System.out.println();
                Menu.seleccionarMenu(usuario);
            } else if (cont < 5) {
                System.out.println("Usuario o contraseña incorrectos. Por favor, intenta de nuevo.");
                System.out.println();
            } else {
                System.out.println("Terminando el programa...");
            }


        } while (!datosCorrectos && cont < 5);
    }


    private static void seleccionarMenu(Usuario usuario) {
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case ClIENTE -> ejecutarMenuCliente();
            case TRABAJADOR -> ejecutarMenuTrabajador();
            case GERENTE -> ejecutarMenuGerente();
        }
    }

    public static void ejecutarMenuCliente() {
        int opc = 0;
        do {
            System.out.println("*** MENU CLIENTE ***");
            System.out.println("1. Ver Rentas");
            System.out.println("2. Ver Info");
            System.out.println("3. Ver Libros Disponibles");
            System.out.println("4. Cerrar Sesion");

            System.out.println("Digite su opcion: ");
            opc = sc.nextInt();

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
        } while (opc != 4);
    }

    public static void ejecutarMenuTrabajador() {
        int opc = 0;
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
            opc = sc.nextInt();

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

        } while (BandCerrarSesion);

    }

    public static void ejecutarMenuGerente() {
        String opcion;

        do {
            System.out.println("*** MENU GERENTE ***");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Trabajadores");
            System.out.println("3. Gestionar Libros");
            System.out.println("4. Cerrar Sesion");
            System.out.print("Por favor, seleccione una opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    miniMenuCliente();
                    break;
                case "2":
                    miniMenuTrabajador();
                    break;
                case "3":
                    miniMenuLibros();
                    break;
                case "4":
                    System.out.println("Saliendo del programa..:");
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (!opcion.equals("4"));

        sc.close();
    }


    public static void miniMenuCliente() {
        String opcion;
        do {
            System.out.println("*** MENU CLIENTES ***");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Actualizar la información de un Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Ver todos los clientes");
            System.out.println("5. Regresar al menú principal");
            System.out.print("Por favor, seleccione una opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ha seleccionado la opción 1: Registrar Cliente");
                    Cliente.registrarCliente();
                    break;
                case "2":
                    System.out.println("Ha seleccionado la opción 2: Actualizar la información de un Cliente");
                    Cliente.actualizarDatosComunes();
                    break;
                case "3":
                    System.out.println("Ha seleccionado la opción 3: Eliminar Cliente");
                    // Agrega aquí la lógica para eliminar un cliente
                    break;
                case "4":
                    System.out.println("Ha seleccionado la opción 4: Ver todos los clientes");
                    Cliente.mostrarClientes();
                    break;
                case "5":
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (!opcion.equals("5"));
    }

    private static void miniMenuTrabajador() {
        String opcion;
        do {
            System.out.println("*** MENU TRABAJADORES ***");
            System.out.println("1. Registrar Trabajador");
            System.out.println("2. Actualizar la información de un trabajador");
            System.out.println("3. Eliminar Trabajador");
            System.out.println("4. Ver todos los trabajadores");
            System.out.println("5. Regresar al menú principal");
            System.out.print("Por favor, seleccione una opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ha seleccionado la opción 1: Registrar Trabajador");
                    Trabajador.registrarTrabajador();
                    break;
                case "2":
                    System.out.println("Ha seleccionado la opción 2: Actualizar la información de un trabajador");
                    Trabajador.actualizarDatosComunes();
                    break;
                case "3":
                    System.out.println("Ha seleccionado la opción 3: Eliminar Trabajador");
                    // Agrega aquí la lógica para eliminar un trabajador
                    break;
                case "4":
                    System.out.println("Ha seleccionado la opción 4: Ver todos los trabajadores");
                    Trabajador.mostrarTrabajador();
                    break;
                case "5":
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (!opcion.equals("5"));
    }

    public static void miniMenuLibros() {
        String opcion;

        do {
            System.out.println("*** MENU LIBROS ***");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Actualizar la información de un libro");
            System.out.println("3. Filtrar libro");
            System.out.println("4. Registrar Renta");
            System.out.println("5. Eliminar Libro");
            System.out.println("6. Salir");
            System.out.print("Por favor, seleccione una opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ha seleccionado la opción 1: Registrar Libro");
                    Libro.registrarLibroCategoria();
                    break;
                case "2":
                    System.out.println("Ha seleccionado la opción 2: Actualizar la información de un libro");
                    // opcion de actulizar informacion del libro
                    break;
                case "3":
                    System.out.println("Ha seleccionado la opción 3: Filtrar libro");

                    // Submenú para la opción 3
                    String subOpcion;
                    do {
                        System.out.println("1. Filtrar todos los libros");
                        System.out.println("2. Filtrar libros por categoría");
                        System.out.println("3. Regresar al menú anterior");
                        System.out.print("Por favor, seleccione una opción: ");
                        subOpcion = sc.nextLine();

                        switch (subOpcion) {
                            case "1":
                                System.out.println("Filtrando todos los libros...");
                                Libro.ListadoGeneral();
                                break;
                            case "2":
                                System.out.println("Filtrando libros por categoría...");
                                Libro.ListadoGenero();
                                break;
                            case "3":
                                System.out.println("Regresando al menú anterior...");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        }

                    } while (!subOpcion.equals("3"));

                    break;
                case "4":
                    System.out.println("Ha seleccionado la opción 4: Registrar Renta");
                    //opcion de regitrar una venta
                    break;
                case "5":
                    System.out.println("Ha seleccionado la opción 5: Eliminar Libro");
                    Libro.eliminacionPorCategoria();
                    break;
                case "6":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
            sc.nextLine();
        } while (!opcion.equals("6"));

        sc.close();

    }


    private void registrarLibrosMenu() {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        boolean esDatoValido = false;
        do {
            System.out.println("\nRegistrar un Libro");
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Terror");
            System.out.println("2. Comedia");
            System.out.println("3. Accion");
            System.out.println("4. Regresar al menu principal");

            while (!esDatoValido) {
                try {
                    opc = sc.nextInt();
                    if (opc < 1 || opc > 4) {
                        throw new InputMismatchException();
                    }
                    esDatoValido = true;
                } catch (InputMismatchException error) {
                    System.out.println("Opcion invalida. Intenta de nuevo");
                } finally {
                    sc.nextLine();
                }
            }
            esDatoValido = false;

            switch (opc) {
                case 1:
                    System.out.println("Registar libro de terror");
                    break;
                case 2:
                    System.out.println("Resgistrar libro de comedia");
                    break;
                case 3:
                    System.out.println("Resgistrar libro de accion");
                    break;
                case 4:
                    System.out.println("Regresar al menu principal...");
                    ejecutarMenuTrabajador();
                    break;
            }


        } while (opc != 4);
    }

    public static void AgregarUsuarios() {


        Biblioteca.usuarios.put(Rol.GERENTE, new ArrayList<>());
        Gerente gerente = new Gerente("Juan", "Rivera", Rol.GERENTE, LocalDate.of(1111, 11, 11), "4433566678", "j", "123", 22, 222);
        Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);

        Gerente gerente2 = new Gerente("Juan", "Rivera", Rol.GERENTE, LocalDate.of(1111, 11, 11), "4433566678", "a", "123", 22, 222);
        Biblioteca.usuarios.get(Rol.GERENTE).add(gerente2);

        Biblioteca.libros.put(Genero.TERROR, new ArrayList<>());
        LibroTerror libroTerror = new LibroTerror("el buuuuu", "Pepe Diaz", "el bazzz", LocalDate.of(1111, 11, 11), Genero.TERROR, 3000, 20, SubGeneroTerror.CRIMEN);
        Biblioteca.libros.get(Genero.TERROR).add(libroTerror);


        LibroTerror libroTerror2 = new LibroTerror("el malefica", "Pepe Diaz", "el bazzz", LocalDate.of(1111, 11, 11), Genero.TERROR, 3000, 20, SubGeneroTerror.PSICOLOGICO);
        Biblioteca.libros.get(Genero.TERROR).add(libroTerror2);
    }

}
