interface OrderRepository {
    void save(String order);
}
class MySQLOrderRepository implements OrderRepository {
    public void save(String order) {
        System.out.println("Order saved in MySQL: " + order);
    }
}
class InMemoryOrderRepository implements OrderRepository {
    public void save(String order) {
        System.out.println("Order saved: " + order);
    }
}
class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public void placeOrder(String order) {
        repository.save(order);
    }
}
public class GoodDIP {
    public static void main(String[] args) {
        OrderService service1 =
            new OrderService(new MySQLOrderRepository());
        service1.placeOrder("Laptop Order");

        OrderService service2 =
            new OrderService(new InMemoryOrderRepository());
        service2.placeOrder("Test Order");
    }
}
