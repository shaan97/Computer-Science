import java.util.Scanner;

public class RecursPermut{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Number of items?\t");
		int n = in.nextInt();

		System.out.print("How many are picked?");
		int r = in.nextInt();

		System.out.println("There are " + permut(n,r) + " picked.");
	}

	//n*(n-1)*...*(n-r+1)
	public static int permut(int n, int r){
		if(n < r)
			return 1;
		else{
			System.out.print("" + n + "*");
			return n * permut(n - 1, r);
		}

	}
}