package Usuarios;


import Banco.Banco;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursal;
import Utils.UsuarioEnSesion;

import java.time.LocalDate;
import java.util.*;

import static Banco.Banco.usuarios;
import static Utils.Utils.obtenerDatosComun;

public class Inversionista extends Usuario{
    public static Scanner sc = new Scanner(System.in);
    public static  ArrayList<RegistroFondos> listaRegistro =new ArrayList<>();

    public Inversionista(String nombre, String apellido, LocalDate fechaNacimiento, String ciudad, String estado, String rfc, String curp, String direccion, String contrasena, Sucursal sucursal, String usuario) {
        super(nombre, apellido, fechaNacimiento, ciudad, estado, rfc, curp, direccion, contrasena, Rol.Inversionista, sucursal, usuario);
    }

    public static void registrarInversionista() {
        System.out.println("Has seleccionado la opcion de registrar a un inversionista. ");
        ArrayList<String> datosComun = obtenerDatosComun(Rol.Inversionista);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        LocalDate fechaNacimiento = LocalDate.parse(datosComun.get(2));
        String ciudad = datosComun.get(3);
        String estado = datosComun.get(4);
        String rfc = datosComun.get(5);
        String curp = datosComun.get(6);
        String direccion = datosComun.get(7);
        String contrasena = datosComun.get(8);
        Sucursal sucursal = UsuarioEnSesion.getUsuarioActual().getSucursal();

        Inversionista inversionista = new Inversionista(nombre, apellido, fechaNacimiento, ciudad, estado, rfc, curp, direccion, contrasena, sucursal, datosComun.get(9));
        if (!usuarios.containsKey(sucursal)) {
            usuarios.put(sucursal, new HashMap<>());
        }
        if (!usuarios.get(sucursal).containsKey(Rol.Inversionista)) {
            usuarios.get(sucursal).put(Rol.Inversionista, new ArrayList<>());
        }

        usuarios.get(sucursal).get(Rol.Inversionista).add(inversionista);
    }

    public static void mostrarAllInversionistas() {
        ArrayList<Usuario> usuarios = Banco.usuarios.get(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal()).get(Rol.Inversionista);
        String sucursal = UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal().name();
        if (usuarios.isEmpty()) {
            System.out.println("No hay inversionistas en la sucursal " + sucursal);
        }
        else {
            System.out.println("Inversionistas en la sucursal " + sucursal + ":");
            for (Usuario usuario : usuarios) {
                Inversionista inversionista = (Inversionista) usuario;
                System.out.printf("Nombre: %s %s\n" +
                                "Fecha de nacimiento: %s Ciudad y estado: %s, %s\n" +
                                "RFC: %s CURP: %s Direccion: %s\n", inversionista.getNombre(), inversionista.getApellido(),
                        inversionista.getFechaNacimiento().toString(), inversionista.getCiudad(), inversionista.getEstado(),
                        inversionista.getRfc(), inversionista.getCurp(), inversionista.getDireccion());
                // Aquí puedes agregar más detalles si deseas mostrarlos
            }
        }
    }


  public static void anadirFondos(){

      String usuario = UsuarioEnSesion.getUsuarioActual().getNombre();
      System.out.println("Ingrese los fondos que desea proveer al banco");
      float fondos=sc.nextFloat();
      String fondosString=String.valueOf(fondos);
      if (fondos<=0){
          System.out.println("La cantidad a invertir debe ser mayor que cero.");
          return;
      }else {
          Banco banco=new Banco();
          float fondosActuales= banco.getFondos();
          float FondoNuevo = fondosActuales+fondos;
          banco.setFondos(FondoNuevo);
          System.out.println("Se ha añadido "+fondos+" a la sucursal "+UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
      }
      String fondosStr = String.valueOf(fondos);
      LocalDate fechaHoy = LocalDate.now();
      RegistroFondos nuevoRegistro=new RegistroFondos(usuario,fondosStr,fechaHoy);
      listaRegistro.add(nuevoRegistro);


  }

    public static class RegistroFondos {
        private String nombre;
        private String fondos;
        private LocalDate fecha;

        public RegistroFondos(String nombre, String fondos, LocalDate fecha) {
            this.nombre = nombre;
            this.fondos = fondos;
            this.fecha = fecha;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public String getFondos() {
            return fondos;
        }

        public String getNombre() {
            return nombre;
        }
    }
    public static void mostrarTodosLosRegistros() {
        if (listaRegistro.isEmpty()) {
            System.out.println("No hay registros para mostrar.");
            return;
        }

        System.out.println("Registros de fondos:");

        // Iterar sobre todos los registros y mostrarlos
        for (RegistroFondos registro : listaRegistro) {
            System.out.println("Nombre del Inversionista: "+registro.getNombre()+", Fondos: " + registro.getFondos() + ", Fecha: " + registro.getFecha());
        }

    }
    public static void modificarDatos(){
        System.out.println("***Inversionitas disponibles***");
        mostrarAllInversionistas();
        System.out.println("Ingrese el nombre de usuario del inversionista que desea actualizar:");
        String nombreUsuario = sc.nextLine();
        Inversionista inversionistaEncontrado=null;

        for (Map.Entry<Sucursal, HashMap<Rol, ArrayList<Usuario>>> sucursalEntry : usuarios.entrySet()){
            HashMap<Rol, ArrayList<Usuario>> rolesPorSucursal = sucursalEntry.getValue();
            if (rolesPorSucursal.containsKey(Rol.Inversionista)){
                ArrayList<Usuario> inversionistas = rolesPorSucursal.get(Rol.Inversionista);
                for (Usuario usuario:inversionistas){
                    if (usuario instanceof Inversionista && usuario.getUsuario().equals(nombreUsuario))
                        inversionistaEncontrado = (Inversionista) usuario;
                    break;
                }
            }
            if (inversionistaEncontrado!=null){
                break;
            }
        }
        if (inversionistaEncontrado!=null){
            Usuario.actualizarInformacion(inversionistaEncontrado);
        } else {
            System.out.println("Inversionista no encontrado.");

        }


    }

    public static void eliminarInverionista(){
        System.out.println("Ingrese el nombre de usuario del inversionista que desea actualizar:");
        String usuarioElimlinar = sc.nextLine();
        boolean encontrado = false;


        for (Map.Entry<Sucursal, HashMap<Rol, ArrayList<Usuario>>> sucursalEntry : usuarios.entrySet()) {
            HashMap<Rol, ArrayList<Usuario>> rolesPorSucursal = sucursalEntry.getValue();

            if (rolesPorSucursal.containsKey(Rol.Inversionista)) {
                ArrayList<Usuario> inversionistas = rolesPorSucursal.get(Rol.Inversionista);

                Iterator<Usuario> iterador = inversionistas.iterator();

                while (iterador.hasNext()) {
                    Usuario usuario = iterador.next();
                    if (usuario instanceof Inversionista && usuario.getUsuario().equals(usuarioElimlinar)) {
                        iterador.remove(); // Elimina el inversionista de la lista
                        encontrado = true;
                        break;
                    }
                }

                if (encontrado) {
                    break; // Usuario encontado
                }
            }
        }

        if (encontrado) {
            System.out.println("Inversionista con nombre de usuario " + usuarioElimlinar + " ha sido eliminado.");
        } else {
            System.out.println("No se encontró un inversionista con nombre de usuario " + usuarioElimlinar + ".");
        }
    }



}


