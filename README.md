# Restaurant Management System

A Java-based restaurant management system implementing various design patterns including Strategy, Observer, Decorator, and Factory patterns.

## Modules

### 1. Menu Module
- **Strategy Pattern**: Different menu strategies (Pizza, Vegetarian)
- **Factory Pattern**: Menu strategy factory for creating menu instances
- **Decorator Pattern**: Add-ons for menu items (Cheese, Sauce)

### 2. Order Module
- Order management with different order types (Dine-in, Takeaway, Delivery)
- Observer pattern for order notifications
- Order calculation and processing

### 3. Payment & Billing Module
- **Strategy Pattern**: Multiple payment methods (Cash, Credit Card, Mobile Wallet)
- **Strategy Pattern**: Discount strategies (Chicken Discount, Pizza Discount)
- Bill generation with tax calculation and discount application

### 4. Customer Module
- Customer management with different customer types (Regular, VIP, New)
- Order history tracking
- **Strategy/Observer Pattern**: Loyalty program with point calculation and notifications

## Design Patterns Used

- **Strategy Pattern**: Payment methods, Discount strategies, Menu strategies
- **Observer Pattern**: Order notifications, Loyalty program updates
- **Decorator Pattern**: Menu item add-ons
- **Factory Pattern**: Menu strategy creation

## Getting Started

Compile and run the Java files. The main entry point is `Main.java`.

## Project Structure

- Menu Strategy classes: `PizzaMenuStrategy.java`, `VegMenuStrategy.java`
- Payment classes: `CashPayment.java`, `CreditCardPayment.java`, `MobileWalletPayment.java`
- Discount classes: `ChickenDiscount.java`, `PizzaDiscount.java`
- Customer classes: `Customer.java`, `CustomerType.java`, `LoyaltyProgram.java`
- Core classes: `Order.java`, `Bill.java`, `OrderManger.java`

