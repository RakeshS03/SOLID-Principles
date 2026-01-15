public class correctOCP {
    public static void main(String[] args) {

        InterestPolicy savings = new SavingsAccountInterest();
        InterestPolicy current = new CurrentAccountInterest();

        InterestService service = new InterestService();

        service.calculate(savings, 10000);
        service.calculate(current, 10000);
    }
}
   //ABSTRACTION
interface InterestPolicy {
    double calculate(double amount);
}
class SavingsAccountInterest implements InterestPolicy {
    public double calculate(double amount) {
        return amount * 0.04;
    }
}

class CurrentAccountInterest implements InterestPolicy {
    public double calculate(double amount) {
        return amount * 0.02;
    }
}


   //STABLE POLICY

class InterestService {

    public void calculate(InterestPolicy policy, double amount) {
        System.out.println("Interest: " + policy.calculate(amount));
    }
}
