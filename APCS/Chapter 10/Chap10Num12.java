import java.util.Scanner;
import java.util.ArrayList;

public class Chap10Num12{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		System.out.print("How many words?\t");
		int numWords = in.nextInt();

		for(int i = 0; i < numWords; i++){
			System.out.print("Next word:\t");
			list.add(in.next());
		}

		System.out.println(markLength4(list).toString());
	}

	public static ArrayList<String> markLength4(ArrayList<String> list){
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).length() == 4){
				list.add(i, "****");
				i++;
			}
		}

		return list;
	}
}