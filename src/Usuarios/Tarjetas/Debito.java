package Usuarios.Tarjetas;


import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Debito extends Tarjeta{
    private double saldo;

    public Debito(String nombre, String apellido, String tipo) {
        super(nombre, apellido, tipo);
        this.saldo = 0;
    }

    public void mostrarTarjeta(){
        System.out.println("Tipo: "+ super.tipo);
        System.out.println("Numero de tarjeta: "+ super.numero);
        System.out.println("Fecha creacion: "+ super.fechaCreacion);
        System.out.println("Fecha vencimiento: "+ super.fechaVencimiento);
        System.out.println("Saldo: "+ saldo);
        System.out.println("Clave interbancaria: "+ super.claveInterbancaria);
        System.out.println("CVV: "+ super.cvv);
        System.out.println("Fecha ultimo movimiento: "+ super.fechaUltimoMovimiento);
        System.out.println();
    }

    public void retirarDinero(double cantidad){
        if (cantidad > 0){
            this.saldo -= cantidad;
        }
        super.fechaUltimoMovimiento = LocalDateTime.now();
    }

    public void depositarDinero(double cantidad){
        this.saldo += cantidad;
        super.fechaUltimoMovimiento = LocalDateTime.now();
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public boolean verificarCodigo(){
        Scanner sc = new Scanner(System.in);
        int codigo;
        try{
            System.out.println("Introduzca el codigo de la tarjeta de debito: ");
            codigo = sc.nextInt();
            sc.nextLine();
            if(codigo == this.claveInterbancaria){
                System.out.println("Clave correcta");
                return true;
            }
            else{
                System.out.println("Clave incorrecta");
                return false;
            }
        }catch (InputMismatchException e){
            System.out.println("Debe ingresar un entero");
        }
        return false;
    }
}
