package todopack;
import java.util.*;

public class ToDoList {
    public static void main(String args[]) {
        ArrayList<String> li = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== TO-DO LIST MENU ====");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Remove task by index");
            System.out.println("4. Remove task by name");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    li.add(task);
                    System.out.println("Task added.");
                    break;

                case 2:
                    if (li.isEmpty()) {
                        System.out.println("To-do list is empty.");
                    } else {
                        System.out.println("Your tasks:");
                        for (int i = 0; i < li.size(); i++) {
                            System.out.println(i + ". " + li.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter index of task to remove: ");
                    int index = sc.nextInt();
                    sc.nextLine(); // consume newline
                    if (index >= 0 && index < li.size()) {
                        String removed = li.remove(index);
                        System.out.println("Removed: " + removed);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    System.out.print("Enter task name to remove: ");
                    String name = sc.nextLine();
                    if (li.remove(name)) {
                        System.out.println("Task removed.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting To-Do List. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

		
		
	
