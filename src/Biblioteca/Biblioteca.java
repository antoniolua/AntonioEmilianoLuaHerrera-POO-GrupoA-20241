package Biblioteca;

import Biblioteca.libros.Libro;
import Biblioteca.libros.constants.Genero;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
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

    public static final HashMap <Rol,ArrayList<Usuario>> usuarios=new HashMap<>();//es el rol es la llave, el arraylist es el valor que se le da a cada llave
    public static final HashMap<Genero, ArrayList<Libro>> libros=new HashMap<>();


public static void inicializarHasmap(){
        usuarios.put(Rol.GERENTE, new ArrayList<>());
        usuarios.put(Rol.ClIENTE, new ArrayList<>());
        usuarios.put(Rol.TRABAJADOR, new ArrayList<>());

        libros.put(Genero.TERROR, new ArrayList<>());
        libros.put(Genero.ACCION, new ArrayList<>());
        libros.put(Genero.COMEDIA, new ArrayList<>());
}


    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
       for (Map.Entry<Rol,ArrayList<Usuario>> entry : usuarios.entrySet()) {
           ArrayList<Usuario> listaUsuarios = entry.getValue();
           for (Usuario usuarioActual : listaUsuarios) {
               if (usuarioActual.getNombreUsuario().equals(nombreUsuario) && usuarioActual.getContrasena().equals(contrasena)) {
                   return usuarioActual;
               }
           }
       }
       return null;
    }

    public static void jsonUsuarios(){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.json"));
            json.toJson(usuarios, writer);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void jsonLibros(){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("libros.json"));
            json.toJson(libros, writer);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    //CLIENTES
    public void registrarCliente() {
        Cliente.registrarCliente();
    }

    public void mostrarClientes(){
       Cliente.mostrarClientes();
    }
    public void eliminarUsuario(String nombreUsuario){
        Usuario.eliminarUsuario(nombreUsuario);
    }

    //GERENTES
    public void registrarGerente() {
       Gerente.registrarGerente();
    }
    public void mostrarGerente(){
        Gerente.mostrarGerente();
    }
    //TRABAJADORES
    public void registrarTrabajador() {
      Trabajador.registrarTrabajador();
    }
    public void mostrarTrabajador(){
        Trabajador.mostrarTrabajador();
    }

    public void motrarTodosLosUsuario(){
       Usuario.motrarTodosLosUsuario();
    }



}
