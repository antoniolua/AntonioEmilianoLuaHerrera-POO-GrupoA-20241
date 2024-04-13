package productos;

public class Producto {
    private static int cantidad_producto=1;
    private int id;
    private String nombre;
    private float precio;
    private String fechaImportacion;
    private int numeroSerie;
    private int stock;
    private boolean comprado;

    public Producto(String nombre, float precio, String fechaImportacion, int numeroSerie, int stock) {
        this.id= cantidad_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.numeroSerie = numeroSerie;
        this.stock = stock;
        this.comprado = false;
        cantidad_producto++;
    }

    public Producto() {

    }

    public static int getCantidad_producto() {
        return cantidad_producto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public String getFechaImportacion() {
        return fechaImportacion;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public int getStock() {
        return stock;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado() {
        this.comprado = true;
    }
    public void removerStock(int num){
        this.stock -=num;
    }
    public  void añadirStock(int num){
        this.stock +=num;
    }
}
