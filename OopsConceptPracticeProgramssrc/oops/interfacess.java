package oops;
interface demo{
	int a=99;
	String name="deepu";
	void display(); 
	
	
}
class demoim implements demo{
	public void display() {
		System.out.println("from interfaces");
	}
	
}

public class interfacess{
	public static void main(String args[]) {
		demoim d=new demoim();
		d.display();
	
	

}
}