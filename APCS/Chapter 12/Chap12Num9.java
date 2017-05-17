import java.util.Scanner;

public class Chap12Num9{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("How many?\t");
		System.out.println(sumTo(in.nextInt()));
	}

	public static double sumTo(double n){
		if(n == 1)
			return 1;
		else
			return (1/n) + sumTo(n-1);
	}
}