public abstract class AddsOnDecorator implements IMenuItem{
    protected IMenuItem MenuItem;
    public AddsOnDecorator(IMenuItem MenuItem) {
        this.MenuItem = MenuItem;
    }
    public abstract String getDescription();
    public abstract double getPrice();
}
