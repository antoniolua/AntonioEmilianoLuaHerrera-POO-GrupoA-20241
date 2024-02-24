public class Rectangulo {
    double ancho;
    double altura;

    public Rectangulo(double ancho,double altura){
        this.ancho = ancho;
        this.altura = altura;
    }
    public double calcularArea() {
        return ancho * altura;
    }

    public double calcularPerimetro() {
        return 2 * (ancho + altura);
    }

    public void Mostrar(){
        System.out.println("El area es: "+calcularArea());
        System.out.println("El perimetro es: "+calcularPerimetro());
    }
}
