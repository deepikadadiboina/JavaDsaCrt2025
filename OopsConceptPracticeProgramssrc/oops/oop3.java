package oops;
class teashop{
	String ownername="chinnaya";
	String shopname;
	int rev;
	public void display() {
		System.out.println("from the displaymethod of parent");
	}
	
}
class xeorx extends teashop{
	String shopname;
	int rev;
	public void display() {
		System.out.println("from the displaymethod of childd");
	}
	
}

public class oop3 {
	public static void main(String args[]) {
		teashop obj=new teashop();
		obj.ownername="ravikanth";
		xeorx obj2=new xeorx();
		System.out.println(obj.ownername);
		System.out.println(obj2.ownername);
		obj.display();
		
	}

}
