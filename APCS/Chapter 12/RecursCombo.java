import java.util.Scanner;

public class RecursCombo{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("How many items?\t");
		int n = in.nextInt();
		
		System.out.print("How many are chosen?\t");
		int r = in.nextInt();
		
		System.out.println("" + combo(n,r) + " are chosen.");
	}
	
	public static int combo(int n, int r){
		if(r == 0)
			return 1;
		else
			return (n * combo(n - 1, r - 1))/r;
			
	}
}