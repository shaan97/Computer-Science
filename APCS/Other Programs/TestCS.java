import java.util.Scanner;

public class TestCS{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);

		String s1 = in.next();

		for(int i = s1.length() - 1; i >= 0; i--){
			System.out.print(s1.charAt(i));
		}
		System.out.println();

	}
}