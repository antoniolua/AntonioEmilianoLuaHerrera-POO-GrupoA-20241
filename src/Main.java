import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        Usuario usuario=null;
        Libreria libreria=new Libreria();
        Libro libro=null;
        boolean aux=true;
        while (aux) {
            System.out.println("\nBIENVENIDO A LA LIBRERIA\n");
            System.out.println("Elige una opción para continuar");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Añadir libro");
            System.out.println("3. Mostrar Usuarios");
            System.out.println("4. Mostrar Libros");
            System.out.println("5. Rentar Libro O Comprar");
            System.out.println("6. Mostrar Libros Rentados O Comprados");
            System.out.println("7. Usuarios con libros comprados");
            System.out.println("8. Salir");
            int opc=leer.nextInt();
            leer.nextLine();
            switch (opc) {
                case 1:
                    System.out.println("Elegiste la opción 1");
                    System.out.print("Ingresa el nombre del usuario: ");
                    String name =leer.nextLine();
                    System.out.print("Ingresa la edad del usuario: ");
                    int edad = leer.nextInt();
                    usuario = new Usuario(name, edad);
                    libreria.agregarUsuario(usuario);
                    System.out.println("***El usuario " + name + " ha sido regitrado***");
                    break;
                case 2:
                    System.out.println("Elegiste la opción 2");
                    System.out.print("Ingresa el nombre del libro: ");
                    String nombre =leer.nextLine();
                    System.out.print("Ingresa el autor del libro: ");
                   String autor=leer.nextLine();
                    libro = new Libro(nombre,autor);
                    libreria.agregarLibro(libro);
                    System.out.println("***El libro " + nombre + " ha sido regitrado***");
                    break;
                case 3:

                    System.out.println("Elegiste la opción 3");
                    System.out.println("Se mostrarán los usuarios");
                    libreria.mostrarUser();
                    break;
                case 4:
                    System.out.println("Elegiste la opción 4");
                    System.out.println("Se mostrarán los Libros");
                    System.out.println("***Libros***");
                   libreria.librosDisponibles();
                    break;
                case 5:
                    System.out.println("\nElegiste la opción 5\n");
                    System.out.println("1.Renta de libros");
                    System.out.println("2.Compra de libros");
                    int opcion = leer.nextInt();
                    leer.nextLine();
                    if (opcion==1){
                    System.out.println("***Renta de libros**");
                    libreria.mostrarUser();
                    System.out.print("Ingresa el nombre del Usuario: ");
                    String user= leer.nextLine();
                    leer.nextLine();
                    int us= libreria.cambiarcuenta(user);
                    Libreria.listUser.get(us);
                    libreria.librosDisponibles();
                    System.out.print("Ingresa el nombre del libro: ");
                    String rentNombre =leer.nextLine();
                    System.out.print("Ingresa el autor del libro: ");
                    String rentAutor=leer.nextLine();
                    libreria.rentarBook(rentNombre,rentAutor);

                    } else if (opcion==2) {
                        System.out.println("***Compra de libros**");
                        libreria.mostrarUser();
                        System.out.print("Ingresa el nombre del Usuario: ");
                        String user= leer.nextLine();
                        leer.nextLine();
                        int us= libreria.cambiarcuenta(user);
                        Libreria.listUser.get(us);
                        libreria.librosDisponibles();
                        System.out.print("Ingresa el nombre del libro: ");
                        String comNombre =leer.nextLine();
                        System.out.print("Ingresa el autor del libro: ");
                        String comAutor=leer.nextLine();
                        libreria.comprarBooks(comNombre,comAutor);
                    }
                    break;
                case 6:
                    System.out.println("\nElegiste la opción 6\n");
                    System.out.println("***Libros Rentados***");
                    libreria.booksRentados();
                    System.out.println("***Libros Comprados***");
                    libreria.booksComprados();

                    break;
                case 7:
                    System.out.println("\nElegiste la opción 7\n");
                    System.out.println("***Personas con libros comprados***");
                    libreria.personasCompradoBooks();
                    break;
                case 8:

                    aux=false;
                    break;

            }
        }
    }
}
