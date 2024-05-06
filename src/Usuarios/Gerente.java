package Usuarios;

import Biblioteca.Biblioteca;
import Biblioteca.utils.DatosComun;
import Usuarios.utils.EmpleadosUtils;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Usuario implements EmpleadosUtils {
    private int anosLealtad;
    private float sueldo;

    public Gerente(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String numeroTelefono, String nombreUsuario, String contrasena, int anosLealtad, float sueldo) {
        super(nombre, apellido, rol, fechaNacimiento, numeroTelefono, nombreUsuario, contrasena);
        this.anosLealtad = anosLealtad;
        this.sueldo = sueldo;
    }
    public static void registrarGerente() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datosComun = DatosComun.obtenerDatosComunes(Rol.GERENTE);
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

        if (!Biblioteca.usuarios.containsKey(Rol.GERENTE)) {
            Biblioteca.usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("\nGerente Registrado\n");
    }
    public static void mostrarGerente(){
        System.out.println("*** GERENTES ***");
        if (Biblioteca.usuarios.containsKey(Rol.GERENTE)){
            for (Usuario gerentes : Biblioteca.usuarios.get(Rol.GERENTE)){
                System.out.println(gerentes.toString());
            }
        }else {
            System.out.println("No hay gerentes registrados.");
        }

    }
    public static void checarEntrada() {
        EmpleadosUtils.Entrada();// Llamar al método estático de la interfaz
    }

    public static void checarSalida() {
        EmpleadosUtils.Salida(); // Llamar al método estático de la interfaz
    }


}
