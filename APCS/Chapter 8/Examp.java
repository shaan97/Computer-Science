import java.util.Scanner;


public class Examp{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String str = "Computer Science";
		String s1 = in.nextLine();
		delete(str,s1);


	}
	public static void delete(String s1, String str)
	{
	 int index = s1.indexOf(str);
	 if (index != -1)
	 {
	 str = s1.substring(0, index) + s1.substring(index + s1.length());
	 }
	 System.out.println(s1);
}

}