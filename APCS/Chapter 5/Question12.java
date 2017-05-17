import java.util.Scanner;
public class Question12{
	public static void main(String [] args){
		printAvg();
	}

	public static int printAvg(){
		Scanner in = new Scanner(System.in);
		System.out.print("Type a number: ");
		int num = in.nextInt();
		if(num < 0){
			return 0;
		}
		int total = 0;
		double avg;
		double count = 0;
		while( num > 0){
			if(num > 0){
			total += num;
			count++;
			}
			System.out.print("\nType a number: ");
			num = in.nextInt();

		}
		avg = total / count;
		System.out.println("Average: " + avg);
		return 0;


	}
}