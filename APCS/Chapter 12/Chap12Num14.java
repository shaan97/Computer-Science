import java.util.Scanner;

public class Chap12Num14{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		System.out.print("How many items?\t");
		int n = in.nextInt();

		System.out.print("How many do you pick?\t");
		int r = in.nextInt();

		System.out.println(permut(n,r));
	}

	public static int permut(int n, int r){
		if(r == 0)
			return 1;
		else
			return n * permut(n - 1, r - 1);
	}
}