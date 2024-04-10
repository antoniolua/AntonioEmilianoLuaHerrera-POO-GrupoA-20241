package productos;

public class Belleza extends Producto {
    private String tonoPiel;

    public Belleza(String nombre, float precio, String fechaImportacion, int numeroSerie, int stock, String tonoPiel) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.tonoPiel = tonoPiel;
    }

    public String getTonoPiel() {
        return tonoPiel;
    }
}
