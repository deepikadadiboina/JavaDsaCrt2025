package oops;
interface sdemo{
	default void display() {
		System.out.println("from the deafult class");
	}
	static void display2() {
		System.out.println("from the static class");
	}
}
class dee implements sdemo{
	
}

public class interfaces2 {
	public static void main (String args[]) {
		dee obj =new dee();
		obj.display();
		sdemo.display2();
		
	}

}
