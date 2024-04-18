package Biblioteca;

import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

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
    public void mostrarClientes(){
        System.out.println("*** CLIENTES ***");
       for (Cliente cliente:clientes){
           System.out.println(cliente.toString());
       }
    }

    public  void agregarGerente(Gerente gerente){
        gerentes.add(gerente);
        usuarios.add(gerente);
    }
    public void mostrarGerente(){
        System.out.println("*** GERENTES ***");
        for (Gerente gerente:gerentes){
            System.out.println(gerente.toString());
        }
    }
    public  void agregarTrabajador(Trabajador trabajador){
        trabajadors.add(trabajador);
        usuarios.add(trabajador);
    }
    public void mostrarTrabajador(){
        System.out.println("*** TRABAJADOR ***");
        for (Trabajador trabajador:trabajadors){
            System.out.println(trabajador.toString());
        }
    }
    public void motrarTodosLosUsuario(){
        System.out.println("*** USUARIOS ***");
        for (Usuario usuario:usuarios){
            System.out.println(usuario.toString());
        }
    }

    public String obtenerNumeroTelefono() {
        Scanner scanner = new Scanner(System.in);
        boolean numeroExistente = true;
        String telefono = "";
        do {
            System.out.println("Ingresa el numero de telefono");
            telefono = scanner.nextLine();
            numeroExistente = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getNumeroTelefono().equals(telefono)) {
                    numeroExistente = true;
                }
            }
            if (numeroExistente) {
                System.out.println("El numero ya existe. Intenta de nuevo\n");
            }
        } while (numeroExistente);
        return telefono;
    }

    public String obtenerNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean nombreUsuarioExistente = true;
        String nombreUsuario = "";
        do {
            System.out.println("Ingresa el el nombre de usuario");
            nombreUsuario = scanner.nextLine();
            nombreUsuarioExistente = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    nombreUsuarioExistente = true;
                }
            }
            if (nombreUsuarioExistente) {
                System.out.println("El nombre de usuario ya existe. Intenta de nuevo\n");
            }
        } while (nombreUsuarioExistente);
        return nombreUsuario;
    }




}
