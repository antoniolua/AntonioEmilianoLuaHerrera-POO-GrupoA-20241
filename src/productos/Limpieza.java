package productos;

public class Limpieza extends Producto {
    private String aroma;


    public Limpieza(String nombre, float precio, String fechaImportacion, int numeroSerie, int stock, String aroma) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.aroma = aroma;
    }

    public String getAroma() {
        return aroma;
    }
}
