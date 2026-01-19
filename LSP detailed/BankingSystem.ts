interface Withdrawable {
    withdraw(amount: number): void;
}
interface InterestBearing {
    calculateInterest(): number;
}
class SavingsAccount implements Withdrawable, InterestBearing {
    withdraw(amount: number): void {
        console.log(`Savings withdrawal: ${amount}`);
    }

    calculateInterest(): number {
        return 4;
    }
}
class FixedDepositAccount implements InterestBearing {
    calculateInterest(): number {
        return 8;
    }

    mature(): void {
        console.log("FD matured");
    }
}
function processWithdrawal(account: Withdrawable) {
    account.withdraw(1000);
}
function processInterest(account: InterestBearing) {
    console.log("Interest:", account.calculateInterest());
}
processWithdrawal(new SavingsAccount());
processInterest(new SavingsAccount());
processInterest(new FixedDepositAccount());
