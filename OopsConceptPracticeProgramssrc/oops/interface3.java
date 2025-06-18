package oops;
interface a{
	void display(); 
	
}
interface b{
	void display();
}
class c implements a,b{
	public void display() {
		System.out.println("from a");
	}
	public void display() {
		System.out.println("from b";)
	}
}

public class interface3 {
	public static void main(String args[]) {
		c obj=new c();
		obj.display();
		
	}

}
