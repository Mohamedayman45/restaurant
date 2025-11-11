public class PizzaMenuStrategy implements IMenuStrategy,IMenuItem {
    @Override
    public void displayingMenus() {
        System.out.println();
        System.out.println("Pizza");
    }
    public String getDescription() {
        return ("Pizza Menu");
    }
    public double getPrice() {
        return 100.0;
    }
}
