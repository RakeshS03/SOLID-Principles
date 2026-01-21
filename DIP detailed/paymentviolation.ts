class PayPalService {
  pay(amount: number) {
    console.log("paid using PayPal:", amount);
  }
}

class paymentservice {
  private payment = new PayPalService();

  checkout(amount: number) {
    this.payment.pay(amount);
  }
}
