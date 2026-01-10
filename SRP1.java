class Invoice {
    private double amount;
    //handles calculation

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double calculateTax() {
        return amount * 0.18;
        
    }
}

//handles storage
class SRP1 {
    public void save(Invoice invoice) {
        System.out.println("Invoice saved");
    }
}
