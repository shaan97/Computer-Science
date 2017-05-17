import java.util.Scanner;

public class Chap12Num10{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Text:\t");
		String s1 = in.nextLine();
		System.out.print("Repeat Number:\t");
		int num = in.nextInt();
		System.out.println(repeat(s1, num));
	}

	public static String repeat(String text, int concot){
		if(concot == 0)
			return "";
		if(concot == 1)
			return text;
		else
			return text + repeat(text, concot - 1);
	}

}