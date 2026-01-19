class DiscountCalculator {
    calculate(price: number, discount: number): number {
        return price - discount;
    }
}

class FixedDiscountCalculator extends DiscountCalculator {
    calculate(price: number, discount: number): number {
        return price - 50; // Ignores discount parameter
    }
}

function checkout(calc: DiscountCalculator) {
    console.log(calc.calculate(500, 100));
}

checkout(new DiscountCalculator());
checkout(new FixedDiscountCalculator());  
