import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*Employee person1=new Employee("Antonio", "Lua", 265720, 'A');
       Employee person2=new Employee("Jose", "Perez", 264557, 'B');
        Employee person3=new Employee("Jesus", "Medina", 264557, 'C');*/


        Bank clientes=new Bank();
        Scanner leer = new Scanner(System.in);
        Random ran = new Random();
        boolean aux=true;
        Employee person=null;
        int opc=-1;

        while (opc!=0) {
            System.out.println("\nMENU");
            System.out.println();
            System.out.println("1. Create Account");
            System.out.println("2. Add Money ");
            System.out.println("3. Withdraw Money ");
            System.out.println("4. Account");
            System.out.println("5. Change account");
            System.out.println("0. Exit\n");
            opc =leer.nextInt();
            leer.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("1. Create Account");
                    System.out.print("Name: ");
                    String Name=leer.nextLine();
                    System.out.print("Last Name: ");
                    String LastName=leer.nextLine();
                    System.out.print("Account: ");
                    long AccountNumber = (long) (ran.nextDouble() * 9000000L) + 1000000L;
                    System.out.println(AccountNumber);
                    System.out.println("Type Account, A,B o C");
                    char type=leer.next().charAt(0);
                    person=new Employee(Name,LastName,AccountNumber,type);
                    clientes.addEmploye(person);
                    clientes.viewPerson();
                    break;
                case 2:
                    System.out.println("Enter the amount to be entered");
                    double amount = leer.nextDouble();
                    person.getAccount().addMoney(amount);

                    break;
                case 3:
                    System.out.println("Amount to withdraw");
                    double amountWithdraw = leer.nextDouble();
                    person.getAccount().withdrawals(amountWithdraw);
                    break;
                case 4:
                    System.out.println("1. View an account ");
                    System.out.println("2. See all account");
                    opc =leer.nextInt();
                    leer.nextLine();
                    switch (opc){
                        case 1:
                            System.out.println("Tell me your Name");
                            String name=leer.nextLine();
                            System.out.println("Tell me your last name");
                            String apellido=leer.nextLine();
                            clientes.viewOnePerson(name,apellido);
                            break;
                        case 2:
                            System.out.println("Cuentas: ");
                            clientes.viewPerson();
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }

                    break;
                case 5:
                    System.out.println("Tell me your Name");
                    String name2=leer.nextLine();
                    System.out.println("Tell me your last name");
                    String apellido2=leer.nextLine();
                    clientes.viewOnePerson(name2,apellido2);
                    System.out.println("A que cuenta deseas cambiarte");
                    int numero=leer.nextInt();
                    int in=  clientes.searchAccount(numero);
                    person = Bank.list.get(in);

                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }


    }
}