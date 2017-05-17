import java.util.Scanner;

public class EvenSum{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("How many integers?\t");
		int num = in.nextInt();
		int x = 0;
		nextInteger(num);
	}
	public static void nextInteger(int num){
		Scanner console = new Scanner(System.in);
		int even = 0;
		int max = 0;
		int x = 0;
		for(int i = num; i>0; i--){
			System.out.print("Next Integer?\t");
			x = console.nextInt();
			if(max<x){
				max = x;
			}
			if((x%2)==0){
				even+=x;
			}

		}
		System.out.println("Even Sum = " + even + ", Even Max = " + max);
	}
}
