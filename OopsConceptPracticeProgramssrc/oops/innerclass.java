package oops;
class outer{
	void display() {
	System.out.println("from outer");
	}
	class inner{
		void display1() {
		System.out.println("from inner");
	}
}
}

public class innerclass {
	public static void main(String args[]) {
		outer c=new outer();
		c.display();
		outer.inner ob=c.new inner();
		ob.display1();
		
		
	}
		
}


