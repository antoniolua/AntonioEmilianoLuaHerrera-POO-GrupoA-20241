package FigurasGeometricas;

public class Square implements  Shape{
    private float side;


    public Square(float side) {
        this.side = side;
    }

    @Override
    public void area() {
        System.out.println("Area of the square");
        float result = side * side;
        System.out.println(result);
    }

    @Override
    public void perimeter() {
        System.out.println("Perimeter of the square");
        float result = side + side + side + side;
        System.out.print(result);
    }
}
