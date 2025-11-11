import java.util.ArrayList;
import java.util.List;

public class LoyaltyProgram {
    private int points;
    private Customer customer;
    private List<IOrderObserver> observers;

    public LoyaltyProgram(Customer customer) {
        this.customer = customer;
        this.points = 0;
        this.observers = new ArrayList<>();
    }

    public void addObserver(IOrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IOrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Order order) {
        for (IOrderObserver observer : observers) {
            observer.update(order);
        }
    }

    public void updatePoints(Order order) {
        double orderTotal = calculateOrderTotal(order);
        int pointsEarned = (int) (orderTotal / 10); // 1 point per $10
        
        switch (customer.getCustomerType()) {
            case VIP:
                pointsEarned *= 2;
                break;
            case REGULAR:
                pointsEarned = (int) (pointsEarned * 1.5); 
                break;
            case NEW:
                break;
        }
        
        points += pointsEarned;
        System.out.println("Earned " + pointsEarned + " loyalty points. Total points: " + points);
        
        notifyObservers(order);
    }

    private double calculateOrderTotal(Order order) {
        double total = 0.0;
        for (IMenuItem item : order.getOrder()) {
            total += item.getPrice();
        }
        return total;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void redeemPoints(int pointsToRedeem) {
        if (pointsToRedeem <= points) {
            points -= pointsToRedeem;
            System.out.println("Redeemed " + pointsToRedeem + " points. Remaining points: " + points);
        } else {
            System.out.println("Insufficient points. You have " + points + " points.");
        }
    }
}

