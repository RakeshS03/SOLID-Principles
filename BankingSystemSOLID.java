// ISP
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
}

interface AlertService {
    void send(String message);
}

//LSP + OCP
class SavingsAccount implements Account {
    private double balance = 5000;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
        System.out.println("Savings balance: " + balance);
    }
}

class CurrentAccount implements Account {
    private double balance = 10000;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Current balance: " + balance);
    }
}

//SRP
class SMSAlertService implements AlertService {
    public void send(String message) {
        System.out.println("SMS Alert: " + message);
    }
}

// DIP
class BankService {
    private Account account;
    private AlertService alert;

    public BankService(Account account, AlertService alert) {
        this.account = account;
        this.alert = alert;
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
        alert.send("Amount withdrawn: " + amount);
    }
}
public class BankingSystemSOLID {
    public static void main(String[] args) {
        BankService service =
            new BankService(
                new SavingsAccount(),
                new SMSAlertService()
            );

        service.withdraw(2000);
    }
}
