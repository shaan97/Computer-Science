import java.util.Scanner;

public class CharUpLow{
	public static void main(String[] args){
		Scanner user = new Scanner(System.in);
		System.out.println("Give a char, and I'll tell you if its upper/lower case");
		String x = user.next();
		char y = x.charAt(0);

		if(Character.isUpperCase(y) == true){
			System.out.println("It's upper case.");
		}else if(Character.isUpperCase(y) == false){
			System.out.println("It's lower case.");
		}else{
			System.out.println("None!");
		}
	}
}