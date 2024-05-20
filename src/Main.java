import Biblioteca.Biblioteca;
import Biblioteca.Menu;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(true);
        biblioteca.guardarEnJSON();
        Menu menu = new Menu();
        menu.iniciarSesion();



    }
}