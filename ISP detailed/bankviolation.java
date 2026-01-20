interface BankAccount {
    void withdraw(double amount);
    void calculateInterest();
    void generateStatement();
}

class DepositAccount implements BankAccount {
    public void withdraw(double amount) {
        throw new UnsupportedOperationException();
    }

    public void calculateInterest() {
        System.out.println("Calculating Interest");
    }

    public void generateStatement() {
        System.out.println("Generating statement");
    }
}
