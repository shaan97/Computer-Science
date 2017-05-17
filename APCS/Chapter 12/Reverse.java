 import java.util.Scanner;

 public class Reverse{
 	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println(pow(in.nextInt(), in.nextInt()));
 	}

 	public static String reverse(String s1){
 		if(s1.equals(""))
 			return s1;
 		else
 			return s1.charAt(s1.length()-1) + reverse(s1.substring(0,(s1.length()-1)));
 	}

 	public static void revDigits(int n){
		if(n == 0)
			System.out.println();
		else{
			System.out.print(n % 10);
			revDigits(n / 10);
		}
	}

	public static int pow(int a, int x){
		if(x == 0)
			return 1;
		else
			return a * pow(a, x-1);

	}
 }