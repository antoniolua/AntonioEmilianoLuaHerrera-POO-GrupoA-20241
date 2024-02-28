public class Empleado {

    public int CalcularSalario(int sueldo){
        System.out.print("El sueldo es: ");
        return sueldo;
    }
    public int CalcularSalario(int sueldo,int bonificacion){
        System.out.print("El sueldo + la bonificacion es : ");
        return sueldo+bonificacion;
    }
    public int CalcularSalario(int sueldo,int bonificacion, int horas){
        System.out.print("El sueldo + la bonificacion + las horas extras es : ");
        return (sueldo+bonificacion)+(horas*20);
    }

}
