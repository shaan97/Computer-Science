import java.util.Scanner;

public class NumberNine{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Give an integer brah \t");
		int num = in.nextInt();
		printFactors(num);
	}

	public static void printFactors(int num){
		int lol = num - 1;
		for(int i = 1; i<=lol; i++){
			if(num%i == 0){
				System.out.print(i + " and ");
			}
		}
		System.out.println(num);
	}
}