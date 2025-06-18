package oops;
class xerox{
	String branchname;
	int cupsold;
	int pricepercup;
	

public void display() {
	System.out.println(branchname);
	System.out.println(cupsold);
	System.out.println(pricepercup);
}
public xerox(String aa,int a,int b) {
	this.branchname=aa;
	this.cupsold=a;
	this.pricepercup=b;
	
	
}
}

public class oops3 {
	public static void main (String args[]) {
		xerox obj=new xerox("no1",6,88);
		obj.display();
		xerox obj1=new xerox("rajubhai",8,99);
		obj1.display();
		
	}
	

}
