
public class Main {
	public static void main(String[] args) {
		// Display menus using strategy/context
		MenuStrategyContext vegContext = new MenuStrategyContext(MenuStrategyFactory.getStrategy("veg"));
		MenuStrategyContext pizzaContext = new MenuStrategyContext(MenuStrategyFactory.getStrategy("pizza"));

		System.out.println("--- Menus ---");
		vegContext.displayingMenus();
		pizzaContext.displayingMenus();

		// Create order manager and observers
		OrderManger manager = new OrderManger();
		Kitchen kitchen = new Kitchen();
		Waiter waiter = new Waiter();
		manager.addObserver(kitchen);
		manager.addObserver(waiter);

		// Create a customer and loyalty program
		Customer customer = new Customer("Alice", "alice@example.com", "1234567890", CustomerType.REGULAR);
		LoyaltyProgram loyalty = new LoyaltyProgram(customer);
		customer.setLoyaltyProgram(loyalty);

		// Create an order
		Order order = manager.createOrder(OrderType.DINE_IN);

		// Create a pizza item and add decorators (cheese, sauce)
		IMenuItem pizza = new PizzaMenuStrategy();
		pizza = new CheeseDecorator(pizza);
		pizza = new SauceDecorator(pizza);

		manager.addOrder(order, pizza);

		// Place the order (prints order and notifies observers)
		manager.placeOrder(order);

		// Create a bill, apply a pizza discount and a payment method
		Bill bill = new Bill(order);
		bill.setDiscountStrategy(new PizzaDiscount());
		bill.setPaymentStrategy(new CreditCardPayment("1234567812345678", "Alice"));

		// Generate invoice and process payment
		bill.generateInvoice();
		bill.processPayment();

		// Add the order to the customer's history (updates loyalty points)
		customer.addOrder(order);

		// Show customer info and loyalty points
		customer.displayCustomerInfo();
	}
}







