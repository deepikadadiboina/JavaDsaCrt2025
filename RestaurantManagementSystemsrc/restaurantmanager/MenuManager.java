package restaurantmanager;

import java.util.*;


public class MenuManager {
    private static final Map<String, Integer> menu = new LinkedHashMap<>();

    static {
       
        menu.put("pizza", 150);
        menu.put("burger", 100);
        menu.put("pasta", 120);
        menu.put("sandwich", 80);

    }

   
    public static void showMenu() {
        System.out.println("===== Food Menu =====");
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String item = capitalize(entry.getKey());
            System.out.println(item + " - ₹" + entry.getValue());
        }
    }

   
    public static boolean isItemAvailable(String item) {
        return menu.containsKey(item.toLowerCase());
    }

   
    public static int getPrice(String item) {
        return menu.get(item.toLowerCase());
    }

   
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    
    public static void addMenuItem(String item, int price) {
        menu.put(item.toLowerCase(), price);
        System.out.println(capitalize(item) + " added to menu at ₹" + price);
    }
}

    