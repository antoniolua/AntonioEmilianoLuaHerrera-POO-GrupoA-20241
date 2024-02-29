public class Producto {
    private String nombre;
    private float precio;
    private int stock;

    public Producto(String nombre, float precio, int stock){
        this.nombre=nombre;
        this.precio=precio;
        this.stock=stock;
    }
    public Producto(String nombre, float precio){
        this.nombre=nombre;
        this.precio=precio;
        stock=0;
    }
    public Producto(){

    }
    //setter
    public void setNombre(String nombre) {
        if (nombre!= null) {
            this.nombre = nombre;
        }
        else {
            System.out.println("El nombre no puede ser nulo");
        }
    }
    public void setPrecio(float precio) {
        if (precio>=0) {
            this.precio = precio;
        }
        else {
            System.out.println("El precio no puede ser menor a 0");
        }
    }
    public void setStock(int stock) {
        if (stock>=0) {
            this.stock = stock;
        }
        else {
            System.out.println("El stock no puede ser menor a 0");
        }
    }
    //getter
    public String getNombre() {
        return nombre;
    }
    public float getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }

    //metodos adicionales
    public int aumentarStock(int cantidad){
        if (cantidad>=1){
            System.out.print("El nuevo stock es de: ");
          return  (stock = stock+cantidad);
        }
        else {
           System.out.println("La cantidad debe ser mayor que cero");
            System.out.print("El stock sigue siendo de: ");
            return stock;
        }

    }
    public int reducirStock(int cantidad){
        if (cantidad>0 && cantidad<=stock){
            System.out.print("El nuevo stock es de: ");
           return stock=stock-cantidad;
        }
        else {
            System.out.println("La cantidad a reducir debe ser mayor que cero y menor o igual al stock actual.");
        }
        System.out.print("El stock sigue siendo de: ");
        return stock;
    }
}
