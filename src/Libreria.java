import java.util.ArrayList;

public class Libreria {

    public static ArrayList<Usuario> listUser = new ArrayList<>();
    public  ArrayList<Libro> listBook = new ArrayList<>();



    public void agregarUsuario(Usuario usuario){
        listUser.add(usuario);
    }
    public void agregarLibro(Libro libro){
        listBook.add(libro);
    }
    public void mostrarUser(){
        System.out.println("***Usuarios***");
        for (int i = 0; i < listUser.size(); i++) {
            System.out.println("Usuario "+(i+1));
            System.out.println("Nombre: "+listUser.get(i).getNombre()+", edad "+listUser.get(i).getEdad());
            System.out.println();
        }
    }

    public void  librosDisponibles(){
        System.out.println("Libros disponibles");
        for (int i = 0; i < listBook.size(); i++) {
                if (listBook.get(i).getEsRentado()==false && listBook.get(i).getEsComprado()==false) {
                    System.out.println("Nombre: "+listBook.get(i).getNombre()+", Autor: "+listBook.get(i).getAutor());
                }
        }
        System.out.println();
    }
    public void rentarBook(String name, String autor){
        for (int i = 0; i <listBook.size(); i++) {
            Libro libro= listBook.get(i);
            if (libro.getNombre().equals(name) && libro.getAutor().equals(autor) && listBook.get(i).getEsRentado()==false) {
                System.out.println("***Libro Rentado Correctamente***");
                libro.setEsRentado(true);
                break;
            }
           //datos erroneos faltan
        }
    }
    public void comprarBooks(String name, String autor){
        for (int i = 0; i <listBook.size(); i++) {
            Libro libro= listBook.get(i);

            if (libro.getNombre().equals(name) && libro.getAutor().equals(autor) && listBook.get(i).getEsComprado()==false) {
                System.out.println("***Libro Comprado Correctamente***");
                libro.setEsComprado(true);
                listUser.get(i).setCompradoBook(true);
                break;
            }
            //datos erroneos faltan
        }
    }

    public void booksRentados(){

        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getEsRentado()==true) {
                System.out.println("Nombre: "+listBook.get(i).getNombre()+", Autor: "+listBook.get(i).getAutor());
            }
        }
        System.out.println();
    }
    public void booksComprados(){
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getEsComprado()==true) {
                System.out.println("Nombre: "+listBook.get(i).getNombre()+", Autor: "+listBook.get(i).getAutor());
            }
        }
        System.out.println();
    }

    public void personasCompradoBooks(){
        for (int i = 0; i <listUser.size(); i++) {
            if (listUser.get(i).getCompradoBook()){
                System.out.println("Nombre: "+listUser.get(i).getNombre()+", edad "+listUser.get(i).getEdad());
            }
        }
    }
    public int cambiarcuenta(String name){
        int cont=0;
        for (int i = 0; i <listUser.size(); i++) {
            if (listUser.equals(name)) {
                cont=i;
            }
        }
        System.out.println("Se cambio al usuarion "+name);
        return cont;
    }

}
