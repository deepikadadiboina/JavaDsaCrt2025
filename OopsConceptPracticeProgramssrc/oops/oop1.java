package oops;
class random1{
	String name;
	int noofchaii;
	//random1 rs=new random1();
	//rs.name="rakesh";
	//System.out.println(rs.name);
	//System.out.println(name);
	public void display(String s) {
		int a=100;
		System.out.println(a);
		System.out.println("i am from display method"+s);
	}
	public random1(String s) {
		int z=99;
		System.out.println("i am construtorrrrr.."+s);
		System.out.println(z);
		
	}
	
}

public class oop1 {
	public static void main(String args[]) {
		random1 rm=new random1("consterrrrr");
		rm.name="raju";
		rm.noofchaii=99;
		System.out.println(rm.name);
		System.out.print(rm.noofchaii);
		random1 rd=new random1("con1");
		rd.name="rajesh";
		rd.noofchaii=66;
		System.out.println(rd.name);
		System.out.print(rd.noofchaii);
		//random1 rs=new random1();
		random1 rs=new random1("con2");
		rs.name="rakesh";
		System.out.println(rs.name);
		rs.display("booochi");
		rm.display("kooo");
		rd.display("ewwww");
		
				
		
		
	}

}
