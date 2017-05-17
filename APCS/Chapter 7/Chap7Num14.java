import java.util.Scanner;

public class Chap7Num14{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Length of list1\t");
		int length1 = in.nextInt();
		System.out.print("Length of list2\t");
		int length2 = in.nextInt();

		int[] list1 = new int[length1];
		int[] list2 = new int[length2];

		System.out.println("Numbers for list1 (larger)");
		for(int i = 0; i < list1.length; i++){
			list1[i] = in.nextInt();
		}

		System.out.println("Numbers for list2 (smaller)");
		for(int j = 0; j < list2.length; j++){
			list2[j] = in.nextInt();
		}

		System.out.println(contains(list1, list2));
	}

	public static boolean contains(int[] list1, int[] list2){
		int counter = 0;

		for(int j = 0; j < list1.length; j++){
			if(list2[0] == list1[j]){
				if((list1.length-j) < list2.length){
					return false;
				}
				counter = 0;
				for(int x = 0; x < (list2.length); x++){
					if(list2[x] == list1[j+x]){
						counter++;
					}
				}
				if(counter == list2.length){
				return true;
				}
			}
		}

		return false;
	}
}