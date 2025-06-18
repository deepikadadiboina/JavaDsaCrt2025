package restaurantmanager;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("========= Welcome to Taj Restaurant =========");
	            System.out.println("1. Customer Services");
	            System.out.println("2. Admin Services");
	            System.out.println("3. About Restaurant");
	            System.out.println("4. Online Order");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    CustomerService.serveCustomer();
	                    break;
	                case 2:
	                    AdminService.handleAdminService();
	                    break;
	                case 3:
	                    RestaurantInfo.showInfo();
	                    break;
	                case 4:
	                    OnlineOrder.placeOrder();
	                    break;
	                case 5:
	                    System.out.println("Thank you! Visit again!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	        } while (choice != 5);

	        sc.close();
	    }
	}



