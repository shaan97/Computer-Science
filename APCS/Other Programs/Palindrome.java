import java.util.Scanner;

public class Palindrome{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("First String:\t");
		String s1 = in.nextLine();
		System.out.print("Second String:\t");
		String s2 = in.nextLine();

		System.out.println(s1 + "  " + s2);
		System.out.println(isPalindrome(s1,s2));

	}

	public static boolean isPalindrome(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) != s2.charAt( (s1.length() - 1) - i))
				return false;
		}
		return true;
	}
}