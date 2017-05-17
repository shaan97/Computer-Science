import java.util.Scanner;
	public class Question13{
		public static void main(String [] args){
			Scanner in = new Scanner(System.in);
			System.out.print("Enter a String: ");
			String x = in.nextLine();
			printPalindrome(x);
		}
		public static void printPalindrome(String x){
			String reverse = "";
			int length = x.length();
			for(int i = length - 1; i >= 0; i--){
				reverse = reverse + x.charAt(i);
			}
			if(x.equals(reverse)){
				System.out.println(reverse + " is a palindrome");
			}
			else{
				System.out.println(x + " is not a palindrome");
			}
		}
	}