public class SauceDecorator extends AddsOnDecorator{
    public SauceDecorator(IMenuItem item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return MenuItem.getPrice()+15;
    }
    @Override
    public String getDescription() {
        return MenuItem.getDescription() + " Added Sauce";
    }
}