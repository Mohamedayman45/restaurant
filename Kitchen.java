public class Kitchen implements IOrderObserver {
    Kitchen() {}
    @Override
    public void update(Order order) {
        System.out.println("Kitchen received order update: " + order.getOrder());
    }
}
