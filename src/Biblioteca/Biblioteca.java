package Biblioteca;

import Biblioteca.libros.Libro;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.*;

public class Biblioteca {

    //sirve para ignorar el warning de la linea de abajo
   // @SuppressWarnings("RawTypes")
   // private ArrayList usuarios = new ArrayList<>();
   // private ArrayList<Usuario> usuarios = new ArrayList<>();

    public static final HashMap <Rol,ArrayList<Usuario>> usuarios=new HashMap<>();//es el rol es la llave, el arraylist es el valor que se le da a cada llave
    public static final HashMap<Gerente, ArrayList<Libro>> libros=new HashMap<>();
    public Biblioteca(){
        usuarios.put(Rol.GERENTE, new ArrayList<>());
        Gerente gerente = new Gerente("Juan", "Rivera", Rol.GERENTE, LocalDate.of(1111, 11, 11), "4433566678", "j", "123", 22, 222 );
        usuarios.get(Rol.GERENTE).add(gerente);
    }


    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
       for (ArrayList<Usuario> listaUsuarios : usuarios.values()){
           for (Usuario usuarioActual :listaUsuarios){
               if (usuarioActual.getNombreUsuario().equals(nombreUsuario) ){
                   if (usuarioActual.getContrasena().equals(contrasena)){
                       return  usuarioActual;
                   }
               }
           }
       }
        return null;
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
