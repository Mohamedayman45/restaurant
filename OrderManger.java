//also the subject in observer pattern and the manager in facade pattern

import java.util.ArrayList;
import java.util.List;

public class OrderManger {
    private List<IOrderObserver> observers = new ArrayList<>();

    public Order createOrder(OrderType orderType) {
        Order order = new Order();
        order.setOrderType(orderType);
        return order;
    }
    public void addOrder(Order order, IMenuItem item){
        order.addItem(item);
    }
    public void removeOrder(Order order, IMenuItem item){
        order.removeItem(item);
    }
    public void addObserver(IOrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IOrderObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers(Order order){
        for(IOrderObserver observer : observers){
            observer.update(order);
        }
    }
    public void placeOrder(Order order){
        System.out.println("Placing Order:");
        order.printOrder();
        System.out.println("Order placed successfully!");
        notifyObservers(order);
    }
}