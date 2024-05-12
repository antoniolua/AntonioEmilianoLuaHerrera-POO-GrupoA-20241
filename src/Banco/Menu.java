package Banco;

import Usuarios.*;
import Usuarios.Empleados.Capturista;
import Usuarios.Empleados.EjecutivoDeCuenta;
import Usuarios.Empleados.GerenteDeSucursal;
import Usuarios.Tarjetas.Credito;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import Usuarios.Utils.Rol;
import Usuarios.Utils.Sucursal;
import Utils.UsuarioEnSesion;

import static Banco.Banco.usuarios;

public class Menu {

    private static final Scanner read = new Scanner(System.in);
    private static final Banco banco = new Banco();

    public Menu(){}

    public static void iniciarSesion(){
        int opc = 5;
        boolean datosCorrectos = true;

        System.out.println("BIENVENIDO AL SISTEMA BANCARIO. ");

        do {
            System.out.printf("Inicia sesion para continuar, intentos restantes [%d]. \n",opc);

            System.out.println("Ingresa tu nombre de usuario. ");
            String nombre = read.nextLine();

            System.out.println("Ingresa tu contrasena ");
            String contrasena = read.nextLine();

            opc--;

            Usuario usuario = banco.verificarInicioSesion(nombre,contrasena);

            if (usuario != null){
                UsuarioEnSesion.getInstancia().setUsuario(usuario);
                seleccionarMenu();
                opc = 5;
            } else if (opc == 0){
                System.out.println("INTENTOS TERMINADOS, TERMINANDO EL PROGRAMA. ");
                datosCorrectos = false;
            } else {
                System.out.println("CUENTA NO EXISTENTE. ");
            }
        } while (datosCorrectos);
    }

    private static void seleccionarMenu() {
        switch (UsuarioEnSesion.getUsuarioActual().getRol()) {
            case Cliente -> ejecutarMenuCliente();
            case GerenteDeSucursal -> ejecutarMenuGerente();
            case Inversionista -> ejecutarMenuInversionista();
            case Capturista -> ejecutarMenuCapturista();
            case EjecutivoDeCuenta -> ejecutarMenuEjecutivo();
        }
    }

    private static  void ejecutarMenuCliente() {
        String option = "";
        Scanner leer = new Scanner(System.in);
        Cliente cliente = (Cliente) UsuarioEnSesion.getUsuarioActual();
        System.out.println("Bienvenido "+ UsuarioEnSesion.getUsuarioActual().getNombre()+", se encuentra en el menu de Cliente.");
        do{
            System.out.println("----------------------------------");
            System.out.println("Por favor, seleccione una opción. ");
            System.out.println("1 - Mostrar datos de tarjetas");
            System.out.println("2 - Depositar dinero");
            System.out.println("3 - Retirar dinero");
            System.out.println("4 - Pagar con tarjeta de credito");
            System.out.println("5 - Pagar tarjeta de credito");
            System.out.println("6 - Listar tarjetas");
            System.out.println("7 - Crear Solicitud");
            if (!cliente.getSolicitudTarjetas().isEmpty()){
                System.out.println("8 - Ver Solicitudes");
            }
            System.out.println("E - Cerrar sesion.");
            option=leer.nextLine();
            switch (option){
                case "1":
                    System.out.println("** Tarjeta Debito **");
                    cliente.getTarjetaDebito().mostrarTarjeta();
                    if(cliente.getTarjetasCredito().isEmpty()){
                        break;
                    }
                    System.out.println("** Tarjeta Credito **");
                    for (Credito credito :cliente.getTarjetasCredito()){
                        credito.mostrarTarjeta();
                    }
                    break;
                case "2" :
                    if(cliente.getTarjetaDebito().verificarCodigo()){
                        try{
                            System.out.println("Ingrese la cantidad que desea ingresar: ");
                            int cantidad = leer.nextInt();
                            if (cantidad > 0){
                                cliente.getTarjetaDebito().depositarDinero(cantidad);
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un entero");
                        }
                        System.out.println("Dinero ingresado exitosamente. ");
                        leer.nextLine();
                    }
                    break;
                case "3" :
                    if(cliente.getTarjetaDebito().verificarCodigo()){
                        try{
                            System.out.println("Ingrese la cantidad que desea retirar: ");
                            int cantidad = leer.nextInt();
                            if (cliente.getTarjetaDebito().getSaldo() - cantidad >= 0){
                                cliente.getTarjetaDebito().retirarDinero(cantidad);
                                System.out.println("Dinero retirado exitosamente. ");
                            }
                            else{
                                System.out.println("Saldo insuficiente");
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un entero");
                        }
                        leer.nextLine();
                    }
                    break;
                case "4":
                    Credito credito = null;
                    if (cliente.getTarjetasCredito().isEmpty()) break;
                    cliente.imprimirIndiceTarjetaCredito();
                    try{
                        System.out.println("Ingrese la tarjeta con la que pagara: ");
                        int tarjeta = leer.nextInt();
                        if (tarjeta < cliente.getTarjetasCredito().size() && tarjeta >= 0){
                            credito = cliente.getTarjetasCredito().get(tarjeta);
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Debe ingresar un entero");
                    }
                    assert credito != null;
                    if(credito.verificarCodigo()){
                        try{
                            System.out.println("Ingrese la cantidad que pagara: ");
                            int cantidad = leer.nextInt();
                            if (credito.getCredito() - cantidad >= 0){
                                credito.pagarConTarjeta(cantidad);
                            }
                            else{
                                System.out.println("Credito insuficiente");
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un entero");
                        }
                        leer.nextLine();
                    }
                    break;
                case "5" :
                    if (cliente.getTarjetasCredito().isEmpty()) break;
                    if(cliente.getTarjetaDebito().verificarCodigo()){
                        cliente.imprimirIndiceTarjetaCredito();
                        try{
                            System.out.println("Ingrese la tarjeta a pagar: ");
                            int tarjeta = leer.nextInt();
                            if (tarjeta < cliente.getTarjetasCredito().size() && tarjeta >= 0){
                                cliente.getTarjetasCredito().get(tarjeta).pagarTarjeta(cliente);
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un entero");
                        }
                    }
                    break;
                case "6":
                    cliente.mostrarTarjetas();
                    break;
                case "8":
                    cliente.verSolicitudesTarjetaCreditoC();
                    break;
                case "7":
                    cliente.solicitarTarjetaCredito();
                    break;
                case "E" :
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default :
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));
    }

    private static void ejecutarMenuGerente() {
        String option = "";
        Scanner leer = new Scanner(System.in);
        ArrayList<Usuario> usuarios = Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.Cliente);
        System.out.println("Bienvenido "+ UsuarioEnSesion.getUsuarioActual().getNombre()+" se encuentra en el menu de Gerente.");
        do{
            System.out.println("1 - Opciones de clientes");
            System.out.println("2 - Opciones de ejecutivos de cuenta");
            System.out.println("3 - Opciones de inversionista");
            System.out.println("4 - Opciones de capturista");
            System.out.println("5 - Revisar solicitudes");
            System.out.println("6 - Mostrar tarjetas");
            System.out.println("7 - Mostrar usuarios");
            System.out.println("E - Cerrar sesion.");
            option=leer.nextLine();
            switch (option){
                case "1": // Cliente
                    menuGerenteCliente();
                    break;
                case "2" : // Ejecutivos
                    menuGerenteEjecutivo();
                    break;
                case "3" : // Inversionista
                    menuGerenteInversionista();
                    break;
                case "4": // Capturista
                    menuGerenteCapturista();
                    break;
                case "5" :
                    boolean bandp = false;
                    for (Usuario usuario : usuarios){
                        Cliente cliente = (Cliente) usuario;
                        for (SolicitudTarjeta solicitud : cliente.getSolicitudTarjetas()){
                            if (solicitud.getEstatus().equals("En proceso")) {
                                bandp = true;
                                break;
                            }
                        }
                    }
                    if(!bandp){
                        System.out.println("Sin solicitudes activas");
                        ejecutarMenuGerente();
                    }
                    boolean bandv = true;
                    Cliente finalCliente = null;
                    int solicitud = 0;
                    for (Usuario usuario : usuarios){
                        Cliente cliente = (Cliente) usuario;
                        cliente.verSolicitudesTarjetaCreditoE();
                    }
                    while (bandv){
                        System.out.println("Ingrese el nombre de usuario del solicitante: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                finalCliente = (Cliente) usuario;
                                bandv = false;
                                break;
                            }
                        }
                        if (bandv){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    while (true) {
                        SolicitudTarjeta prueba = null;
                        try{
                            System.out.println("Ingrese el numero de solicitud: ");
                            solicitud = leer.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un entero");
                        }
                        try {
                            prueba = finalCliente.getSolicitudTarjetas().get(solicitud);
                            if (!prueba.getEstatus().equals("En proceso")){
                                prueba = null;
                            }
                        }catch(IndexOutOfBoundsException e){
                            System.out.println("Indice invalido.");
                        }
                        if (prueba != null){
                            break;
                        }
                    }
                    leer.nextLine();
                    while (true){
                        System.out.println("Que desea hacer con la solicitud: [A] Aprobar [R] Rechazar");
                        option = leer.nextLine();
                        if (option.equals("A")){
                            finalCliente.getSolicitudTarjetas().get(solicitud).aprobarSolicitud();
                            break;
                        }
                        else if (option.equals("R")){
                            finalCliente.getSolicitudTarjetas().get(solicitud).rechazarSolicitud();
                            break;
                        }
                        else{
                            System.out.println("Opcion invalida");
                        }
                    }
                    break;
                case "6":
                    for (Usuario usuario : usuarios){
                        Cliente cliente = (Cliente) usuario;
                        cliente.getTarjetaDebito().mostrarTarjeta();
                        for (Credito credito : cliente.getTarjetasCredito()){
                            credito.mostrarTarjeta();
                        }
                    }
                    break;
                case "7":
                    Usuario.mostrarAllUsuarios();
                    break;
                case "E" :
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default :
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));
    }

    private static void ejecutarMenuInversionista(){
        System.out.println("Bienvenido "+ UsuarioEnSesion.getUsuarioActual().getNombre()+" se encuentra en el menu de Inversionista.");
        String option = "";
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("1 - Proveer dinero al banco");
            System.out.println("E - Cerrar sesion");
            option= leer.nextLine();
            switch (option) {
                case "1":
                    Inversionista.anadirFondos();
                    break;
                case "E":
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (!option.equals("E"));
    }

    private static void ejecutarMenuCapturista(){
        String option = "";
        Scanner leer = new Scanner(System.in);
        ArrayList<Usuario> usuarios = Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.EjecutivoDeCuenta);
        System.out.println("Bienvenido "+ UsuarioEnSesion.getUsuarioActual().getNombre()+" se encuentra en el menu de Capturista.");
        do {
            System.out.println("1 - Registrar ejecutivo de cuenta");
            System.out.println("2 - Modificar datos de ejecutivo de cuenta");
            System.out.println("3 - Eliminar ejecutivo de cuenta");
            System.out.println("4 - Mostrar ejecutivos de cuenta");

            System.out.println("E - Cerrar sesion.");
            option = leer.nextLine();
            switch (option) {
                case "1":
                    EjecutivoDeCuenta.registrarEjecutivo();
                    break;
                case "2":
                    boolean bandc = true;
                    Usuario finalUsuario = null;
                    while (bandc) {
                        for (Usuario usuario : usuarios) {
                            System.out.println(usuario.getUsuario());
                        }
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios) {
                            if (usuario.getUsuario().equals(nombre)) {
                                finalUsuario = usuario;
                                bandc = false;
                                break;
                            }
                        }
                        if (bandc) {
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    EjecutivoDeCuenta.actualizarInformacion(finalUsuario);
                    break;
                case "3":
                    boolean bandp = true;
                    if (usuarios.isEmpty()){
                        System.out.println("Sin capturistas registrados");
                        break;
                    }
                    while (bandp){
                        for (Usuario usuario : usuarios){
                            System.out.println(usuario.getUsuario());
                        }
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.EjecutivoDeCuenta).remove(usuario);
                                bandp = false;
                                break;
                            }
                        }
                        if (bandp){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    break;
                case "4":
                    EjecutivoDeCuenta.mostrarAllEjecutivoDeCuenta();
                    break;
                case "E":
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));
    }

    private static void ejecutarMenuEjecutivo(){
        String option = "";
        Scanner leer = new Scanner(System.in);
        ArrayList<Usuario> usuarios = Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.Cliente);
        System.out.println("Bienvenido "+ UsuarioEnSesion.getUsuarioActual().getNombre()+" se encuentra en el menu de Ejecutivo de cuenta.");
        do{
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Modificar datos de cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Revisar solicitudes");
            System.out.println("5 - Mostrar usuarios");
            System.out.println("E - Cerrar sesion.");
            option=leer.nextLine();
            switch (option){
                case "1":
                    Cliente.registrarCliente();
                    break;
                case "2" :
                    boolean bandc = true;
                    Usuario finalUsuario = null;
                    while (bandc){
                        for (Usuario usuario : usuarios){
                            System.out.println(usuario.getUsuario());
                        }
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                finalUsuario = usuario;
                                bandc = false;
                                break;
                            }
                        }
                        if (bandc){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    Cliente.actualizarInformacion(finalUsuario);
                    break;
                case "3" :
                    boolean bandp = true;
                    if (usuarios.isEmpty()){
                        System.out.println("Sin clientes registrados");
                        break;
                    }
                    while (bandp){
                        for (Usuario usuario : usuarios){
                            System.out.println(usuario.getUsuario());
                        }
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.Cliente).remove(usuario);
                                bandp = false;
                                break;
                            }
                        }
                        if (bandp){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    break;
                case "4" :
                    boolean bandv = true;
                    Cliente finalCliente = null;
                    int solicitud = 0;
                    for (Usuario usuario : usuarios){
                        Cliente cliente = (Cliente) usuario;
                        cliente.verSolicitudesTarjetaCreditoE();
                    }
                    while (bandv){
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                finalCliente = (Cliente) usuario;
                                bandv = false;
                                break;
                            }
                        }
                        if (bandv){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    while (true) {
                        try{
                            System.out.println("Ingrese el numero de solicuitud: ");
                            solicitud = leer.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Debe ingresar un entero");
                        }
                        if (solicitud < 0 || solicitud >= usuarios.size()) {
                            System.out.println("Indice no valido");
                        } else {
                            break;
                        }
                    }
                    leer.nextLine();
                    while (true){
                        System.out.println("Que desea hacer con la solicitud: [A] Aprobar [R] Rechazar");
                        option = leer.nextLine();
                        if (option.equals("A")){
                            finalCliente.getSolicitudTarjetas().get(solicitud).aprobarSolicitud();
                            break;
                        }
                        else if (option.equals("R")){
                            finalCliente.getSolicitudTarjetas().get(solicitud).rechazarSolicitud();
                            break;
                        }
                        else{
                            System.out.println("Opcion invalida");
                        }
                    }
                    break;
                case "5":
                    Cliente.mostrarAllClientes();
                    break;
                case "E" :
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default :
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));

    }

    private static void menuGerenteCapturista(){
        String option = "";
        Scanner leer = new Scanner(System.in);
        ArrayList<Usuario> usuarios = Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.Capturista);
        System.out.println("** Opciones de capturista **");
        do{
            System.out.println("1 - Registrar capturista");
            System.out.println("2 - Modificar datos de capturista");
            System.out.println("3 - Eliminar capturista");
            System.out.println("4 - Mostrar capturistas");

            System.out.println("E - Salir.");
            option=leer.nextLine();
            switch (option){
                case "1":
                    Capturista.registrarCapturista();
                    break;
                case "2" :
                    boolean bandc = true;
                    Usuario finalUsuario = null;
                    while (bandc){
                        for (Usuario usuario : usuarios){
                            System.out.println(usuario.getUsuario());
                        }
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                finalUsuario = usuario;
                                bandc = false;
                                break;
                            }
                        }
                        if (bandc){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    Capturista.actualizarInformacion(finalUsuario);
                    break;
                case "3":
                    bandc = true;
                    if (usuarios.isEmpty()){
                        System.out.println("Sin capturistas registrados");
                        break;
                    }
                    while (bandc){
                        for (Usuario usuario : usuarios){
                            System.out.println(usuario.getUsuario());
                        }
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.Capturista).remove(usuario);
                                bandc = false;
                                break;
                            }
                        }
                        if (bandc){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    break;
                case "4":
                    Capturista.mostrarAllCapturista();
                    break;
                case "E" :
                    ejecutarMenuGerente();
                    break;
                default :
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));
    }

    private static void menuGerenteInversionista(){
        String option = "";
        boolean band = false, bandc= false;
        Scanner leer = new Scanner(System.in);
        ArrayList<Usuario> usuarios = Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.Inversionista);
        System.out.println("** Opciones de Inversionista **");
        do{
            System.out.println("1 - Registrar inversionista");
            System.out.println("2 - Modificar datos de inversionista");
            System.out.println("3 - Eliminar inversionista");
            System.out.println("4 - Mostrar inversionista");

            System.out.println("E - Salir.");
            option=leer.nextLine();
            switch (option){
                case "1":
                    band = contrasenaGerente();
                    if (band){
                        Inversionista.registrarInversionista();
                    } else {
                        System.out.println("Contrasena no correcta, enviandolo al menu.");
                    }
                    break;
                case "2" :
                    band = contrasenaGerente();
                    if (band){
                        bandc = true;
                        Usuario finalUsuario = null;
                        while (bandc){
                            for (Usuario usuario : usuarios){
                                System.out.println(usuario.getUsuario());
                            }
                            System.out.println("Ingrese el nombre de usuario: ");
                            String nombre = leer.nextLine();
                            for (Usuario usuario : usuarios){
                                if (usuario.getUsuario().equals(nombre)){
                                    finalUsuario = usuario;
                                    bandc = false;
                                    break;
                                }
                            }
                            if (bandc){
                                System.out.println("Usuario ingresado no encontrado");
                            }
                        }
                        Inversionista.actualizarInformacion(finalUsuario);
                    } else {
                        System.out.println("Contrasena no correcta, enviandolo al menu.");
                    }
                    break;
                case "3":
                    band = contrasenaGerente();
                    if (band){
                        bandc = true;
                        if (usuarios.isEmpty()){
                            System.out.println("Sin inversionistas registrados");
                            break;
                        }
                        while (bandc){
                            for (Usuario usuario : usuarios){
                                System.out.println(usuario.getUsuario());
                            }
                            System.out.println("Ingrese el nombre de usuario: ");
                            String nombre = leer.nextLine();
                            for (Usuario usuario : usuarios){
                                if (usuario.getUsuario().equals(nombre)){
                                    Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.Inversionista).remove(usuario);
                                    bandc = false;
                                    break;
                                }
                            }
                            if (bandc){
                                System.out.println("Usuario ingresado no encontrado");
                            }
                        }
                    } else {
                        System.out.println("Contrasena no correcta, enviandolo al menu.");
                    }
                    break;
                case "4":
                    band = contrasenaGerente();
                    if (band){
                        Inversionista.mostrarAllInversionistas();
                    } else {
                        System.out.println("Contrasena no correcta, enviandolo al menu.");
                    }
                    break;
                case "E" :
                    ejecutarMenuGerente();
                    break;
                default :
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));
    }

    private static boolean contrasenaGerente(){
        System.out.println("Para mayor seguridad, por favor ingrese su contrasena: ");
            String contra = read.nextLine();
            if (UsuarioEnSesion.getUsuarioActual().getContrasena().equals(contra)){
                System.out.println("Contraseña correcta, adelante con el procedimiento. ");
                return true;
            } else {
                return false;
            }
    }

    private static void menuGerenteEjecutivo(){
        String option = "";
        Scanner leer = new Scanner(System.in);
        ArrayList<Usuario> usuarios = Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.EjecutivoDeCuenta);
        System.out.println("** Opciones de ejecutivo de cuenta **");
        do{
            System.out.println("1 - Registrar ejecutivo de cuenta");
            System.out.println("2 - Modificar datos de ejecutivo de cuenta");
            System.out.println("3 - Eliminar ejecutivo de cuenta");
            System.out.println("4 - Mostrar ejecutivos de cuenta");

            System.out.println("E - Salir.");
            option=leer.nextLine();
            switch (option){
                case "1":
                    EjecutivoDeCuenta.registrarEjecutivo();
                    break;
                case "2" :
                    boolean bandc = true;
                    Usuario finalUsuario = null;
                    while (bandc){
                        for (Usuario usuario : usuarios){
                            System.out.println(usuario.getUsuario());
                        }
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                finalUsuario = usuario;
                                bandc = false;
                                break;
                            }
                        }
                        if (bandc){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    EjecutivoDeCuenta.actualizarInformacion(finalUsuario);
                    break;
                case "3":
                    bandc = true;
                    if (usuarios.isEmpty()){
                        System.out.println("Sin ejecutivos de cuenta registrados");
                        break;
                    }
                    while (bandc){
                        for (Usuario usuario : usuarios){
                            System.out.println(usuario.getUsuario());
                        }
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                Banco.usuarios.get(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal()).get(Rol.EjecutivoDeCuenta).remove(usuario);
                                bandc = false;
                                break;
                            }
                        }
                        if (bandc){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    break;
                case "4":
                    EjecutivoDeCuenta.mostrarAllEjecutivoDeCuenta();
                    break;
                case "E" :
                    ejecutarMenuGerente();
                    break;
                default :
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));
    }

    private static void menuGerenteCliente(){
        String option = "";
        Scanner leer = new Scanner(System.in);
        ArrayList<Usuario> usuarios = Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.Cliente);
        System.out.println("** Opciones de Cliente **");
        do{
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Modificar datos de cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Mostrar clientes");

            System.out.println("E - Salir.");
            option=leer.nextLine();
            switch (option){
                case "1":
                    Cliente.registrarCliente();
                    System.out.println("Cliente correctamente registrado. ");
                    break;
                case "2" :
                    boolean bandc = true;
                    Usuario finalUsuario = null;
                    while (bandc){
                        for (Usuario usuario : usuarios){
                            if (usuario.getSucursal().equals(UsuarioEnSesion.getUsuarioActual().getSucursal())){
                                System.out.println(usuario.getUsuario());
                            }
                        }
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                finalUsuario = usuario;
                                bandc = false;
                                break;
                            }
                        }
                        if (bandc){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    Cliente.actualizarInformacion(finalUsuario);
                    break;
                case "3":
                    bandc = true;
                    if (usuarios.isEmpty()){
                        System.out.println("Sin clientes registrados");
                        break;
                    }
                    while (bandc){
                        for (Usuario usuario : usuarios){
                            if (usuario.getSucursal().equals(UsuarioEnSesion.getUsuarioActual().getSucursal())) {
                                System.out.println(usuario.getUsuario());
                            }
                        }
                        System.out.println("Ingrese el nombre de usuario: ");
                        String nombre = leer.nextLine();
                        for (Usuario usuario : usuarios){
                            if (usuario.getUsuario().equals(nombre)){
                                Banco.usuarios.get(UsuarioEnSesion.getUsuarioActual().getSucursal()).get(Rol.Cliente).remove(usuario);
                                System.out.println("Cliente correctamente eliminado. ");
                                bandc = false;
                                break;
                            }
                        }
                        if (bandc){
                            System.out.println("Usuario ingresado no encontrado");
                        }
                    }
                    break;
                case "4":
                    Cliente.mostrarAllClientes();
                    break;
                case "E" :
                    ejecutarMenuGerente();
                    break;
                default :
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));
    }

    public static void registroDefinido(){
        usuarios.put(Sucursal.Madero, new HashMap<>());
        usuarios.put(Sucursal.Acueducto, new HashMap<>());

        // Cliente
        usuarios.get(Sucursal.Madero).put(Rol.Cliente, new ArrayList<>());
        Cliente clienteMadero = new Cliente("NOMBRE", "APELLIDO", LocalDate.of(2000,1,1), "CIUDAD", "ESTADO", "RFC", "CURP", "DIRECCION", "M", Sucursal.Madero, "CLIENTEM");
        usuarios.get(Sucursal.Madero).get(Rol.Cliente).add(clienteMadero);

        usuarios.get(Sucursal.Acueducto).put(Rol.Cliente, new ArrayList<>());
        Cliente clienteAcueducto = new Cliente("NOMBRE", "APELLIDO", LocalDate.of(2000,1,1), "CIUDAD", "ESTADO", "RFC", "CURP", "DIRECCION", "A", Sucursal.Acueducto, "CLIENTEA");
        usuarios.get(Sucursal.Acueducto).get(Rol.Cliente).add(clienteAcueducto);

        // Ejecutivo de cuenta
        usuarios.get(Sucursal.Madero).put(Rol.EjecutivoDeCuenta, new ArrayList<>());
        EjecutivoDeCuenta ejecutivoCuentaMadero = new EjecutivoDeCuenta("NOMBRE", "APELLIDO", LocalDate.of(2000,1,1), "CIUDAD", "ESTADO", "RFC", "CURP", "DIRECCION", "M", Sucursal.Madero, "EJECUTIVOM", 1, LocalDate.now());
        usuarios.get(Sucursal.Madero).get(Rol.EjecutivoDeCuenta).add(ejecutivoCuentaMadero);

        usuarios.get(Sucursal.Acueducto).put(Rol.EjecutivoDeCuenta, new ArrayList<>());
        EjecutivoDeCuenta ejecutivoCuentaAcueducto = new EjecutivoDeCuenta("NOMBRE", "APELLIDO", LocalDate.of(2000,1,1), "CIUDAD", "ESTADO", "RFC", "CURP", "DIRECCION", "A", Sucursal.Acueducto, "EJECUTIVOA", 1, LocalDate.now());
        usuarios.get(Sucursal.Acueducto).get(Rol.EjecutivoDeCuenta).add(ejecutivoCuentaAcueducto);

        // Gerente
        usuarios.get(Sucursal.Acueducto).put(Rol.GerenteDeSucursal, new ArrayList<>());
        GerenteDeSucursal nuevoGerenteAcueducto = new GerenteDeSucursal("NOMBRE", "APELLIDO", LocalDate.of(2000, 1, 1), "CIUDAD", "ESTADO", "RFC", "CURP", "DIRECCION", "A",Sucursal.Acueducto, "GERENTEA",1, LocalDate.now());
        usuarios.get(Sucursal.Acueducto).get(Rol.GerenteDeSucursal).add(nuevoGerenteAcueducto);

        usuarios.get(Sucursal.Madero).put(Rol.GerenteDeSucursal, new ArrayList<>());
        GerenteDeSucursal nuevoGerenteMadero = new GerenteDeSucursal("NOMBRE", "APELLIDO", LocalDate.of(2000, 1, 1), "CIUDAD", "ESTADO", "RFC", "CURP", "DIRECCION", "M", Sucursal.Madero, "GERENTEM", 1, LocalDate.now());
        usuarios.get(Sucursal.Madero).get(Rol.GerenteDeSucursal).add(nuevoGerenteMadero);

        // Inversionista
        usuarios.get(Sucursal.Madero).put(Rol.Inversionista, new ArrayList<>());
        Inversionista inversionistaMadero = new Inversionista("NOMBRE", "APELLIDO", LocalDate.of(2000, 1, 1), "CIUDAD", "ESTADO", "RFC", "CURP", "DIRECCION", "M", Sucursal.Madero, "INVERSIONISTAM");
        usuarios.get(Sucursal.Madero).get(Rol.Inversionista).add(inversionistaMadero);

        usuarios.get(Sucursal.Acueducto).put(Rol.Inversionista, new ArrayList<>());
        Inversionista inversionistaAcueducto = new Inversionista("NOMBRE", "APELLIDO", LocalDate.of(2000, 1, 1), "CIUDAD", "ESTADO", "RFC", "CURP", "DIRECCION", "A", Sucursal.Acueducto, "INVERSIONISTAA");
        usuarios.get(Sucursal.Acueducto).get(Rol.Inversionista).add(inversionistaAcueducto);

        // Capturista
        usuarios.get(Sucursal.Madero).put(Rol.Capturista, new ArrayList<>());
        Capturista capturistaMadero = new Capturista("NOMBRE", "APELLIDO", LocalDate.of(2000, 1, 1), "CIUDAD", "ESTADO", "RFC", "CURP", "DIRECCION", "M", Sucursal.Madero, "CAPTURISTAM", 1, LocalDate.now());
        usuarios.get(Sucursal.Madero).get(Rol.Capturista).add(capturistaMadero);

        usuarios.get(Sucursal.Acueducto).put(Rol.Capturista, new ArrayList<>());
        Capturista capturistaAcueducto = new Capturista("NOMBRE", "APELLIDO", LocalDate.of(2000, 1, 1), "CIUDAD", "ESTADO", "RFC", "CURP", "DIRECCION", "A", Sucursal.Acueducto, "CAPTURISTAA", 1, LocalDate.now());
        usuarios.get(Sucursal.Acueducto).get(Rol.Capturista).add(capturistaAcueducto);

    }
}
