interface Refundable {
    void refund(double amount);
}
class CreditCardPayment implements Refundable {
    
    public void refund(double amount) {
        System.out.println("Refunded");
    }
}
class CryptoPayment {
    public void transfer(double amount) {
        System.out.println("Transferred");
    }
}
public class PaymentappLSP {
    public static void processRefund(Refundable payment) {
        payment.refund(500);
    }

    public static void main(String[] args) {
        processRefund(new CreditCardPayment());
    }
}
