import java.util.ArrayList;

public class Libreria {

    public  ArrayList<Usuario> listUser = new ArrayList<>();
    public  ArrayList<Libro> listBook = new ArrayList<>();
    public Libro libro;

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
        for (int i = 0; i < listBook.size(); i++) {
                if (listBook.get(i).getEsRentado()==false) {
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
            else {
                System.out.println("Datos erroneos");
               break;
            }
        }
    }


}
