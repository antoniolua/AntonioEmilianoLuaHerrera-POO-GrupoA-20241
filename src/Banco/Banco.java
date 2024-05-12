package Banco;

import Usuarios.*;
import Usuarios.Empleados.Capturista;
import Usuarios.Empleados.EjecutivoDeCuenta;
import Usuarios.Empleados.GerenteDeSucursal;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Banco {
    public  float fondos;
    public Banco(float fondos) {
        this.fondos = fondos;
    }
    public Banco(){}

    public float getFondos() {
        return fondos;
    }

    public void setFondos(float fondos) {
        this.fondos = fondos;
    }

    public static HashMap<Sucursal, HashMap<Rol, ArrayList<Usuario>> > usuarios = new HashMap<>();

    public static ArrayList<Long> numTarjetas  = new ArrayList<>();

    public Usuario verificarInicioSesion(String nombre, String contrasena) {
        for (Map.Entry<Sucursal, HashMap<Rol, ArrayList<Usuario>>> sucursalEntry : usuarios.entrySet()) {
            HashMap<Rol, ArrayList<Usuario>> rolesPorSucursal = sucursalEntry.getValue();
            for (ArrayList<Usuario> usuarios : rolesPorSucursal.values()) {
                for (Usuario usuario : usuarios) {
                    if (usuario.getUsuario().equals(nombre) && usuario.getContrasena().equals(contrasena)) {
                        return usuario;
                    }
                }
            }
        }
        return null;
    }

    public static void actualizarInformacion(Usuario usuario) {
        Usuario.actualizarInformacion(usuario);
    }

    // Getters

    public static ArrayList<Long> getNumTarjetas() { return numTarjetas; }

    public void agregarCliente(){
        Cliente.registrarCliente();
    }

    public void agregarInversionista(){
        Inversionista.registrarInversionista();
    }

    public void agregarGerente(){
        GerenteDeSucursal.registrarGerente();
    }

    public void agregarEjecutivo(){
        EjecutivoDeCuenta.registrarEjecutivo();
    }

    public void agregarCapturista(){
        Capturista.registrarCapturista();
    }

    public void mostrarAllUsuarios(){
        Usuario.mostrarAllUsuarios();
    }

    public void mostrarAllClientes(){
        Cliente.mostrarAllClientes();
    }

    public void mosttrarAllCapturistas(){
        Capturista.mostrarAllCapturista();
    }

    public void mostrarAllEjecutivos(){
        EjecutivoDeCuenta.mostrarAllEjecutivoDeCuenta();
    }

    public void mostrarAllInversionistas(){
        Inversionista.mostrarAllInversionistas();
    }

    public void mostrarAllGerentes(){
        GerenteDeSucursal.mostrarAllGerenteDeSucursal();
    }




}
