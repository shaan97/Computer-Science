import java.util.Scanner;

public class ChapFiveNum25{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		while (!console.hasNextInt()) {

			System.out.println("Not an integer; try again.");
			System.out.print("NUMBA");
			}
		System.out.print(console.nextInt());
		}
}
