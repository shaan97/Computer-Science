import java.util.*;

public class MasterMind{
	public static void main(String[] args){

		int[] master = new int[4];
		int[] user = new int[4];  //Two arrays for comparing the four digit numbers
		System.out.println("Let's play MasterMind! I'm going to pick a four digit number, and you will have to try and guess what it is!");
		boolean winner;

		choose(master);
		do{
			userChoose(user);
			winner = compare(master, user);
		}while(winner == false);
	}

	//computer random selection of four digits
	public static void choose(int[] master){
		for(int i = 0; i < master.length; i++){
			if(i==0){
				master[i] = (int) (Math.random()*9)+1;
			}else{
				master[i] = (int)(Math.random()*10);
			}

		}

	}


	//user selection of four digits
	public static void userChoose(int[] user){
		Scanner in = new Scanner(System.in);

		System.out.print("Enter single digits, each with spaces between them\t");
		for(int i = 0; i < user.length; i++){
			user[i] = in.nextInt();
		}
	}

	//Actual comparison of digits
	public static boolean compare(int[] master, int[] user){
		int correctGoodSpot = 0;
		int correctBadSpot = 0;
		int[] temp = {-1, -1, -1, -1};

		for(int i = 0; i < master.length; i++){
			if(master[i] == user[i]){
				correctGoodSpot++;
			}
			for(int j = 0; j < master.length; j++){
				if(master[i] == user[j] && temp[0] != j && temp[1] != j && temp[2] != j && temp[3] !=j){
					temp[correctBadSpot] = j;
					correctBadSpot++;


					break;
				}
			}

		}
		correctBadSpot-=correctGoodSpot;
		System.out.println("Correct with right place =\t\t" + correctGoodSpot);
		System.out.println("Correct with wrong spot =\t\t" + correctBadSpot);

		if(correctGoodSpot == 4){
			System.out.println("Congratulations! You win!");
			return true;
		}else{
			System.out.println("Guess again!");
			return false;
		}


	}
}