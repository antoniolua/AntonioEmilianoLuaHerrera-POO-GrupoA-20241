package FigurasGeometricas;

public class Rectangle implements Shape{
    private float base;
    private float height;

    public Rectangle(float base, float height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void area() {
        System.out.println("Area of the rectangle");
        float area = base * height;
        System.out.println(area);
    }

    @Override
    public void perimeter() {
        System.out.println("Perimeter of the rectangle");
        float perimeter = 2 * (base + height);
        System.out.println(perimeter);
    }
}
