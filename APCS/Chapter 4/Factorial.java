import java.util.Scanner;

public class Factorial{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("What's the number?");
		int num = in.nextInt();
		int x = 1;
		for(int i = num; i>=1; i--){
			x*=i;
		}
		System.out.println(x);
	}
}