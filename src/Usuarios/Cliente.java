package Usuarios;

import Banco.Banco;
import Usuarios.Tarjetas.Debito;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursal;
import Utils.UsuarioEnSesion;
import Usuarios.Tarjetas.Credito;

import java.time.LocalDate;
import java.util.*;

import static Banco.Banco.usuarios;
import static Utils.Utils.obtenerDatosComun;

public class Cliente extends Usuario{
    private final Debito tarjetaDebito;
    private final ArrayList<Credito> tarjetasCredito;
    private final ArrayList<SolicitudTarjeta> solicitudTarjetas;

    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento, String ciudad, String estado, String rfc, String curp, String direccion, String contrasena, Sucursal sucursal , String usuario) {
        super(nombre, apellido, fechaNacimiento, ciudad, estado, rfc, curp, direccion, contrasena, Rol.Cliente, sucursal , usuario);
        this.tarjetaDebito = new Debito(nombre, apellido, "Debito");
        tarjetasCredito = new ArrayList<>();
        solicitudTarjetas = new ArrayList();
    }

    public static void registrarCliente(){
        System.out.println("Has seleccionado la opcion de registrar a un cliente. ");
        ArrayList<String> datosComun = obtenerDatosComun(Rol.Cliente);

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

        Cliente cliente = new Cliente(nombre, apellido, fechaNacimiento, ciudad, estado, rfc, curp, direccion, contrasena, sucursal, datosComun.get(9));

        usuarios.get(sucursal).get(Rol.Cliente).add(cliente);
        System.out.println(cliente.getUsuario()+" "+cliente.getContrasena());
    }

    public static void mostrarAllClientes() {
        ArrayList<Usuario> usuarios = Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.Cliente);
        String sucursal = UsuarioEnSesion.getUsuarioActual().getSucursal().name();
        if (usuarios.isEmpty()) {
            System.out.println("No hay clientes en la sucursal " + sucursal);
        }
        else {
            System.out.println("Clientes en la sucursal " + sucursal + ":");
            for (Usuario usuario : usuarios) {
                Cliente cliente = (Cliente) usuario;
                System.out.printf("Nombre de usuario %s\n", cliente.getUsuario());
                System.out.printf("Nombre: %s %s\n" +
                        "Fecha de nacimiento: %s Ciudad y estado: %s, %s\n" +
                        "RFC: %s CURP: %s Direccion: %s\n", cliente.getNombre(),cliente.getApellido(), cliente.getFechaNacimiento().toString(),cliente.getCiudad(),cliente.getEstado(),cliente.getRfc(), cliente.getCurp(), cliente.getDireccion());
                cliente.mostrarTarjetas();
            }
        }
    }

    public void mostrarTarjetas(){
        System.out.println();
        this.tarjetaDebito.mostrarTarjeta();
        for (Credito credito : tarjetasCredito) {
            System.out.println();
            credito.mostrarTarjeta();
        }
    }

    public void solicitarTarjetaCredito() {
        if(!revisarSolicitud()){
            System.out.println("Tienes una solicitud pendiente.");
            return;
        }
        boolean bandS = true;
        boolean bandP = true;
        boolean bandO = true;
        Scanner leer = new Scanner(System.in);
        for (Credito credito : tarjetasCredito) {
            if (credito.getTipo().equals("Simplicity")) {
                bandS = false;
            }
            if (credito.getTipo().equals("Platino")) {
                bandP = false;
            }
            if (credito.getTipo().equals("Oro")) {
                bandO = false;
            }
        }
        if (!bandS && !bandP && !bandO) {
            System.out.println("Tienes todas las tarjetas, ya no puedes solicitar mas.");
            return;
        }
        if(tarjetaDebito.getSaldo() >= 200000 && bandO){
            System.out.printf("Tu saldo es de $%.2f, puedes solicitar la tarjeta oro.\n", tarjetaDebito.getSaldo());
            System.out.println("Deseas solicitarla Y/N: ");
            String opcion = leer.nextLine();
            if(opcion.toUpperCase().equals("Y")){
                new SolicitudTarjeta((Cliente)UsuarioEnSesion.getUsuarioActual(), "Oro");
                System.out.println("Tarjeta solicitada satisfactoriamente.");
            } else{
                System.out.println("Tarjeta no solicitada. ");
            }
        }
        else if(tarjetaDebito.getSaldo() >= 100000 && bandP){
            System.out.printf("Tu saldo es de $%.2f, puedes solicitar la tarjeta platino.\n", tarjetaDebito.getSaldo());
            System.out.println("Deseas solicitarla Y/N: ");
            String opcion = leer.nextLine();
            if(opcion.toUpperCase().equals("Y")){
                new SolicitudTarjeta((Cliente)UsuarioEnSesion.getUsuarioActual(), "Platino");
                System.out.println("Tarjeta solicitada satisfactoriamente.");
            } else {
                System.out.println("Tarjeta no solicitada. ");
            }
        }
        else if (tarjetaDebito.getSaldo() >= 50000 && bandS){
            System.out.printf("Tu saldo es de $%.2f, puedes solicitar la tarjeta simplicity.\n", tarjetaDebito.getSaldo());
            System.out.println("Deseas solicitarla Y/N: ");
            String opcion = leer.nextLine();
            if(opcion.toUpperCase().equals("Y")){
                new SolicitudTarjeta((Cliente)UsuarioEnSesion.getUsuarioActual(), "Simplicity");
                System.out.println("Tarjeta solicitada satisfactoriamente.");
            } else {
                System.out.println("Tarjeta no solicitada. ");
            }
        }
        else {
            System.out.println("Actualmente no puedes solicitar ninguna tarjeta de credito.");
        }
    }

    public void verSolicitudesTarjetaCreditoC() {
        if(!solicitudTarjetas.isEmpty()){
            System.out.println("** Solicitudes de tarjeta **");
            for (SolicitudTarjeta solicitud: solicitudTarjetas){
                System.out.println("Numero de solicitud: "+ solicitudTarjetas.indexOf(solicitud));
                solicitud.mostrarSolicitud();
                System.out.println();
            }
        }

    }

    public void verSolicitudesTarjetaCreditoE() {
        if(!solicitudTarjetas.isEmpty()){
            System.out.println("** Solicitudes de tarjeta **");
            for (SolicitudTarjeta solicitud: solicitudTarjetas){
                if(solicitud.getEstatus().equals("En proceso")){
                    System.out.println("Numero de solicitud: "+ solicitudTarjetas.indexOf(solicitud));
                    solicitud.mostrarSolicitud();
                    System.out.println();
                }
            }
        }

    }

    public boolean revisarSolicitud(){
        boolean bandS = true;
        boolean bandP = true;
        boolean bandO = true;
        for (SolicitudTarjeta solicitud: solicitudTarjetas) {
            if (solicitud.getEstatus().equals("En proceso")) {
                return false;
            }
        }
        return true;
    }

    public void imprimirIndiceTarjetaCredito(){
        for (Credito tarjeta : tarjetasCredito){
            System.out.println("[" + tarjetasCredito.indexOf(tarjeta) + "]");
            tarjeta.mostrarTarjeta();
        }
    }

    public Debito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public ArrayList<Credito> getTarjetasCredito() {
        return tarjetasCredito;
    }

    public ArrayList<SolicitudTarjeta> getSolicitudTarjetas() {
        return solicitudTarjetas;
    }
}


