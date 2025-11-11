public class MenuStrategyContext {
    private IMenuStrategy menuStrategy;
    public MenuStrategyContext(IMenuStrategy menuStrategy){
        this.menuStrategy = menuStrategy;
    }
    public void displayingMenus() {
        menuStrategy.displayingMenus();
    }
}
