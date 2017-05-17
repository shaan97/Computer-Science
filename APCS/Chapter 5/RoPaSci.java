/*Shaan Mathur
  Holcomb
  APCS
  January 5, 2015

  Programming Project Rock, Paper, Scissors
 */

import java.util.Scanner;

public class RoPaSci{
	public static void main(String[] args){
		System.out.print("Let's play rock-paper-scissors!\n\n");
		Scanner in = new Scanner(System.in);
		double rock = (1/3);
		double rockCount = 0;
		double paper = (1/3);
		double paperCount = 0;
		double scissors = (1/3);
		double scissorsCount = 0;
		double playCount = 0;
		String response;
		//Sets up selection probability with initial values of (1/3) probability
		//Sets up Counters to calculate probability based on user tendencies
		do{

			System.out.print("rock, paper or scissors?\t");
			String user = in.next();
			String comp = "";

			while(!user.equals("rock") && !user.equals("paper") && !user.equals("scissors")){
				System.out.print("Invalid response.\nrock, paper, or scissors?\t");
				user = in.next();
			}

			double x = (Math.random());
			if(x <= rock){
				comp = "paper";
			}else if(x > rock && x <= 1-scissors){
				comp = "scissors";
			}else if (x > (1-scissors)){
				comp = "rock";
			}

			if(user.equals(comp)){
				System.out.println("It's a tie. Let's try again");
			}else if((comp.equals("paper") && user.equals("rock")) || (comp.equals("rock") && user.equals("scissors")) || (comp.equals("scissors") && user.equals("paper"))){
				System.out.println("I win! I used " + comp +"! Let's try again.");
			}else if((comp.equals("rock") && user.equals("paper")) || (comp.equals("scissors") && user.equals("rock")) || (comp.equals("paper") && user.equals("scissors"))){
				System.out.println("You win :/... I used " + comp + "! Let's try again.");
			}

			playCount++;

			if(user.equals("rock")){
				rockCount++;
				rock = rockCount/playCount;
				paper = paperCount/playCount;
				scissors = scissorsCount/playCount;
			}else if(user.equals("paper")){
				paperCount++;
				rock = rockCount/playCount;
				paper = paperCount/playCount;
				scissors = scissorsCount/playCount;
			}else if(user.equals("scissors")){
				scissorsCount++;
				rock = rockCount/playCount;
				paper = paperCount/playCount;
				scissors = scissorsCount/playCount;
			}
			//Sets up next round's probabilities

			System.out.print("\nPlay again? Y for yes, N for no.\t");
			response = in.next();

			while(!response.equals("Y") && !response.equals("y") && !response.equals("N") && !response.equals("n")){
				System.out.print("Invalid response\t");
				response = in.next();
			}

		}while(response.equals("Y") || response.equals("y"));
	}
}