package Biblioteca;

import Biblioteca.libros.Libro;
import Biblioteca.libros.LibroComedia;
import Biblioteca.libros.LibroTerror;
import Biblioteca.libros.constants.Genero;
import Biblioteca.libros.constants.SubGeneroTerror;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.serializers.UsuarioDeserializer;
import Usuarios.serializers.UsuarioSerializer;
import Usuarios.utils.Rol;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Biblioteca {

    //sirve para ignorar el warning de la linea de abajo
    // @SuppressWarnings("RawTypes")
    // private ArrayList usuarios = new ArrayList<>();
    // private ArrayList<Usuario> usuarios = new ArrayList<>();

    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();//es el rol es la llave, el arraylist es el valor que se le da a cada llave
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<>();

    public Biblioteca(boolean inicializarDatos) {
        if (inicializarDatos) {
            inicializarDatos();
        }
    }

    private void inicializarDatos() {
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.ClIENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());

        libros.put(Genero.TERROR, new ArrayList<Libro>());
        libros.put(Genero.ACCION, new ArrayList<Libro>());
        libros.put(Genero.COMEDIA, new ArrayList<Libro>());

        //GERENTES
        Gerente gerente = new Gerente("Juan", "Rivera", Rol.GERENTE, LocalDate.of(1111, 11, 11), "4433566678", "j", "123", 22, 222);
        Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);

        Gerente gerente2 = new Gerente("Juan", "Rivera", Rol.GERENTE, LocalDate.of(1111, 11, 11), "4433566678", "a", "123", 22, 222);
        Biblioteca.usuarios.get(Rol.GERENTE).add(gerente2);

        //CLIENTE
        Biblioteca.usuarios.put(Rol.ClIENTE, new ArrayList<>());
        Cliente cliente = new Cliente("Juan", "Rivera", Rol.ClIENTE, LocalDate.of(1111, 11, 11), "4433566678", "Cliente1", "123");
        Biblioteca.usuarios.get(Rol.ClIENTE).add(cliente);

        //LIBRO TERROR
        Biblioteca.libros.put(Genero.TERROR, new ArrayList<>());
        LibroTerror libroTerror = new LibroTerror("el buuuuu", "Pepe Diaz", "el bazzz", LocalDate.of(1111, 11, 11), Genero.TERROR, 3000, 20, SubGeneroTerror.CRIMEN);
        Biblioteca.libros.get(Genero.TERROR).add(libroTerror);


        LibroTerror libroTerror2 = new LibroTerror("el malefica", "Pepe Diaz", "el bazzz", LocalDate.of(1111, 11, 11), Genero.TERROR, 3000, 20, SubGeneroTerror.PSICOLOGICO);
        Biblioteca.libros.get(Genero.TERROR).add(libroTerror2);

        //LIBRO COMEDIA
        Biblioteca.libros.put(Genero.COMEDIA, new ArrayList<>());
        LibroComedia LibroComedia = new LibroComedia("el principe p", " Diaz", "el dsdew", LocalDate.of(1111, 11, 11), Genero.COMEDIA, 3000, 20);
        Biblioteca.libros.get(Genero.COMEDIA).add(LibroComedia);

    }

    /**
     * Guardado de datos en JSON
     * <p>
     * Manda a llamar a la clase UsuarioSerializer para serializar los datos a JSON
     */
    public static void guardarEnJSON() {
        UsuarioSerializer.serializer();
    }

    /**
     * Lectura de datos en JSON
     * <p>
     * Manda a llamar a la clase UsuarioDeserializer para deserializar los datos del JSON
     */
    public static void leerJSON() {
        UsuarioDeserializer.deserialize();
    }


    public static Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (Map.Entry<Rol, ArrayList<Usuario>> entry : usuarios.entrySet()) {
            ArrayList<Usuario> listaUsuarios = entry.getValue();
            for (Usuario usuarioActual : listaUsuarios) {
                if (usuarioActual.getNombreUsuario().equals(nombreUsuario) && usuarioActual.getContrasena().equals(contrasena)) {
                    return usuarioActual;
                }
            }
        }
        return null;
    }





    //CLIENTES
    public static void registrarCliente() {
        Cliente.registrarCliente();
    }

    public static void mostrarClientes() {
        Cliente.mostrarClientes();
    }

    public static void eliminarUsuario(String nombreUsuario) {
        Usuario.eliminarUsuario(nombreUsuario);
    }

    //GERENTES
    public static void registrarGerente() {
        Gerente.registrarGerente();
    }

    public static void mostrarGerente() {
        Gerente.mostrarGerente();
    }

    //TRABAJADORES
    public static void registrarTrabajador() {
        Trabajador.registrarTrabajador();
    }

    public static void mostrarTrabajador() {
        Trabajador.mostrarTrabajador();
    }

    public static void motrarTodosLosUsuario() {
        Usuario.motrarTodosLosUsuario();
    }


}
