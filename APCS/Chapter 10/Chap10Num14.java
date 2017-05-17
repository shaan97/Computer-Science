import java.util.Scanner;
import java.util.ArrayList;

public class Chap10Num14{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		System.out.print("How many words?\t");
		int numWords = in.nextInt();
		for(int i = 1; i <= numWords; i++){
			System.out.print("Next word:\t");
			list.add(in.next());
		}

		System.out.println(removeShorterStrings(list).toString());
	}

	public static ArrayList<String> removeShorterStrings(ArrayList<String> list){
		for(int i = 0; i < list.size(); i++){
			if((i+1) < list.size() && list.get(i).length() > list.get(i+1).length())
				list.remove(i+1);
			else if((i+1) < list.size() && list.get(i).length() <= list.get(i+1).length())
				list.remove(i);

		}

		return list;
	}
}