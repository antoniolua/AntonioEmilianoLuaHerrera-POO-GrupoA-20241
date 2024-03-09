
import java.util.ArrayList;

public class Bank {
    public Employee employee;
    public static ArrayList<Employee> list = new ArrayList<>();

    public   void addEmploye(Employee employee){
        list.add(employee);
    }
    public  void viewPerson(){
        for (int i = 0; i < list.size(); i++) {
            System.out.print("El numero de cuenta del empleado "+list.get(i).getName()+" es "+list.get(i).getAccount().getAccountNumber()+", su saldo es "+list.get(i).getAccount().getAmount()+" y la cuenta es de tipo "+list.get(i).getAccount().getAccountType());

            System.out.println();
        }
    }
    public   void viewOnePerson(String name,String apellido){
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            if (employee.getName().equals(name) && employee.getLastName().equals(apellido)) {
                System.out.println("*** Cuenta "+(i+1)+"***");
                System.out.println((i+1)+"- El numero de cuenta del empleado "+list.get(i).getName()+" es "+list.get(i).getAccount().getAccountNumber()+", su saldo es "+list.get(i).getAccount().getAmount()+" y la cuenta es de tipo "+list.get(i).getAccount().getAccountType());
            }
        }
    }
    public int searchAccount(int numero) {
        System.out.println("Change Correct");
        return (numero-1);


    }

}