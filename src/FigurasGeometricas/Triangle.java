package FigurasGeometricas;

public class Triangle extends Shape {
    private float base;
    private float height;
    private float side1;
    private float side2;

    public Triangle(float base, float height, float side1, float side2) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public void area() {
        System.out.println("Area of the triangle");
        float area = (base * height)/2;
        System.out.println(area);
    }
    @Override
    public void perimeter() {

        float perimeter = base + side1+side2;
        System.out.println(perimeter);
    }
}
