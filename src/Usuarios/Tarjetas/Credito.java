package Usuarios.Tarjetas;

import Usuarios.Cliente;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Credito extends Tarjeta {

    private double credito;
    private final double maxCredito;

    public Credito(String nombre, String apellido, String tipo) {
        super(nombre, apellido, tipo);
        if (tipo.equals("Simplicity")) {
            this.maxCredito = 60000;
            this.credito = 60000;
        }
        else if (tipo.equals("Platino")) {
            this.maxCredito = 150000;
            this.credito = 150000;
        }
        else {
            this.maxCredito = 400000;
            this.credito = 400000;
        }
    }

    public void mostrarTarjeta(){
        System.out.println("Tipo: "+ super.tipo);
        System.out.println("Numero de tarjeta: "+ super.numero);
        System.out.println("Fecha creacion: "+ super.fechaCreacion);
        System.out.println("Fecha vencimiento: "+ super.fechaVencimiento);
        System.out.println("Credito: "+ credito);
        System.out.println("Clave interbancaria: "+ super.claveInterbancaria);
        System.out.println("CVV: "+ super.cvv);
        System.out.println("Fecha ultimo movimiento: "+ super.fechaUltimoMovimiento);
        System.out.println("-----------------------------");
        System.out.println();
    }

    public void gastarCredito(double cantidad){
        if (cantidad > 0){
            this.credito -= cantidad;
        }
        super.fechaUltimoMovimiento = LocalDateTime.now();
    }

    public void pagarTarjeta(Cliente cliente){
        if (cliente.getTarjetaDebito().getSaldo() - (maxCredito - this.credito) >= 0){
            cliente.getTarjetaDebito().retirarDinero(maxCredito - this.credito);
            this.credito = maxCredito;
        }
        else{
            System.out.println("Saldo insuficiente en tarjeta de debito");
        }

        super.fechaUltimoMovimiento = LocalDateTime.now();
    }

    public double getCredito() {
        return this.credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    @Override
    public boolean verificarCodigo(){
        Scanner sc = new Scanner(System.in);
        int codigo;
        try{
            System.out.println("Introduzca el codigo de la tarjeta de credito: ");
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

    public void pagarConTarjeta(double cantidad){
        if (cantidad > 0){
            this.credito -= cantidad;
        }
        super.fechaUltimoMovimiento = LocalDateTime.now();
    }
}
