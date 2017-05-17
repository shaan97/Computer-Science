import java.util.Scanner;

public class Scrambler{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter word to be scrambled\t");
		String s1 = in.next();
		System.out.println(scrambleWord(s1));
	}

	public static String scrambleWord(String word){
		int current = 0;
		String result="";
		while (current < word.length()-1){
			if (word.substring(current,current+1).equals("A") &&
				!word.substring(current+1,current+2).equals("A")){
				result += word.substring(current+1,current+2);
				result += "A";
				current += 2;
			}else {
				result += word.substring(current,current+1);
				current++;
			}
		}
			if (current < word.length()){
				result += word.substring(current);
			}
			return result;
}
}