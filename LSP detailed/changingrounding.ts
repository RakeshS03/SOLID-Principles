class TaxCalculator {
    calculate(amount: number): number {
        return amount * 0.18;
    }
}
class extendedTaxCalculator extends TaxCalculator {
    calculate(amount: number): number {
        return Math.round(amount * 0.18);
    }
}

function printTax(calc: TaxCalculator) {
    console.log(calc.calculate(99));
}

printTax(new TaxCalculator());        // 17.82
printTax(new extendedTaxCalculator()); // 18 (violation)
