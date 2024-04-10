package productos;

public class Alimentos extends Productos{
    private String fechaCaducidad;
    public Alimentos(String nombre, float precio, String fechaImportacion, int numeroSerie, String fechaCaducidad) {
        super(nombre, precio, fechaImportacion, numeroSerie);
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
}
