import java.util.Scanner;

public class rand{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		double x;
		do{
			x = Math.random();
			System.out.println("Are you gay? Let's find out.");
			System.out.println("Enter a phrase to see how gay you are.");
			String y = in.nextLine();
			if(x<=.9){
				System.out.println("You are homosexual");
			}else if(x>.9){
				System.out.println("You are straight");
			}
		}while(x==x);
	}
}