/*Shaan Mathur
  Holcomb
  APCS
  January 5, 2015

  Programming Project Guessing Game
 */


import java.util.Scanner;

public class CompGuess{
	public static void main(String[] args){
		System.out.println("Think of a number between 1-10, and I'll guess it!\n");
		int count = guess();
		System.out.println("And it only took me " + count + " tries!");
	}


	public static int guess(){
	//Actual method that guesses

		int high = 10;
		int low = 1;
		String confirm;
		int count = 0;


		do{
			int guess = (int)(Math.random()*((high-low)+1))+low;
			System.out.print("Is it " + guess + "? y/n\t");
			Scanner in = new Scanner(System.in);
			confirm = in.next();
			while(!confirm.equals("y") && !confirm.equals("n")){
				System.out.println("Please give a y/n\t");
				confirm = in.next();
			}

			//following code adjusts domain
			if(confirm.equals("n")){

				System.out.println("High or Low? h/l \t");
				String domResponse = in.next();

				while(!domResponse.equals("h") && !domResponse.equals("l")){
					System.out.println("Please give a h/l \t");
					domResponse = in.next();
				}

				if(domResponse.equals("h")){
					high = guess;
				}else if(domResponse.equals("l")){
					low = guess;
				}
			}
			count++;
		}while(!confirm.equals("y"));
		return count;
	}
}