import java.util.Scanner;

public class Chap12Num1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("2 to the ___ strings. How many?\t");
		int exp = in.nextInt();

		starString(exp);
	}

	public static void starString(int exp){
		if(exp == 0)
			System.out.print("*");
		else{
			starString(exp - 1);
			starString(exp - 1);
		}
	}
}
