/*Shaan Mathur
Per. 4
Exercise 15*/

import java.util.Scanner;

public class Exercise15{
	public static void main(String[] args){
		System.out.print("Please enter your full name: ");
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		processName(s1,s2);
	}
	public static void processName(String s1, String s2){
		System.out.println("Your name in reverse order is "+ s2 + ", " + s1);
	}
}