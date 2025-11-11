public class PizzaDiscount implements DiscountStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.15; // 15% discount

    @Override
    public double calculateDiscount(double amount) {
        return amount * DISCOUNT_PERCENTAGE;
    }

    @Override
    public String getDiscountType() {
        return "Pizza Discount (15%)";
    }
}

