package Biblioteca;

import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;

import java.util.ArrayList;

public class Biblioteca {

    //sirve para ignorar el warning de la linea de abajo
   // @SuppressWarnings("RawTypes")
   // private ArrayList usuarios = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Gerente> gerentes=new ArrayList<>();
    private ArrayList<Trabajador> trabajadors=new ArrayList<>();

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (Usuario usuarioActual : usuarios) {
            if (usuarioActual.getNombreUsuario().equals(nombreUsuario) && usuarioActual.getContrasena().equals(contrasena)) {
                return usuarioActual;
            }
        }
        return null;
    }
    public  void agregarCLiente(Cliente cliente){
        clientes.add(cliente);
        usuarios.add(cliente);
    }
    public  void agregarGerente(Gerente gerente){
        gerentes.add(gerente);
        usuarios.add(gerente);
    }
    public  void agregarTrabajador(Trabajador trabajador){
        trabajadors.add(trabajador);
        usuarios.add(trabajador);
    }



}
