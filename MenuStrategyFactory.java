//to not violate oped closed principle
import java.util.HashMap;
import java.util.Map;

public class MenuStrategyFactory {
    private static final Map<String, IMenuStrategy> strategies = new HashMap<>();
    static {//to remove switch cases in client code
        strategies.put("veg", new VegMenuStrategy());
        strategies.put("nonveg", new PizzaMenuStrategy());
    }
    public static IMenuStrategy getStrategy(String type) {
        return strategies.get(type.toLowerCase());
    }
}
