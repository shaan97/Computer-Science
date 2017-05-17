import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class BinTest{
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);

		System.out.print("How many numbers?:\t");
		int length = in.nextInt();

		for(int i = 0; i < length; i++){
			System.out.print("Index " + i + ":\t");
			list.add(in.nextInt());
		}
		Collections.sort(list);
		System.out.println(list.toString());
		System.out.print("Find which number?\t");
		System.out.println("" + find(in.nextInt(), list));

	}

	public static int find(int key, ArrayList<Integer> list){
		return binSearch(key, list, 0, (list.size() - 1));
	}
	private static int binSearch(int key, ArrayList<Integer> list, int low, int high){
		if(low > high)
			return -1;
		else{
			int mid = (low + high)/2;
			if(list.get(mid) == key)
				return mid;
			else if(key < list.get(mid))
				return binSearch(key, list, low, list.get(mid - 1));
			else
				return binSearch(key, list, list.get(mid + 1), high);

		}


	}

}