public class Waiter implements IOrderObserver {
    Waiter() {}
    @Override
    public void update(Order order) {
        System.out.println("Waiter received order update: " + order.getOrder());
    }
    
}
