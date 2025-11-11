import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private CustomerType customerType;
    private List<Order> orderHistory;
    private LoyaltyProgram loyaltyProgram;

    public Customer(String name, String email, String phone, CustomerType customerType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.orderHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
        if (loyaltyProgram != null) {
            loyaltyProgram.updatePoints(order);
        }
    }

    public void setLoyaltyProgram(LoyaltyProgram loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    public LoyaltyProgram getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void displayCustomerInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Customer Type: " + customerType);
        if (loyaltyProgram != null) {
            System.out.println("Loyalty Points: " + loyaltyProgram.getPoints());
        }
        System.out.println("Total Orders: " + orderHistory.size());
    }
}

