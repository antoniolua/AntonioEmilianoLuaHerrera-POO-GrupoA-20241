package Usuarios.models;

import Biblioteca.libros.constants.Genero;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.utils.Rol;

import java.util.ArrayList;

public class UsuarioModel {


    /**
     * Esta clase representa el modelo o estructura que debe de tener el archivo JSON de usuarios
     * <p>
     * Es obligatorio que coincida exáctamente con la estructura del JSON ya que de lo contrario arrojara un error al momento de hacer el parseo
     */

    private ArrayList<Gerente> gerentes;
    private ArrayList<Cliente> clientes;
    private ArrayList<Trabajador> trabajadors;

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Trabajador> getTrabajadors() {
        return trabajadors;
    }
}
