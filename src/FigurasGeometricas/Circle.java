package FigurasGeometricas;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public void area() {
        System.out.println("Area of the circle");
        double area = Math.PI * radius * radius;
        System.out.println(area);
    }
    @Override
    public void perimeter() {
        System.out.println("Perimeter of the circle");
        double perimeter = 2 * Math.PI * radius;
        System.out.println(perimeter);
    }
}
