abstract class Payment {
    public abstract void refund(double amount);
}
class CreditCardPayment extends Payment {
    
    public void refund(double amount) {
        System.out.println("Refunded");
    }
}
class CryptoPayment extends Payment {
    
    public void refund(double amount) {
        throw new UnsupportedOperationException("non-refundable"); //crypto is usually not refundable
    }
}
public class Paymentapp {
    public static void processRefund(Payment payment) {
        payment.refund(500); // Runtime failure
    }

    public static void main(String[] args) {
        processRefund(new CreditCardPayment());
        processRefund(new CryptoPayment()); // LSP violation
    }
}
