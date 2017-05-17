import java.util.Scanner;

public class BirdTest{

	public static void main(String[] args){
		System.out.println("How many birds?\t");
		Scanner in = new Scanner(System.in);

		int numBirds = in.nextInt();

		Bird[] birdList = new Bird[numBirds];

		for(int i = 0; i < birdList.length; i++){
			birdList[i] = new SnowyOwl();
		}



		BirdSanctuary sanct = new BirdSanctuary(birdList);

		sanct.allEat();

	}
}