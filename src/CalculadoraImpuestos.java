public class CalculadoraImpuestos {

    public double calcularImpuestos(int ingresos){

        System.out.print("Los ingreson son: ");
        return (ingresos+0.15);
    }
    public double calcularImpuestos(int ingresos,double porcentajeImpuestos){

        System.out.print("Las ventas mas el impuesto es de: ");
        return ingresos*(porcentajeImpuestos/100);
    }

    public double calcularImpuestos(double dividendos,double porcentajeImpuestos,double extencion){

        double impuestos;
        impuestos=dividendos*(porcentajeImpuestos/100);
        if (impuestos>extencion){
            System.out.print("Los impuestos son: ");
            return impuestos-extencion;
        }
        System.out.print("Los impuestos son: ");
        return 0;
    }
}
