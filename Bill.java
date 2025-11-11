import java.util.List;

public class Bill {
    private Order order;
    private DiscountStrategy discountStrategy;
    private PaymentStrategy paymentStrategy;
    private static final double TAX_RATE = 0.10; // 10% tax

    public Bill(Order order) {
        this.order = order;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double calculateSubtotal() {
        double subtotal = 0.0;
        List<IMenuItem> items = order.getOrder();
        for (IMenuItem item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    public double calculateDiscount() {
        if (discountStrategy == null) {
            return 0.0;
        }
        double subtotal = calculateSubtotal();
        return discountStrategy.calculateDiscount(subtotal);
    }

    public double calculateTax() {
        double subtotal = calculateSubtotal();
        double discount = calculateDiscount();
        return (subtotal - discount) * TAX_RATE;
    }

    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        double discount = calculateDiscount();
        double tax = calculateTax();
        return subtotal - discount + tax;
    }

    public void generateInvoice() {
        System.out.println("\n========== INVOICE ==========");
        System.out.println("Order Type: " + order.getOrderType());
        System.out.println("\nItems:");
        List<IMenuItem> items = order.getOrder();
        for (IMenuItem item : items) {
            System.out.println("  - " + item.getDescription() + ": $" + item.getPrice());
        }
        
        double subtotal = calculateSubtotal();
        double discount = calculateDiscount();
        double tax = calculateTax();
        double total = calculateTotal();

        System.out.println("\nSubtotal: $" + String.format("%.2f", subtotal));
        
        if (discount > 0) {
            System.out.println("Discount (" + discountStrategy.getDiscountType() + "): -$" + 
                             String.format("%.2f", discount));
        }
        
        System.out.println("Tax (10%): $" + String.format("%.2f", tax));
        System.out.println("Total: $" + String.format("%.2f", total));
        System.out.println("============================\n");
    }

    public void processPayment() {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected!");
            return;
        }
        double total = calculateTotal();
        paymentStrategy.pay(total);
    }
}

