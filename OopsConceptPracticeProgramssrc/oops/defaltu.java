package oops;
interface a{
	default void show() {
		System.out.println("from a");
	}
}
interface b{
	default void show() {
		System.out.println("from b");
	}
}
class c implements a,b{
	public void show() {
		System.out.println("from class");
	}
}

public class defaltu {
	public static void main(String args[]) {
		c ob =new c();
		ob.show();
		
	}

}
