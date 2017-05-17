import java.util.Scanner;
import java.util.ArrayList;

public class Chap10Num9{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();

		System.out.print("How many numbers?\t");
		int x = in.nextInt();
		for(int i = 0; i < x; i++){
			System.out.print("Add:\t");
			list.add(in.nextInt());
		}
		System.out.println("The distance is " + rangeBetweenZeroes(list));
	}

	public static int rangeBetweenZeroes(ArrayList<Integer> list){
		int first = list.indexOf(0);
		int second = -1;

		for(int i = (list.size() - 1); i >= 0; i--){
			if(list.get(i) == 0 && i != first){
				second = i;
				break;
			}
		}

		if(first != -1 && second != -1){
			return (second - first) + 1;
		}else if(first != -1 && second == -1){
			return 1;
		}else{
			return 0;
		}
	}
}