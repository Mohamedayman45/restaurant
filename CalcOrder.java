public class CalcOrder {
     public double calculateTotal(Order order) {
        double total = 0;
        for (IMenuItem item : order.getOrder()) {
            total += item.getPrice();
        }
        return total;
    }
     public double calculateTotalWithTax(Order order, double taxRate) {
        double subtotal = calculateTotal(order);
        return subtotal + (subtotal * taxRate);
    }
    public double calculateTotalWithDeliviry(Order order, double DeliveryFee) {
        double subtotal = calculateTotal(order);
        return subtotal - (subtotal * DeliveryFee);
    }

    public double calculateTotalFinal(Order order) {
        if(order.getOrderType().equals("DINE_IN")) {
            return calculateTotalWithTax(order, 0.10);
        } else if(order.getOrderType().equals("TAKEAWAY")) {
            return calculateTotal(order);
        } else if(order.getOrderType().equals("DELIVERY")) {
            return calculateTotalWithDeliviry(order, 20);
        } else {
            return calculateTotal(order);
        }
    }

    public void printBill(Order order) {
        System.out.println("Order Type: " + order.getOrderType());
        for (IMenuItem item : order.getOrder()) {
            System.out.println("- " + item.getDescription() + " | $" + item.getPrice());
        }
        System.out.println("Total: $" + calculateTotal(order));
    }
}
