package restaurantmanager;
import java.util.*;

public class CustomerService {
    private static final Scanner sc = new Scanner(System.in);
    private static final boolean[] tables = new boolean[5]; 

    public static void serveCustomer() {
        System.out.println("Hello! Welcome to our restaurant!");
        showTableAvailability();

        System.out.print("Enter table number to book (1-5): ");
        int tableNumber = sc.nextInt();

        if (tableNumber < 1 || tableNumber > 5) {
            System.out.println("Invalid table number.");
            return;
        }

        if (!tables[tableNumber - 1]) {
            tables[tableNumber - 1] = true;
            System.out.println("Table " + tableNumber + " booked successfully.");
        } else {
            System.out.println("Table " + tableNumber + " is already booked. Please choose another.");
            return;
        }

        takeFoodOrder();
        collectFeedback();
    }

    private static void showTableAvailability() {
        System.out.println("Table Availability:");
        for (int i = 0; i < tables.length; i++) {
            String status = tables[i] ? "Booked" : "Available";
            System.out.println("Table " + (i + 1) + ": " + status);
        }
    }

    private static void takeFoodOrder() {
        Map<String, Integer> customerOrder = new LinkedHashMap<>();
        String more;

        System.out.println("Food Menu:");
        MenuManager.showMenu();

        do {
            System.out.print("Enter item to order: ");
            String item = sc.next().toLowerCase();

            if (MenuManager.isItemAvailable(item)) {
                System.out.print("Enter quantity for " + MenuManager.capitalize(item) + ": ");
                int quantity = sc.nextInt();
                customerOrder.put(item, customerOrder.getOrDefault(item, 0) + quantity);
                System.out.println(MenuManager.capitalize(item) + " added to your order.");
            } else {
                System.out.println("Item not available.");
            }

            System.out.print("Want to order more? (yes/no): ");
            more = sc.next().toLowerCase();
        } while (more.equals("yes"));

        printCustomerBill(customerOrder);
    }

    private static void printCustomerBill(Map<String, Integer> order) {
        int total = 0;
        System.out.println("========= Your Bill =========");
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            int price = MenuManager.getPrice(item);
            int itemTotal = quantity * price;
            System.out.println(MenuManager.capitalize(item) + " x " + quantity + " = ₹" + itemTotal);
            total += itemTotal;
        }
        System.out.println("-----------------------------");
        System.out.println("Total Bill: ₹" + total);
        System.out.println("=============================");
    }

    private static void collectFeedback() {
        System.out.print("Please provide your feedback: ");
        sc.nextLine();
        String feedback = sc.nextLine();
        System.out.println("Thank you for your feedback!");
    }
}

