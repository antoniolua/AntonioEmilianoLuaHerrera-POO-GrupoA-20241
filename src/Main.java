public class Main {
    public static void main(String[] args) {

        Producto producto1=new Producto("Ipad",5000, 20);
        System.out.println("El nombre es: "+producto1.getNombre()+"\nEl precio es: "+producto1.getPrecio()+"\nEl stock es: "+producto1.getStock());

        System.out.println(producto1.reducirStock(10));

        System.out.println("****************************************");
        Producto producto2=new Producto("Macbook",20000 );
        System.out.println("El nombre es: "+producto2.getNombre()+"\nEl precio es: "+producto2.getPrecio()+"\nEl stock es: "+producto2.getStock());

        System.out.println(producto2.aumentarStock(10));

        System.out.println("****************************************");
        Producto producto3=new Producto();
        producto3.setNombre("Iphone");
        producto3.setPrecio(3000);
        producto3.setStock(10);

        System.out.println("El nombre es: "+producto3.getNombre()+"\nEl precio es: "+producto3.getPrecio()+"\nEl stock es: "+producto3.getStock());


    }
}
