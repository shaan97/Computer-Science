import java.util.Scanner;

public class Infinite{
	public static void main(String[] args){
		int answer = 0;
		do{
			Scanner in = new Scanner(System.in);
			System.out.println("Sum until?\t");
			int end = in.nextInt();
			int sum = 0;
			for(int i = 1; i <= end ; i++){
				sum+=i;
			}


			System.out.println(sum);
			System.out.println("Again? 1 for yes");
			answer = in.nextInt();
		}while(answer == 1);
	}
}