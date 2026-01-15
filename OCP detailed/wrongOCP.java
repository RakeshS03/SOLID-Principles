public class wrongOCP {
    public static void main(String[] args) {
        InterestCalculator calculator = new InterestCalculator();
        calculator.calculateInterest("SAVINGS", 10000);
    }
}

class InterestCalculator {

    public void calculateInterest(String accountType, double amount) {

        if (accountType.equals("SAVINGS")) {
            System.out.println("Interest: " + (amount * 0.04));
        } else if (accountType.equals("CURRENT")) {
            System.out.println("Interest: " + (amount * 0.02));
        }
    }
}
