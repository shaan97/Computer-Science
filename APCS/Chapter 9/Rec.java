import java.util.Scanner;

public class Rec{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println(writeSequence(in.nextInt()));



	}

	public static String writeNum(int x){
		if(x == 1)
			return "1";
		else{
			return writeNum(x-1) + ", " + x;
		}
	}

	public static String writeSequence(int n){
		if(n==1)
			return "1";
		else{
			String x = "";
			if(n != 2)
				x = "" + seqHelp(n);
			else{
				x = "1";
			}
			return x + writeSequence(n - 1);
		}
	}

	private static int seqHelp(int x){
		if(x % 2 == 1)
			return (x/2) + 1;
		else
			return (x/2);
	}
	public static void stars(int n, int m){
		helpStar(n);
		helpStar(m);

	}

	private static void helpStar(int n){
		if(n == 0)
			System.out.println();
		else{
			System.out.print(" * ");
			helpStar(n-1);
		}
	}

	public static void starString(int power){
		if(power == 0)
			System.out.println("*");
		else{
			System.out.print("*");

		}
	}

}