package work04;

public class BankAccount {
    private int number;
    private Person owner;
    private double balance;

    public BankAccount(int number, Person owner){
        this.owner = owner;
        this.number = number;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double withdraw(double amount){
        balance = getBalance() - amount;
        return balance;
    }
    public void tranfer(double amount,BankAccount account){
        this.withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString(){
        return "Bankaccount{" + owner.getId() + "}";
    }


    public double deposit(double amount) {
        balance = getBalance() + amount;
        return balance;
    }

}