interface PaymentGateway {
  pay(amount: number): void;
}

class Paypal implements PaymentGateway {
  pay(amount: number): void {
    console.log("using PayPal:",amount);
  }
}

class gpay implements PaymentGateway {
  pay(amount: number): void {
    console.log("using gpay:",amount);
  }
}

class paymentservice {
  constructor(private gateway: PaymentGateway) {}

  checkout(amount: number) {
    this.gateway.pay(amount);
  }
}
