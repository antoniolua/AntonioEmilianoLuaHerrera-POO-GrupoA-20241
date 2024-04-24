import FigurasGeometricas.Circle;
import FigurasGeometricas.Rectangle;
import FigurasGeometricas.Square;
import FigurasGeometricas.Triangle;

public class Main {
    public static void main(String[] args) {

        Circle circle=new Circle(3);
        circle.area();
        circle.perimeter();
        System.out.println();


        Rectangle rectangle=new Rectangle(2,4);
       rectangle.area();
       rectangle.perimeter();
        System.out.println();

        Square  square=new Square(2);
        square.area();
        square.perimeter();
        System.out.println();
        System.out.println();

        Triangle triangle=new Triangle(3,4,3,3);
        triangle.area();
        triangle.perimeter();


    }
}
