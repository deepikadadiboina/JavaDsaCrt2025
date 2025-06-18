package restaurantmanager;
import java.util.*;

public class OnlineOrder {
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<String, Integer> orderItems = new LinkedHashMap<>();
    private static String orderStatus = "Preparing";

    public static void placeOrder() {
        orderItems.clear();
        orderStatus = "Preparing";
        int grandTotal = 0;
        String more;

        System.out.println("===== Online Food Ordering =====");
        MenuManager.showMenu();

        do {
            System.out.print("Enter item to order: ");
            String item = sc.next().toLowerCase();

            if (MenuManager.isItemAvailable(item)) {
                System.out.print("Enter quantity for " + MenuManager.capitalize(item) + ": ");
                int quantity = sc.nextInt();
                
                orderItems.put(item, orderItems.getOrDefault(item, 0) + quantity);
                System.out.println(quantity + " " + MenuManager.capitalize(item) + "(s) added.");
            } else {
                System.out.println("Item not available.");
            }

            System.out.print("Want to order more? (yes/no): ");
            more = sc.next().toLowerCase();
        } while (more.equals("yes"));

        System.out.println("\nOrder placed. Please wait...");
        simulateOrderStatus();

        printBill();
    }

   
    private static void simulateOrderStatus() {
        try {
            Thread.sleep(1000); 
            orderStatus = "Ready for Delivery";
        } catch (InterruptedException e) {
            orderStatus = "Status Unknown";
        }
    }

    
    private static void printBill() {
        System.out.println("\n========== ORDER BILL ==========");
        int grandTotal = 0;
        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            int price = MenuManager.getPrice(item);
            int total = quantity * price;
            System.out.println(MenuManager.capitalize(item) + " x " + quantity + " = ₹" + total);
            grandTotal += total;
        }
        System.out.println("--------------------------------");
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Total Amount: ₹" + grandTotal);
        System.out.println("================================");
        System.out.println("Thank you for ordering! Visit again ");
    }
}

