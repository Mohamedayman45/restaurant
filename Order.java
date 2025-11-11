import java.util.ArrayList;
import java.util.List;

public class Order {
 private List<IMenuItem> items = new ArrayList<>();
    private OrderType orderType;
    public Order() {
    }


    public void addItem(IMenuItem item) {
        items.add(item);
    }

    public void removeItem(IMenuItem item) {
        items.remove(item);
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
    public List<IMenuItem> getOrder() {
        return items;
    }
    public String getOrderType() {
        return orderType.name();
    }
    public void printOrder(){
        System.out.println("Order Type: " + orderType);
        for(IMenuItem item: items){
            System.out.println(item + " - Price: " + item.getPrice());
        }
    }
}