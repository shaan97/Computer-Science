import java.util.*;

public class Swapper{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Index for i?\t");
		int i = in.nextInt();
		System.out.print("Index for j?\t");
		int j = in.nextInt();
		System.out.print("Size of Array?\t");
		int x = in.nextInt();

		int[] list = new int[x];
		for(int lala = 0; lala < list.length; lala++){
			System.out.print("Index " + lala + "?\t");
			list[lala] = in.nextInt();
		}

		swap(list, i, j);
		printArray(list);
	}

	public static void swap(int[] list, int i, int j){
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;


	}

	public static void printArray(int[] list){
		System.out.println(Arrays.toString(list));
	}
}