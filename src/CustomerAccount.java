

public class CustomerAccount {
    private String cus_Name;
    private int acc_No;
    private double balance;

    public CustomerAccount(String cusName, int accNo, double balance) {
        cus_Name = cusName;
        acc_No = accNo;
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) throws WithdrawException, BalanceBelow100Exception {
        if (amount < 0) {
            return false;
        }

        if (amount > balance) {
            throw new WithdrawException("Withdraw amount exceeds the balance.");
        }

        if (balance - amount < 100) {
            throw new BalanceBelow100Exception("Balance will be below $100 after withdrawal.");
        }

        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        CustomerAccount account = new CustomerAccount("John Doe", 123456, 500.0);

        try {
            account.deposit(100);
            System.out.println("Balance after deposit: $" + account.getBalance());

            account.withdraw(200);
            System.out.println("Balance after withdrawal: $" + account.getBalance());

            account.withdraw(400);
            System.out.println("Balance after withdrawal: $" + account.getBalance());
        } catch (WithdrawException | BalanceBelow100Exception e) {
            System.out.println(e.getMessage());
        }
    }
}