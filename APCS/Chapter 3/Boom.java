import java.util.Scanner;

public class Boom{
	public static void main(String[] args){
		Scanner saira = new Scanner(System.in);
		System.out.println("True or False? You are an idiot.");
		boolean x = saira.nextBoolean();
		if(x==true){
			System.out.println("Oh. Cool.");
		}else{
			System.out.println("You are full of crap. Prepare for detonation. Enter a number to continue");
			int y=saira.nextInt();
			for(int i=y; i>=0; i--){
				System.out.println(i);
			}
			System.out.println("BOOOOOOOOOOOOOOM YOU ARE DEAD LOSER");
		}
	}
}

