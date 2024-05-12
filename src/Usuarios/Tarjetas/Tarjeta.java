package Usuarios.Tarjetas;

import Utils.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public abstract class Tarjeta{

    Random rand = new Random();
    protected final String nombre;
    protected final long numero;
    protected final LocalDate fechaCreacion;
    protected final int cvv;
    protected final int claveInterbancaria;
    protected final LocalDate fechaVencimiento;
    protected LocalDateTime fechaUltimoMovimiento;
    protected final String tipo;

    public Tarjeta(String nombre, String apellido, String tipo) {
        this.nombre = nombre+" "+apellido;
        this.numero = Utils.obtenerNumeroTarjeta();
        this.fechaCreacion = LocalDate.now();
        this.cvv = rand.nextInt(900)+100;
        this.claveInterbancaria = rand.nextInt(9000)+1000;
        this.fechaVencimiento = this.fechaCreacion.plusYears(5);
        this.fechaUltimoMovimiento = LocalDateTime.now();
        this.tipo = tipo;
    }

    public abstract boolean verificarCodigo();


    // Getters
    public String getNombre() {
        return nombre;
    }

    public long getNumero() {
        return numero;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public int getCvv() {
        return cvv;
    }

    public int getClaveInterbancaria() {
        return claveInterbancaria;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public LocalDateTime getFechaUltimoMovimiento() {
        return fechaUltimoMovimiento;
    }

    public String getTipo() {
        return tipo;
    }
}
