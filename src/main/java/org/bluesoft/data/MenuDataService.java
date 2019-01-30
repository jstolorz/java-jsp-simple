package org.bluesoft.data;

import org.bluesoft.domain.MenuCategory;
import org.bluesoft.domain.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MenuDataService {

    List<MenuItem> menuItems = new ArrayList<>();
    Map<MenuItem, Integer> currentOrder = new ConcurrentHashMap<>();

    public MenuDataService() {
        menuItems.add(new MenuItem(1, "Soup of the day (v)", "A delicious soup made from the chef's choice of vegetables. Served with a home baked bread roll.", MenuCategory.STARTER, 4.99));
        menuItems.add(new MenuItem(2, "Asparagus filo parcels (v)", "Fresh seasonal asparagus, wrapped in a light filo pastry, served with a chilli dipping sauce.", MenuCategory.STARTER, 6.99));
        menuItems.add(new MenuItem(3, "Chicken Terrine", "Our terrine tastes of summer! We use only the finest organic chicken. Served with a mixed leaf salad. (contains nuts)", MenuCategory.STARTER, 5.99));
        menuItems.add(new MenuItem(4, "Lamb Shank", "Slow cooked to perfection, our organic lamb melts in the mouth. Served with mixed vegetables and seasonal potatoes.", MenuCategory.MAIN_COURSE, 12.99));
        menuItems.add(new MenuItem(5, "Sea Bass", "We pan fry our freshly caught sea bass to seal in the flavour. Served with mixed vegetables and seasonal potatoes.", MenuCategory.MAIN_COURSE, 11.99));
        menuItems.add(new MenuItem(6, "Butternut squash risotto", "People come from far and wide for our famous risotto. Served with a mixed leaf salad. (v)", MenuCategory.MAIN_COURSE, 9.99));
        menuItems.add(new MenuItem(7, "Raspberry cheesecake", "A delightfully sweet cheesecake, served with a sour raspberry compot, to form a perfect balance to end your meal.", MenuCategory.DESERT, 6.99));
        menuItems.add(new MenuItem(8, "Lemon mousse", "Feeling full? Our mousse is delightfully light and fluffy. Served with home baked shortbread.", MenuCategory.DESERT, 6.99));
        menuItems.add(new MenuItem(9, "Fruit skewers", "Our nostalgic 80s desert is super healthy... then we add luxurious vanilla ice-cream and chocolate sauce. ", MenuCategory.DESERT, 6.99));
        menuItems.add(new MenuItem(10, "Coffee", "Espresso, Americano, Latte or Capuccino? Tell us how you like it!", MenuCategory.DRINK, 2.99));
        menuItems.add(new MenuItem(11, "Tea", "We have a full range of classic and herbal teas.", MenuCategory.DRINK, 2.99));
    }

    public List<MenuItem> getFullMenu(){
        return this.menuItems;
    }

    public List<MenuItem> find(String searchString){
        List<MenuItem> result = new ArrayList<>();

        for(MenuItem menuItem: menuItems){
            if(menuItem.getName().toLowerCase().contains(searchString.toLowerCase())
                    || menuItem.getDescription().toLowerCase().contains(searchString.toLowerCase())){

                result.add(menuItem);
            }
        }

        return result;
    }

    public MenuItem getItem(int id){
        return menuItems.get(id);
    }

    public void addToOrder(MenuItem menuItem, int quantity){
        int currentQuantity = 0;
        if(currentOrder.get(menuItem) != null) currentQuantity = currentOrder.get(menuItem);
        currentOrder.put(menuItem, currentQuantity + quantity);
    }

    public Double getTotal(){
        double d = 0d;

        for(MenuItem menuItem: currentOrder.keySet()){
            d += currentOrder.get(menuItem) * menuItem.getPrice();
        }

        return d;
    }

}
