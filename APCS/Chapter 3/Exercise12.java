/*Shaan Mathur
Per. 4
Exercise 12*/

import java.util.Scanner;

public class Exercise12{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter text:");
		String s1 = in.nextLine();
		System.out.println();
		vertical(s1);
	}
	public static void vertical(String s1){
		//Prints the text vertically
		int x = s1.length();
		for(int i=0;x>i;i++){
			char y = s1.charAt(i);
			System.out.println(y);
		}

	}


}