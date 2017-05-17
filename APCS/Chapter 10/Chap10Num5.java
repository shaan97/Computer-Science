import java.util.Scanner;
import java.util.ArrayList;

public class Chap10Num5{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();

		System.out.print("How many numbers?\t");
		int x = in.nextInt();
		for(int i = 0; i < x; i++){
			System.out.print("Add:\t");
			list.add(in.nextInt());
		}

		System.out.println(scaleByK(list).toString());
	}

	public static ArrayList<Integer> scaleByK(ArrayList<Integer> list){
		ArrayList<Integer> newList = new ArrayList<Integer>();



		for(int i = 0; i < list.size(); i++){
			int x = list.get(i);

			if(x > 0){
				for(int j = 1; j <= x; j++){
					newList.add(x);
				}
			}

		}

		return newList;
	}

	private static void copy(ArrayList<Integer> list1, ArrayList<Integer> list2){
		for(int i = 0; i < list2.size(); i++){
			list1.add(i, list2.get(i));
		}
	}
}