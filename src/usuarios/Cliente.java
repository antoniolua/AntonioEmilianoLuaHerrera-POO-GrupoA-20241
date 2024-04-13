package usuarios;

import productos.Producto;
import tienda.Tienda;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    private String name;
    private String apellido;
    private int edad;
    private ArrayList<String> compras;

    public Cliente(String name, String apellido, int edad) {
        this.name = name;
        this.apellido = apellido;
        this.edad = edad;
        this.compras = new ArrayList<>();
    }
    public void anadirProducto(Producto producto, LocalDate fecha) {
        String detalleCompra = producto.getNombre() + ", " +
                "Precio: " + producto.getPrecio() + ", " +
                "Fecha de Importación: " + producto.getFechaImportacion() + ", " +
                "Cantidad en stock: " + producto.getStock() + ", " +
                "Número de serie: " + producto.getNumeroSerie() + ", " +
                "Fecha de compra: " + fecha;
        compras.add(detalleCompra);
    }
    public  void mostrarCompras(){
        for (int i = 0; i < compras.size(); i++) {
            String detalleCompra= compras.get(i);
            System.out.println((i+1)+"- "+detalleCompra);
        }
    }

    public String getName() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public ArrayList<String> getCompras() {
        return compras;
    }
}
