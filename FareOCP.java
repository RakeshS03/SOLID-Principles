interface FareStrategy {
    double calculateFare(double distanceKm);
}

class BikeFare implements FareStrategy {
    public double calculateFare(double distanceKm) {
        return distanceKm * 5;
    }
}

class CabFare implements FareStrategy {
    public double calculateFare(double distanceKm) {
        return distanceKm * 15;
    }
}

class FareCalculator {
    public double getFare(FareStrategy strategy, double distance) {
        return strategy.calculateFare(distance);
    }
}

public class FareOCP {
    public static void main(String[] args) {
        FareCalculator calculator = new FareCalculator();

        System.out.println("Bike Fare: " + calculator.getFare(new BikeFare(), 10));
        System.out.println("Cab Fare: " + calculator.getFare(new CabFare(), 10));
    }
}
