package Usuarios;

import Usuarios.Empleados.Capturista;
import Usuarios.Empleados.EjecutivoDeCuenta;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursal;
import Utils.Utils;
import java.time.LocalDate;
import java.util.Scanner;


public class Usuario {
    protected String nombre;
    protected String apellido;
    protected LocalDate fechaNacimiento;
    protected String ciudad;
    protected String estado;
    protected String rfc;
    protected String curp;
    protected String direccion;
    protected LocalDate fechaRegistro;
    protected String contrasena;
    protected Rol rol;
    protected Sucursal sucursal;
    protected String usuario;

    public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, String ciudad, String estado, String rfc, String curp, String direccion, String contrasena, Rol rol, Sucursal sucursal, String usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.rfc = rfc;
        this.curp = curp;
        this.direccion = direccion;
        this.fechaRegistro = LocalDate.now();
        this.contrasena = contrasena;
        this.rol = rol;
        this.sucursal = sucursal;
        this.usuario = usuario;
    }

    public static void mostrarAllUsuarios(){
        System.out.println("** Clientes **");
        Cliente.mostrarAllClientes();
        System.out.println("\n** Inversionistas **");
        Inversionista.mostrarAllInversionistas();
        System.out.println("\n** Ejecutivos de cuenta **");
        EjecutivoDeCuenta.mostrarAllEjecutivoDeCuenta();
        System.out.println("\n** Capturistas **");
        Capturista.mostrarAllCapturista();
    }

    public static void actualizarInformacion(Usuario usuario){
        Scanner read= new Scanner(System.in);
        String opcion = "";
        Rol rol= usuario.getRol();
        do {
            System.out.println("Que caracteristicas deseas cambiar del usuario seleccionado. ");
            System.out.println("1. Ciudad de residencia. ");
            System.out.println("2. Estado de residencia. ");
            System.out.println("3. Direccion. ");
            System.out.println("4. Contraseña. ");
            System.out.println("5. Nombre de Usuario");
            System.out.println("6. SALIR DE ESTE MENU. ");
            opcion = read.nextLine();
            
            if (opcion.equals("1")) {
                System.out.println("Ingresa la nueva ciudad de residencia. ");
                String ciudad = read.nextLine();
                usuario.setCiudad(ciudad);
                System.out.println("Ciudad cambiada con exito.");
            } else if (opcion.equals("2")) {
                System.out.println("Ingresa el nuevo estado de residencia. ");
                String estado = read.nextLine();
                usuario.setEstado(estado);
                System.out.println("Estado cambiado con exito.");
            } else if (opcion.equals("3")) {
                System.out.println("Ingresa la nueva calle del usuario: ");
                String calle = read.nextLine();
                System.out.println("Ingresa la nueva colonia: ");
                String colonia = read.nextLine();
                System.out.println("Ingresa el nuevo numero de casa: ");
                String numero = read.nextLine();
                String direccion= "Calle: "+ calle + "Colonia: "+ colonia +"Numero de casa: "+ numero;
                usuario.setDireccion(direccion);
                System.out.println("Dirección cambiada con exito. ");
            } else if (opcion.equals("4")) {
                System.out.println("Ingresa la nueva contraseña: ");
                String contrasena = read.nextLine();
                usuario.setContrasena(contrasena);
                System.out.println("Contraseña cambiada con exito. ");
            } else if (opcion.equals("5")) {
                while (true){
                    System.out.println("Ingrese el nuevo nombre de usuario: ");
                    String nUsuario = read.nextLine();

                    boolean band2 = Utils.verificarUsuario(nUsuario);
                    if (!band2){
                        usuario.setUsuario(nUsuario);
                        break;
                    } else {
                        System.out.println("El nombre de usuario ya esta registrada en el sistema, ingresa datos nuevos.");
                    }
                }
                System.out.println("Usuario cambiado con exito. ");
            } else if (opcion.equals("6")) {
                System.out.println("SALIENDO DEL MENU. ");
                break;
            } else  {
                System.out.println("OPCION NO VALIDA. ");
            }

        } while (true);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public String getRfc() {
        return rfc;
    }

    public String getCurp() {
        return curp;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public String getUsuario() { return usuario; }

    // Setters
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setUsuario(String usuario) { this.usuario = usuario; }
}
