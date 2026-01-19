class PaymentProcessor {
    public double process(double amount) {
        return amount;
    }
}
class miniPaymentProcessor extends PaymentProcessor {
    public double process(double amount) {
        if (amount > 10000) return 10000; // Silent clamp
        return amount;
    }
}
public class Clamping {
    public static void main(String[] args) {
        PaymentProcessor p = new miniPaymentProcessor();
        System.out.println(p.process(20000)); // Unexpected behavior
    }
}
