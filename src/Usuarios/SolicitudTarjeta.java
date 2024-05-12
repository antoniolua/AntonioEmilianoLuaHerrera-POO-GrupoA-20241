package Usuarios;

import Usuarios.Tarjetas.Credito;
import Usuarios.Utils.Sucursal;
import java.time.LocalDate;


public class SolicitudTarjeta {
    private Cliente cliente;
    private String tipo;
    private String estatus;
    private LocalDate fecha;
    private double saldo;
    private Sucursal sucursal;

    SolicitudTarjeta(Cliente cliente, String tipo) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.saldo = cliente.getTarjetaDebito().getSaldo();
        this.estatus = "En proceso";
        this.fecha = LocalDate.now();
        this.sucursal = cliente.getSucursal();

        cliente.getSolicitudTarjetas().add(this);
    }

    public void aprobarSolicitud() {
        cliente.getTarjetasCredito().add(new Credito(cliente.getNombre(), cliente.getApellido(), tipo));
        this.estatus = "Aprobada";
    }

    public void rechazarSolicitud() {
        this.estatus = "Rechazada";
    }

    public void mostrarSolicitud() {
        System.out.println("Usuario de solicitante: " + cliente.getUsuario());
        System.out.println("Nombre de solicitante: " + cliente.getNombre() + cliente.getApellido());
        System.out.println("Estatus: " + estatus);
        System.out.println("Saldo en tarjeta de debito al generar solicitud: $" + saldo);
        System.out.println("Tipo de tarjeta que solicita: " + tipo);
        System.out.println("Fecha de solicitud: " + fecha);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstatus() {
        return estatus;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getSaldo() {
        return saldo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }
}
