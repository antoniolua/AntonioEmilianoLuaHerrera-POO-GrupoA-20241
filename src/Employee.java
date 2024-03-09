
import java.util.ArrayList;

public class Employee {
    private String name;
    private String lastName;
    private BankAccount account;
    private Bank bank;


    //public ArrayList<Employee> list = new ArrayList<>();

    public Employee(String name, String lastName, long accountNumber, char accountType) {
        if (accountType != 'A' && accountType != 'B' && accountType != 'C') {
            System.out.println("Tipo de cuenta no permitido");

            return;
        }
        this.account = new BankAccount(accountNumber, accountType);
        //   Bank.addEmploye(this);
        this.name = name;
        this.lastName = lastName;
        System.out.println("***Usuario registrado con exito***");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BankAccount getAccount() {
        return account;
    }

    public Bank getBank() {
        return bank;
    }
}
