import java.util.Scanner;

public class Chap12Num11{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("First word:\t");
		String s1 = in.next();
		System.out.print("Second word:\t");
		String s2 = in.next();

		System.out.println(isReverse(s1, s2));
	}

	public static boolean isReverse(String first, String second){
		first = first.toUpperCase();
		second = second.toUpperCase();
		if(first == "" && second == "")
			return true;
		else if(first.length() == 1 && second.length() == 1 && first.charAt(0) == second.charAt(0))
			return true;
		else if(first.length() != second.length())
			return false;
		else{
			if(first.charAt(0) == second.charAt(second.length()-1)){
				return isReverse(first.substring(1),second.substring(0,second.length()-1));
			}else
				return false;
		}
	}
}