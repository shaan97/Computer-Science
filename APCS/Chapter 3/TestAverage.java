/*Shaan Mathur
  Period 4
  Assignment: In class 10/30/14
*/

import java.util.Scanner;

public class TestAverage{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("This program averages test scores.");
		System.out.print("For how many student do you have scores? ");
		int numStud = in.nextInt();
		System.out.print("How many test scores does each student have? ");
		int numTest = in.nextInt();
		for(int j=1; numStud>=j; j++){
			double x = Math.round((double)AskScore(numTest,j)*100.0/100.0);
			System.out.println("The average score for student "+j+" is "+(x/numTest));
			System.out.println();
		}
	}
	public static int AskScore(int test,int student){
		int z=0;
		for(int i=1; test>=i; i++){
			Scanner in = new Scanner(System.in);
			System.out.print("Enter score "+i+" for student "+student+": ");
			z+=in.nextInt();
		}
		return z;
	}
}
