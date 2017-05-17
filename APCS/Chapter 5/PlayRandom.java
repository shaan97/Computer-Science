import java.util.Scanner;

public class PlayRandom{
	public static void main(String[] args){
		int superCounter = 0;
		int counter;
		do{
			counter = yahtzee();
			superCounter++;
		}while(counter!=1);
		System.out.println("You did it. Wow. After " + superCounter + " times.");


	}
	public static int yahtzee(){

		int counter = 0;


				int d1;
				int d2;
				int d3;
				int d4;
				int d5;


				do{
					d1 = (int) (Math.random()*6)+1;
					d2 = (int) (Math.random()*6)+1;
					d3 = (int) (Math.random()*6)+1;
					d4 = (int) (Math.random()*6)+1;
					d5 = (int) (Math.random()*6)+1;

					counter++;

				}while(d1!=6 || d2!=6 || d3!=6 || d4!=6 || d5!=6);



				return counter;
		}
}