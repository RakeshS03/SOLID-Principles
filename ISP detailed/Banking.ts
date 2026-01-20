interface Withdrawable {
    withdraw(amount: number): void;
}
interface Interest {
    calculateInterest(): number;
}
interface LoanEligible {
    applyLoan(amount: number): void;
}
interface StatementGeneratable {
    generateStatement(): void;
}
// savings acc
class SavingsAccount implements Withdrawable, Interest, StatementGeneratable {
    withdraw(amount: number): void {
        console.log(`savings withdrawal: ${amount}`);
    }
    calculateInterest(): number {
        return 4;
    }
    generateStatement(): void {
        console.log("saving accstatement generated");
    }
}
// deposit acc
class DepositAccount implements Interest, StatementGeneratable {
    calculateInterest(): number {
        return 8;
    }

    generateStatement(): void {
        console.log("dep acc statement generated");
    }
}
// loan account
class LoanAccount implements LoanEligible, StatementGeneratable {
    applyLoan(amount: number): void {
        console.log(`loan approved for amt: ${amount}`);
    }

    generateStatement(): void {
        console.log("loan acc statement generated");
    }
}
function processInterest(account: Interest) {
    console.log("Interest:", account.calculateInterest());
}
function processWithdrawal(account: Withdrawable) {
    account.withdraw(5000);
}
processInterest(new SavingsAccount());
processInterest(new DepositAccount());
processWithdrawal(new SavingsAccount());
