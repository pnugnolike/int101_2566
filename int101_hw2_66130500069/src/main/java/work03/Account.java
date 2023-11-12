package work03;

import java.util.Objects;

import work01.Utilitor;
import work02.Person;

public class Account {
    private static long nextNo = 100_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null)
            throw new NullPointerException("can't null");

        while (true) {
            long result = Utilitor.computeIsbn10(nextNo);
            while (result == 10) {
                nextNo++;
                result = Utilitor.computeIsbn10(nextNo);
            }
            this.no = 10 * nextNo + result;
            nextNo++;
            break;
        }
        this.owner = owner;
        this.balance = 0.0;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        Utilitor.testPositive(amount);
        return this.balance += amount;
    }

    public double withdraw(double amount) {
        Utilitor.testPositive(amount);
        this.balance -= amount;
        Utilitor.testPositive(balance);
        return balance;
    }

    public void transfer(double amount, Account account) {
        if (account == null)
            throw new IllegalArgumentException("Account cannot be null");
        withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        final StringBuilder acc = new StringBuilder("Account{");
        acc.append("no=").append(no);
        acc.append(", owner=").append(owner);
        acc.append(", balance=").append(balance);
        acc.append('}');
        return acc.toString();
    }

    @Override
    public boolean equals(Object objE) {
        if (this == objE)
            return true;
        if (objE == null || getClass() != objE.getClass())
            return false;
        Account account = (Account) objE;
        return no == account.no && Double.compare(balance, account.balance) == 0
                && Objects.equals(owner, account.owner);
    }
}
