import java.util.ArrayList;
import java.util.Random;

public class Usuario{
    private String nombre;
    private int id;
    private int edad;
    private boolean CompradoBook;
    Random ran = new Random();

    public Usuario(String nombre,int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.id = ran.nextInt(1000)+1 ;
        this.CompradoBook=false;
    }

    public Usuario() {

    }

    public boolean getCompradoBook() {
        return CompradoBook;
    }
    public void setCompradoBook(boolean CompradoBook) {
       this.CompradoBook=CompradoBook;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

}
