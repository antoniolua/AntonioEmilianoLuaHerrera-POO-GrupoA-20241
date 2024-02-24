public class Main {
    public static void main(String[] args) {
        Persona Persona1 = new Persona("Sofia Medina Rodriguez",21,"Femenino");
        Persona1.Mostar();
        System.out.println("******************************");
        Persona Persona2 = new Persona("Antonio Lua Herrera",18,"Masculino");
        Persona2.Mostar();
        System.out.println("******************************");
        Persona Persona3 = new Persona("Alejandro Ayala Ixta",18,"Masculino");
        Persona3.Mostar();
        System.out.println("******************************");
        Persona Persona4 = new Persona("Michelle Prado Herrera",20,"Femenino");
        Persona4.Mostar();
        System.out.println("******************************");


        libro libro1 = new libro();
        libro1.Mostrar();
        System.out.println("******************************");
        libro libro2 = new libro();
        libro2.titulo = "Cien años de soledad";
        libro2.autor = "Gabriel García Márquez";
        libro2.ano = 1967;
        libro2.Mostrar();
        System.out.println("******************************");
        libro libro3 = new libro();
        libro3.titulo = "Harry Potter y la piedra filosofal";
        libro3.autor = "J.K. Rowling";
        libro3.ano = 1997;
        libro3.Mostrar();
        System.out.println("******************************");
        libro libro4 = new libro();
        libro4.titulo = "1984";
        libro4.autor = "George Orwell";
        libro4.ano = 1949;
        libro4.Mostrar();
        System.out.println("******************************");

        Rectangulo Rectangulo1 = new Rectangulo(5, 10);
        Rectangulo1.Mostrar();
        System.out.println("******************************");
        Rectangulo Rectangulo2 = new Rectangulo(8, 15);
        Rectangulo2.Mostrar();
        System.out.println("******************************");
        Rectangulo Rectangulo3 = new Rectangulo(6, 12);
        Rectangulo3.Mostrar();
        System.out.println("******************************");
        Rectangulo Rectangulo4 = new Rectangulo(2, 4);
        Rectangulo4.Mostrar();
        System.out.println("******************************");

    }
}