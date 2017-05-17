import java.util.*;

public class ScrambleWords{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Word to be scrambled\t");
		String s1 = in.next();
		scramble(s1);
	}
	public static void scramble(String s1){
		char[] word = new char[s1.length()];

		for(int i = 0; i < s1.length(); i++){
			word[i] = s1.charAt(i);
		}

		for(int j = 0; j < s1.length(); j++){
			int rand = (int)(Math.random()*(s1.length()));
			char temp = word[j];
			word[j] = word[rand];
			word[rand] = temp;
		}
		for(int x = 0; x < (word.length-1); x++){
			System.out.print(word[x]);
		}
		System.out.println(word[word.length-1]);s
	}
}