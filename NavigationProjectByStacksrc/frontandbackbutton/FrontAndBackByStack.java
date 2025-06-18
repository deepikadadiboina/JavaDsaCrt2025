package frontandbackbutton;
import java.util.Stack;
import java.util.Scanner;

public class FrontAndBackByStack {
	public static void main(String args[]) {
	Stack<String> demo= new Stack<>();
	Stack<String> tempstack=new Stack<>();
	Scanner sc=new Scanner(System.in);
	demo.push("page1");
	demo.push("page2");
	demo.push("page3");
	demo.push("page4");
	System.out.println("current pages:"+demo);
	System.out.println("your are in current page:"+demo.peek());
	System.out.println("type 'next' or 'previous':");
	String page=sc.nextLine();
	
	switch(page) {
	case "next":
		String rem=demo.pop();
	    tempstack.push(rem);
	    System.out.println(demo.peek());
	    System.out.println("want to go next page again:");
	    String nextpage=sc.nextLine();
	    if(nextpage.equals("yes")){
	    	//System.out.println(demo);
	    	String rem1=demo.pop();
	    	tempstack.push(rem1);
	    	System.out.println(demo.peek());
	    	}
	    System.out.println("want to go next page again:");
	    String nextpage1=sc.nextLine();
	    if(nextpage1.equals("yes")){
	    	String rem2=demo.pop();
	    	tempstack.push(rem2);
	    	System.out.println(demo.peek());
	    	System.out.println("no more next page..");
	    	}
	                  
	    else {
	    	System.out.println("enter valid input");
	    }
	    
	    break;
		

		
		
	case "previous":
		if (!tempstack.isEmpty()) {
            String prev = tempstack.pop();
            demo.push(prev);
            System.out.println("Moved back. Now on: " + demo.peek());
        } else {
            System.out.println("No previous pages.");
        }
        break;
	default:
        System.out.println("Invalid option.");
		
		
	
	}
	}
	

}

