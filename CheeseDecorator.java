public class CheeseDecorator extends AddsOnDecorator{
    public CheeseDecorator(IMenuItem item) {
        super(item);
    }
    @Override
    public double getPrice() {
        return MenuItem.getPrice()+30;
    }
    @Override
    public String getDescription() {
        return MenuItem.getDescription() + " Added Cheese";
    }
}
