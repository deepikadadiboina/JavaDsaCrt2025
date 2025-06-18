package restaurantmanager;
import java.util.*;

public class AdminService {
    public static void handleAdminService() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Admin Panel:");
        System.out.println("1. View Staff Info");
        System.out.println("2. View Staff Time Slots");
        System.out.println("3. View Staff Salary");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Staff: sai (Waiter), deepthi (Cook1), vishnu (Manager),priya (Cook2)");
                break;
            case 2:
                System.out.println("sai: 10AM-6PM | deepthi: 8AM-4PM | vishnu: 12PM-8PM | priya : 4PM-9PM");
                break;
            case 3:
                System.out.println("sai: ₹15,000 | deepthi: ₹18,000 | vishnu: ₹25,000 | priya : ₹18,000");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

