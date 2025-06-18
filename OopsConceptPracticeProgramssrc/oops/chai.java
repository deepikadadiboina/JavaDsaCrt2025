package oops;
class chailvala{
	String shopname;
	int noofsold;
	public void display(String y) {
		System.out.println("hii"+y);
	}
	//constructor same name as class namae no return ttype 
	//constructor runs autoatically when object is created
	public chailvala(String ee,int b) {
		//System.out.println(ee);
		//System.out.println(b);
		shopname=ee;
		noofsold=b;
		
		
	}
	//public chailvala(String s,int n) {
		//System.out.println(s);
		//System.out.println(n);
	//}
	
}

public class chai {
	public static void main(String args[]) {
		chailvala obj=new chailvala("gangubhai",88);
		//obj.shopname="rajubhai";
		System.out.println(obj.shopname);
		System.out.println(obj.noofsold);
		obj.display("pa");
		chailvala obj2=new chailvala("raju",4);
		
		
		
	}

}
