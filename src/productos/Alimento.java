package productos;

public class Alimento extends Producto {
    private String fechaCaducidad;

    public Alimento(String nombre, float precio, String fechaImportacion, int numeroSerie, int stock, String fechaCaducidad) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
}
