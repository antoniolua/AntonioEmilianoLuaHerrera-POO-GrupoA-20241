package productos;

public class Productos {
    private static int cantidad_producto=1;
    private int id;
    private String nombre;
    private float precio;
    private String fechaImportacion;
    private int numeroSerie;
    private int stock;

    public Productos(String nombre,float precio, String fechaImportacion, int numeroSerie,int stock) {
        this.id= cantidad_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.numeroSerie = numeroSerie;
        this.stock = stock;
        cantidad_producto++;
    }


}
