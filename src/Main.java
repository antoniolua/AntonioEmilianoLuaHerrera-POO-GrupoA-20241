import usuarios.Cliente;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class Main {
    public static void main(String[] args) {


        Cliente cliente = new Cliente("pepe", "lua");
        System.out.println(cliente.getFechaRegistro());

        System.out.println(cliente.toString());

    }
}