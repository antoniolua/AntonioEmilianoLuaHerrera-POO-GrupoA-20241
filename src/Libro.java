import java.util.Random;

public class Libro {
    private String nombre;
    private int id;
    private String autor;
    private  boolean EsRentado;
    private boolean EsComprado;
    Random ran=new Random();

    public Libro(String nombre,String autor){
        this.nombre=nombre;
        this.id= ran.nextInt(1000)+1;
        this.autor=autor;
        this.EsRentado=false;
        this.EsComprado=false;
    }

    public boolean getEsComprado() {
        return EsComprado;
    }

    public void setEsComprado(boolean esComprado) {
        this.EsComprado = esComprado;
    }

    public boolean getEsRentado() {
        return EsRentado;
    }

    public void setEsRentado(boolean esRentado) {
        this.EsRentado = esRentado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }
}
