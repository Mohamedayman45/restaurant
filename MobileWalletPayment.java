public class MobileWalletPayment implements PaymentStrategy {
    private String walletProvider;

    public MobileWalletPayment(String walletProvider) {
        this.walletProvider = walletProvider;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using " + walletProvider);
    }

    @Override
    public String getPaymentMethod() {
        return walletProvider;
    }
}

