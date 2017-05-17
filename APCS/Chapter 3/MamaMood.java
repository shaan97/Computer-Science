import java.util.Scanner;

public class MamaMood{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		boolean mood;
		System.out.println("Answer the following Questions with \"True\" or \"False\" \n");
		System.out.println("Is mother in a good mood?");
		mood=console.nextBoolean();
		if(mood==true){
			System.out.println("THANK GOD ALMIGHTY");
		}else if(mood==false){
			System.out.println("SHIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIEEEEEEEEEEEEEEEEEEEEEEEEET");
		}
	}
}