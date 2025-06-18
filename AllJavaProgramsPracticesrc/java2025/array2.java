package java2025;
import java.util.Scanner;

public class array2 {
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int[] arr=new int[5];
		int small=arr[0];
		for(int i=0;i<arr.length;i++) {
			arr[i]=in.nextInt();
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<small)
				
				small=arr[i];
				//System.out.println(small[i]);
			
		System.out.println(small);
		}
		
	}

}
