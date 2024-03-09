
public class BankAccount {
    private long accountNumber;
    private double amount;
    private char accountType;
    private  Employee employee;


    public BankAccount(long accountNumber,char accountType){
        this.accountType=accountType;
        this.accountNumber=accountNumber;
    }

    public BankAccount() {

    }

    public void setAccountType(char accountType ) {
        this.accountType = accountType;

    }
    public char getAccountType(){
        return accountType;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void addMoney(double amount){
        if (accountType=='A') addMoneyA(amount);
        else if (accountType=='B') addMoneyB(amount);
        else this.amount+=amount;

    }
    public void addMoneyA(double amount){

        if (this.amount + amount<=50000){
            this.amount += amount;
        }
        else {
            System.out.println("No puedes tener mas de 50000 en esta cuenta");
        }
    }
    public void addMoneyB(double amount){
        if (this.amount + amount<=100000){
            this.amount += amount;
        }
        else {
            System.out.println("No puedes tener mas de 100000 en esta cuenta");
        }
    }

    public void withdrawals(double amount){
        if (accountType=='A') withdrawalsA(amount);
        else if (accountType=='B')  withdrawalsB(amount);
        else if (accountType=='C')  withdrawalsC(amount);
    }
    public void  withdrawalsA(double amount){
        if (this.amount -amount>=1000){
            this.amount -= amount;
        }
        else {
            System.out.println("Saldo minimo de 1000");
        }
    }
    public void  withdrawalsB(double amount){
        if (this.amount -amount>=5000){
            this.amount -= amount;
        }
        else {
            System.out.println("Saldo minimo de 5000");
        }
    }
    public void  withdrawalsC(double amount){
        if (this.amount -amount>=10000){
            this.amount -= amount;
        }
        else {
            System.out.println("Saldo minimo de 10000");
        }
    }

}