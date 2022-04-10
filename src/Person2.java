import java.util.List;

public class Person2 {
    String name;
    List<BankAccount2>bankAccounts;

    public Person2(String name, List<BankAccount2> bankAccounts) {
        this.name = name;
        this.bankAccounts = bankAccounts;
    }

    public String getName() {
        return name;
    }

    public List<BankAccount2> getBankAccounts() {
        return bankAccounts;
    }
}
