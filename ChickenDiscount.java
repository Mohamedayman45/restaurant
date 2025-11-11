public class ChickenDiscount implements DiscountStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.10; // 10% discount

    @Override
    public double calculateDiscount(double amount) {
        return amount * DISCOUNT_PERCENTAGE;
    }

    @Override
    public String getDiscountType() {
        return "Chicken Discount (10%)";
    }
}

