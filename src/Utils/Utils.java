package Utils;

import Banco.Banco;
import Usuarios.Usuario;
import Usuarios.Utils.Rol;

import java.util.*;
import java.time.LocalDate;

public class Utils {
    static Scanner read = new Scanner(System.in);
    static Random random = new Random();


    public static ArrayList<String> obtenerDatosComun(Rol rol){
        ArrayList<String> datosComun = new ArrayList<>();
        String apellidoMaterno = "",contra ="", apellidoPaterno="",nombre="",curp="",usuario="", ciudad="", estado= "", colonia = "", calle="";

        String rolActual = rol == Rol.Cliente ? "Cliente": rol == Rol.Capturista ? "Capturista" : rol == Rol.Inversionista ? "Inversionista "
                : rol == Rol.EjecutivoDeCuenta ? "Ejecutivo de cuenta" : "Gerente de sucursal";
        System.out.println("ROL: "+rolActual);

        do {
            boolean band = false;
            System.out.println("Ingresa tu nombre: ");
            nombre = read.nextLine();
            if (nombre.isEmpty()) {
                band = true;
            } else{
                for (int i = 0; i < nombre.length(); i++) {
                    if (nombre.charAt(i) == '1' || nombre.charAt(i) == '2' || nombre.charAt(i) == '3' || nombre.charAt(i) == '4' || nombre.charAt(i) == '5' || nombre.charAt(i) == '6' || nombre.charAt(i) == '7' || nombre.charAt(i) == '8' || nombre.charAt(i) == '9' || nombre.charAt(i) == '0') {
                        band = true;
                        break;
                    }
                }
            }
            if (band){
                System.out.println("Nombre con numeros/vacio no es valido, por favor ingresa otro. ");
            } else {
                break;
            }
        } while (true);

        do {
            boolean band = false;
            System.out.println("Ingresa tu apellido paterno: ");
            apellidoPaterno = read.nextLine();
            if (apellidoPaterno.isEmpty()) {
                band = true;
            } else{
                for (int i = 0; i < apellidoPaterno.length(); i++) {
                    if (apellidoPaterno.charAt(i) == '1' || apellidoPaterno.charAt(i) == '2' || apellidoPaterno.charAt(i) == '3' || apellidoPaterno.charAt(i) == '4' || apellidoPaterno.charAt(i) == '5' || apellidoPaterno.charAt(i) == '6' || apellidoPaterno.charAt(i) == '7' || apellidoPaterno.charAt(i) == '8' || apellidoPaterno.charAt(i) == '9' || apellidoPaterno.charAt(i) == '0'){
                        band = true;
                        break;
                    }
                }
            }
            if (band){
                System.out.println("Apellido paterno con numeros/vacio no es valido, por favor ingresa otro. ");
            } else {
                break;
            }
        } while (true);


        do {
            boolean band = false;
            System.out.println("Ingresa tu apellido materno: ");
            apellidoMaterno = read.nextLine();
            if (apellidoMaterno.isEmpty()) {
                band = true;
            } else{
                for (int i = 0; i < apellidoMaterno.length(); i++) {
                    if (apellidoMaterno.charAt(i) == '1' || apellidoMaterno.charAt(i) == '2' || apellidoMaterno.charAt(i) == '3' || apellidoMaterno.charAt(i) == '4' || apellidoMaterno.charAt(i) == '5' || apellidoMaterno.charAt(i) == '6' || apellidoMaterno.charAt(i) == '7' || apellidoMaterno.charAt(i) == '8' || apellidoMaterno.charAt(i) == '9' || apellidoMaterno.charAt(i) == '0'){
                        band = true;
                        break;
                    }
                }
            }
            if (band){
                System.out.println("Apellido materno con números/vacío no es válido, por favor ingresa otro. ");
            } else {
                break;
            }
        } while (true);

        while (true) {


            do {
                System.out.println("Ingresa la CURP: ");
                curp = read.nextLine();
                if (curp.isEmpty()) {
                    System.out.println("CURP vacia no es valida. ");
                } else{
                    break;
                }
            } while (true);


            boolean band1 = verificarCURP(curp);

            if (!band1) {
                break;
            } else {
                System.out.println("La CURP ya esta registrada en el sistema, ingresa datos nuevos.");
            }
        }


        while (true) {
            do {
                System.out.println("Ingrese nombre de usuario: ");
                usuario = read.nextLine();
                if (usuario.isEmpty()) {
                    System.out.println("Usuario vacio no es valida. ");
                } else{
                    break;
                }
            }  while (true);

            boolean band2 = verificarUsuario(usuario);

            if (!band2){
                break;
            } else {
                System.out.println("El nombre de usuario ya esta registrada en el sistema, ingresa datos nuevos.");
            }
        }
        LocalDate fechaNacimiento = obtenerFechaNacimiento();
        String rfc = obtenerRFC(nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento);
        String apellidoFinal = apellidoPaterno + " " + apellidoMaterno;
        read.nextLine();
        do {
            boolean band = false;
            System.out.println("Ingresa tu ciudad: ");
            ciudad = read.nextLine();
            if (ciudad.isEmpty()) {
                band = true;
            } else{
                for (int i = 0; i < ciudad.length(); i++) {
                    if (ciudad.charAt(i) == '1' || ciudad.charAt(i) == '2' || ciudad.charAt(i) == '3' || ciudad.charAt(i) == '4' || ciudad.charAt(i) == '5' || ciudad.charAt(i) == '6' || ciudad.charAt(i) == '7' || ciudad.charAt(i) == '8' || ciudad.charAt(i) == '9' || ciudad.charAt(i) == '0'){
                        band = true;
                        break;
                    }
                }
            }
            if (band){
                System.out.println("Ciudad con números/vacío no es válida, por favor ingresa otra. ");
            } else {
                break;
            }
        } while (true);
        do {
            boolean band = false;
            System.out.println("Ingresa tu estado: ");
            estado = read.nextLine();
            if (estado.isEmpty()) {
                band = true;
            } else{
                for (int i = 0; i < estado.length(); i++) {
                    if (estado.charAt(i) == '1' || estado.charAt(i) == '2' || estado.charAt(i) == '3' || estado.charAt(i) == '4' || estado.charAt(i) == '5' || estado.charAt(i) == '6' || estado.charAt(i) == '7' || estado.charAt(i) == '8' || estado.charAt(i) == '9' || estado.charAt(i) == '0'){
                        band = true;
                        break;
                    }
                }
            }
            if (band){
                System.out.println("Estado con números/vacío no es válido, por favor ingresa otro. ");
            } else {
                break;
            }
        } while (true);
        do {
            System.out.println("Ingresa tu calle de residencia: ");
            calle = read.nextLine();
            if (calle.isEmpty()) {
                System.out.println("CALLE vacia no es valida. ");
            } else {
                break;
            }
        } while (true);
        do {
            System.out.println("Ingresa tu colonia: ");
            colonia = read.nextLine();
            if (colonia.isEmpty()) {
                System.out.println("Colonia vacia no es valida. ");
            } else {
                break;
            }
        } while (true);
        System.out.println("Ingresa tu numero de casa/departamento: ");
        String numeroDeCasa = read.nextLine();

        String direccion= "Calle: "+ calle + " Colonia: "+ colonia +" Numero de casa: "+numeroDeCasa;

        do {
            System.out.println("Finalmente, ingresa tu contraseña: ");
            contra = read.nextLine();
            if (contra.isEmpty()) {
                System.out.println("Colonia vacia no es valida. ");
            } else {
                break;
            }
        } while (true);

        datosComun.addAll(Arrays.asList(nombre, apellidoFinal, fechaNacimiento.toString(), ciudad, estado, rfc, curp, direccion
                , contra, usuario));
        return datosComun;

    }



    public static LocalDate obtenerFechaNacimiento(){
        int dia, mes, ano;
        LocalDate fechaNacimiento;
        while (true) {
            try {
                System.out.println("Ingresa el dia de nacimiento: ");
                int numero = read.nextInt();

                if (numero >= 1 && numero <= 31) {
                    dia = numero;
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero entre 01 y 31.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                read.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        while (true) {
            try {
                System.out.println("Ingresa el mes de nacimiento: ");
                int numero = read.nextInt();

                if (numero >= 1 && numero <= 12) {
                    mes = numero;
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero entre 01 y 12.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                read.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        while (true) {
            try {
                System.out.println("Ingresa el año de nacimiento: ");
                int numero = read.nextInt();

                if (numero >= 1920 && numero <= 2006) {
                    ano = numero;
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero entre 1920 y 2006. ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                read.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        return fechaNacimiento = LocalDate.of(ano, mes, dia);
    }

    public static String obtenerRFC(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento){

        String rfcBase = apellidoPaterno.substring(0, 2).toUpperCase() +
                apellidoMaterno.charAt(0) +
                nombre.charAt(0) +
                fechaNacimiento.toString().substring(2, 4) +
                fechaNacimiento.getMonthValue() +
                fechaNacimiento.getDayOfMonth();


        String caracteresAleatorios = generarCaracteresAleatorios(3);

        return rfcBase + caracteresAleatorios;
    }

    private static String generarCaracteresAleatorios(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(longitud);
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }

        return sb.toString();
    }

    public static boolean verificarCURP(String curp){
        for (HashMap<Rol, ArrayList<Usuario>> sucursal : Banco.usuarios.values()){
            for(ArrayList<Usuario> usuarios : sucursal.values()){
                for(Usuario usuario : usuarios){
                    if(usuario.getCurp().equals(curp)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean verificarUsuario(String nombre) {
        for (HashMap<Rol, ArrayList<Usuario>> sucursal : Banco.usuarios.values()) {
            for (ArrayList<Usuario> usuarios : sucursal.values()) {
                for (Usuario usuario : usuarios) {
                    if (usuario.getUsuario().equals(nombre)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static long obtenerNumeroTarjeta(){
        Random rand = new Random();
        boolean band = true;
        long numero;
        while (true){
            numero = rand.nextLong(9000000000000000L) + 1000000000000000L;
            for (long tarjeta: Banco.getNumTarjetas()){
                if(tarjeta == numero){
                    band = false;
                    break;
                }
            }
            if(band){
                break;
            }
        }
        Banco.getNumTarjetas().add((long) numero);
        return numero;
    }

}