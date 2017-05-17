import java.util.Scanner;

public class GameAssignments{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int select;
		do{
			System.out.print("Which program would you like to run?\n1 for makeGuesses, 2 for diceSum, 3 to quit.\t");
			select = in.nextInt();
		}while(select != 1 && select != 2 && select != 3);
		while(select == 1 || select ==2 || select == 3){
			if(select==1){
				makeGuesses();
				System.out.println();
			}else if(select == 2){
				int sum;
					do{
						System.out.print("Desire dice sum? \t");
						sum = in.nextInt();
					}while(sum < 0 || sum > 12);
				diceSum(sum);
			}else if(select ==3){
				break;
			}
			System.out.print("Which program would you like to run?\n 1 for makeGuesses, 2 for diceSum, 3 to quit.");
			select = in.nextInt();
		}
	}

	public static void makeGuesses(){
		int x;
		int y = 0;
		do{
			x = (int)(Math.random()*49)+1;
			System.out.println("Guess = " + x);
			y++;
		}while(x<48);
		System.out.println("Total guesses = " + y);
	}

	public static void diceSum(int sum){
		int first;
		int second;
		int check;
		int count = 0;
		do{
			first = (int)(Math.random()*6)+1;
			second = (int)(Math.random()*6)+1;
			check = first + second;
			System.out.println(first + " and " + second + " = " + check);
			count++;
		}while(check!=sum);
		System.out.println("Total dice rolls = " + count);
	}
}