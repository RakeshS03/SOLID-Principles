/* 
interface RideOperations {
    void bookRide();
    void cancelRide();
    void rateDriver();
}

class AdminPanel implements RideOperations {
    public void bookRide() {}
    public void cancelRide() {}
    public void rateDriver() {}
}
*/

interface RideBooking {
    void bookRide();
}

interface RideCancellation {
    void cancelRide();
}

interface RideRating {
    void rateDriver();
}

class Rider implements RideBooking, RideCancellation, RideRating {
    public void bookRide() { 
        System.out.println("Ride booked"); 
    }
    public void cancelRide() {
         System.out.println("Ride cancelled"); 
        }
    public void rateDriver() { 
        System.out.println("Driver rated");
    }
}
