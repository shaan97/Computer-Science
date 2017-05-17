import java.util.Scanner;
import java.util.ArrayList;

public class Chap10Num1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		System.out.print("How many words?\t");
		int numWords = in.nextInt();

		for(int i = 1; i <= numWords; i++){
			System.out.print("Next word:\t");
			list.add(in.next());
		}

		System.out.println(averageValues(list));

	}

	public static int averageValues(ArrayList<String> list){
		int count = 0;

		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.get(i).length(); j++){
				if(isVowel(list.get(i).charAt(j)))
					count++;

			}
		}

		return count;
	}

	private static boolean isVowel(char vowel){
		switch(vowel){

			case 'a':	return true;
			case 'e':	return true;
			case 'i':	return true;
			case 'o':	return true;
			case 'u':	return true;
			default: 	return false;

		}
	}

}