package productos;

public class Electrodomestico extends Producto {
    private String marca;

    public Electrodomestico(String nombre, float precio, String fechaImportacion, int numeroSerie, int stock, String marca) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
}
