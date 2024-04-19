package Biblioteca;

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
    public static Scanner sc = new Scanner(System.in);

    HashMap<Rol,ArrayList<Usuario>> usuarios=new HashMap<>();//es el rol es la llave, el arraylist es el valor que se le da a cada llave
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
    public ArrayList<String> obtenerDatosComunes(Rol rol){

        ArrayList<String> datosComunes=new ArrayList<>();
        String rolActual = rol == Rol.ClIENTE ? "Cliente" : rol == Rol.TRABAJADOR ?
                "Trabajador" : "Gerente";
        System.out.printf("Registrar %s \n",rolActual);

        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese su apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (YYYY-MM-DD):");
        LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine());

        String telefono= obtenerNumeroTelefono();
        String nombreUsuario= obtenerNombreUsuario();

        System.out.println("Ingrese su contraseña: ");
        String contrasena = sc.nextLine();

        datosComunes.addAll(Arrays.asList(nombre, apellido,fechaNacimiento.toString(), telefono, nombreUsuario, contrasena));
        return datosComunes;
    }

    //CLIENTES
    public void registrarCliente() {
        ArrayList<String> datosComun = obtenerDatosComunes(Rol.ClIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        LocalDate fechaNacimiento = LocalDate.parse(datosComun.get(2));
        String telefono = datosComun.get(3);
        String nombreUsuario = datosComun.get(4);
        String contrasena = datosComun.get(5);

        Cliente cliente = new Cliente(nombre, apellido, Rol.ClIENTE, fechaNacimiento, telefono, nombreUsuario, contrasena);
        if (!usuarios.containsKey(Rol.ClIENTE)) {
            usuarios.put(Rol.ClIENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.ClIENTE).add(cliente);
        System.out.println("\nCliente Registrado\n");
    }

    public void mostrarClientes(){
        System.out.println("*** CLIENTES ***");
        if (usuarios.containsKey(Rol.ClIENTE)){
            for (Usuario clientes : usuarios.get(Rol.ClIENTE)){
                System.out.println(clientes.toString());
            }
        }else {
            System.out.println("No hay clientes registrados.");
        }

    }

    //GERENTES
    public void registrarGerente() {
        ArrayList<String> datosComun = obtenerDatosComunes(Rol.GERENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        LocalDate fechaNacimiento = LocalDate.parse(datosComun.get(2));
        String telefono = datosComun.get(3);
        String nombreUsuario = datosComun.get(4);
        String contrasena = datosComun.get(5);

        System.out.println("Ingrese los años de lealtad: ");
        int anosLealtad=sc.nextInt();
        System.out.println("Ingrese su suelo");
        float sueldo= sc.nextFloat();
        Gerente gerente = new Gerente(nombre,apellido,Rol.GERENTE,fechaNacimiento,telefono,nombreUsuario,contrasena,anosLealtad,sueldo);

        if (!usuarios.containsKey(Rol.GERENTE)) {
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("\nGerente Registrado\n");
    }
    public void mostrarGerente(){
        System.out.println("*** GERENTES ***");
        if (usuarios.containsKey(Rol.GERENTE)){
            for (Usuario gerentes : usuarios.get(Rol.GERENTE)){
                System.out.println(gerentes.toString());
            }
        }else {
            System.out.println("No hay gerentes registrados.");
        }

    }
    //TRABAJADORES
    public void registrarTrabajador() {
        ArrayList<String> datosComun = obtenerDatosComunes(Rol.TRABAJADOR);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        LocalDate fechaNacimiento = LocalDate.parse(datosComun.get(2));
        String telefono = datosComun.get(3);
        String nombreUsuario = datosComun.get(4);
        String contrasena = datosComun.get(5);

        System.out.println("Ingrese su suelo");
        float sueldo= sc.nextFloat();
        System.out.println("Ingrese su rfc: ");
        String rfc=sc.nextLine();
        Trabajador trabajador=new Trabajador(nombre,apellido,Rol.TRABAJADOR,fechaNacimiento,telefono,nombreUsuario,contrasena,sueldo,rfc);

        if (!usuarios.containsKey(Rol.TRABAJADOR)) {
            usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.TRABAJADOR).add(trabajador);
        System.out.println("\nCliente Registrado\n");
    }
    public void mostrarTrabajador(){
        System.out.println("*** TRABAJADORES ***");
       if (usuarios.containsKey(Rol.TRABAJADOR)){
           for (Usuario trabajador : usuarios.get(Rol.TRABAJADOR)){
               System.out.println(trabajador.toString());
           }
       }else{
           System.out.println("No hay trabajadores registrados.");
       }

    }

    public void motrarTodosLosUsuario(){
        System.out.println("*** USUARIOS ***");
        for (ArrayList<Usuario> listaUsuario : usuarios.values()){
            for (Usuario usuario : listaUsuario){
                System.out.println( usuario.toString());
            }
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
            for (ArrayList<Usuario> listaUsuarios : usuarios.values()){
                for (Usuario usuario : listaUsuarios){
                    if (usuario.getNumeroTelefono().equals(telefono)){
                        numeroExistente=true;
                    }
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
            for (ArrayList<Usuario> listaUsuarios : usuarios.values()){
                for (Usuario usuario : listaUsuarios){
                    if (usuario.getNombreUsuario().equals(nombreUsuario)){
                        nombreUsuarioExistente = true;
                    }
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("El nombre de usuario ya existe. Intenta de nuevo\n");
            }
        } while (nombreUsuarioExistente);
        return nombreUsuario;
    }





}
