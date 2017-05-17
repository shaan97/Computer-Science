import java.util.Scanner;

public class Chap12Num2{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("How many?\t");
		writeNums(in.nextInt());
	}

	public static void writeNums(int n){
		if(n == 1)
			System.out.print("1");
		else{
			writeNums(n - 1);
			System.out.print(", " + n);
		}
	}
}