package oops;
class shop{
	String shopname;
	int noofcups;
	int pricepercup;
	public shop(String s,int a,int b) {
		shopname=s;
		noofcups=a;
		pricepercup=b;
		System.out.println(shopname);
		System.out.println(noofcups);
		System.out.println(pricepercup);
		rev();
	}
	public void annachaii(int num) {
		noofcups+=num;
	}
	public void rev(){
		System.out.println("rev" +noofcups*pricepercup);
			
			
		}
		//public  display() {
			//System.out.println(shopname);
			//System.out.println(noofcups);
			//System.out.println(pricepercup);
			//rev();
		//}
	
	
}

public class teastall {
	public static void main(String args[]) {
		shop obj=new shop("chaiworld",0,10);
		shop obj2=new shop("malluchaii",10,15);
		obj.annachaii(9);
		obj2.annachaii(9);

		
	}

}
