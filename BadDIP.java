class MySQLDatabase {
    public void saveOrder(String order) {
        System.out.println("Order saved in MySQL: " + order);
    }
}

class OrderService {
    private MySQLDatabase database = new MySQLDatabase();

    public void placeOrder(String order) {
        database.saveOrder(order);
    }
}

public class BadDIP {
    public static void main(String[] args) {
        OrderService service = new OrderService();
        service.placeOrder("Laptop Order");
    }
}
