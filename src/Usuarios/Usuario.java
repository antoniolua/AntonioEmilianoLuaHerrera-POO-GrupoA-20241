package Usuarios;

import Biblioteca.Biblioteca;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Usuario {
    private static int CANTIDAD_USUARIO = 0;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private String fechaNacimiento;
    private String contrasena;
    private String nombreUsuario;
    private String numeroTelefono;

    public Usuario(String nombre, String apellido, Rol rol,LocalDate fechaNacimiento,String numeroTelefono,String nombreUsuario,String contrasena) {
        this.id = CANTIDAD_USUARIO;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento.toString();
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.numeroTelefono=numeroTelefono;
        CANTIDAD_USUARIO++;
    }

    public static void setCantidadUsuario(int cantidadUsuario) {
        CANTIDAD_USUARIO = cantidadUsuario;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
            return String.format("ID: %d, Nombre completo: %s , Apellido: %s, Numero de telefono: %s, Nombre de Usuario: %s, rol: %s", id, nombre, apellido, numeroTelefono, nombreUsuario, rol);
    }


    public static int getCantidadUsuario() {
        return CANTIDAD_USUARIO;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public static void motrarTodosLosUsuario(){
        System.out.println("*** USUARIOS ***");
        for (ArrayList<Usuario> listaUsuario : Biblioteca.usuarios.values()){
            for (Usuario usuario : listaUsuario){
                System.out.println( usuario.toString());
            }
        }
    }
    public static void eliminarUsuario(String nombreUsuario) {
        boolean usuarioEncontrado = false;

        for (ArrayList<Usuario> listaUsuarios : Biblioteca.usuarios.values()) {
            Iterator<Usuario> iterador = listaUsuarios.iterator();

            while (iterador.hasNext()) {
                Usuario usuario = iterador.next();

                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    iterador.remove();
                    usuarioEncontrado = true;
                    System.out.println("Usuario '" + nombreUsuario + "' eliminado correctamente.");
                    break;
                }
            }

            if (usuarioEncontrado) {
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.println("Usuario '" + nombreUsuario + "' no fue encontrado.");
        }
    }
    public static void actualizarDatosComunes(){
        Scanner sc = new Scanner(System.in);
        motrarTodosLosUsuario();
        System.out.println("A que usuario desea actulizar sus datos: ");
        String usuarioActualizar = sc.nextLine();
        Usuario usuarioEncontrado = null;
        for (ArrayList<Usuario> listaUsuario : Biblioteca.usuarios.values()) {
            for (Usuario usuario : listaUsuario) {
                if (usuario.getNombreUsuario().equals(usuarioActualizar)) {
                    usuarioEncontrado = usuario;
                    break;
                }
            }
            if (usuarioEncontrado != null) {
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Usuario '" + usuarioActualizar + "' no fue encontrado.");
            return;
        }


        System.out.println("***Opciones a actualizar***");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Numero de telefono\n");
        System.out.println("Digite su opcion");
        int opc = sc.nextInt();
        sc.nextLine();
        switch (opc) {
            case 1:
                System.out.println("Digite el nuevo nombre:");
                String nuevoNombre = sc.nextLine();
                usuarioEncontrado.setNombre(nuevoNombre);
                break;
            case 2:
                System.out.println("Digite el nuevo apellido:");
                String nuevoApellido = sc.nextLine();
                usuarioEncontrado.setApellido(nuevoApellido);
                break;
            case 3:
                System.out.println("Digite el nuevo número de teléfono:");
                String nuevoTelefono = sc.nextLine();
                usuarioEncontrado.setNumeroTelefono(nuevoTelefono);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
        if (usuarioEncontrado.getRol() == Rol.TRABAJADOR){
            System.out.println("Desea cambiarle el sueldo a "+usuarioEncontrado.getNombreUsuario());
            String aux= sc.nextLine();
            if (aux.equalsIgnoreCase("si")){
                System.out.println("Ingrese el nuevo sueldo de "+ usuarioEncontrado.getNombreUsuario());
                float nuevoSueldo = sc.nextFloat();
                Trabajador trabajador = (Trabajador) usuarioEncontrado;
                trabajador.setSuelo(nuevoSueldo);
            }
        }
    }


}
