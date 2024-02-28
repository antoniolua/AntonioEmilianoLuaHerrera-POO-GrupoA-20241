import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       /* Scanner leer = new Scanner(System.in);

        System.out.println("Digiste el primer lado: ");
        int lado1= leer.nextInt();
        System.out.println("Digiste el segundo lado: ");
        int lado2= leer.nextInt(); */

        int lado1= 20, lado2=20;
        double lado3=20.5, lado4=20.5;
        Rectangulo rectangulo1= new Rectangulo();
        System.out.println( "El area es: "+rectangulo1.calcularArea(lado1,lado2));
        System.out.println("El perimetro es: "+rectangulo1.calcularPerimetro(lado1,lado2));

        Rectangulo rectangulo2 = new Rectangulo();
        System.out.println( "El area es: "+rectangulo2.calcularArea(lado3,lado4));
        System.out.println("El perimetro es: "+rectangulo2.calcularPerimetro(lado3,lado4));

        System.out.println("*******************************************************");
        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();
        Empleado empleado3 = new Empleado();
        System.out.println(empleado1.CalcularSalario(2000));
        System.out.println(empleado2.CalcularSalario(2000,200,20));
        System.out.println(empleado3.CalcularSalario(1500,200));

        System.out.println("*******************************************************");
        CalculadoraImpuestos cal1 = new CalculadoraImpuestos();
        CalculadoraImpuestos cal2 = new CalculadoraImpuestos();
        CalculadoraImpuestos cal3 = new CalculadoraImpuestos();

        System.out.println(cal1.calcularImpuestos(200));
        System.out.println(cal2.calcularImpuestos(200,15));
        System.out.println(cal3.calcularImpuestos(2000,10,50));


    }
}
