/*Shaan Mathur
Per. 4
Exercise 8*/

import java.util.Scanner;

public class Exercise8{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("What is a?\t");
		int a = in.nextInt();
		System.out.print("What is b?\t");
		int b = in.nextInt();
		System.out.print("What is c?\t");
		int c = in.nextInt();
		quadratic(a,b,c);
	}
	public static void quadratic(int a, int b, int c){
		//Calculates the values of x using the quadratic formula
		double x1 = ((-b+ Math.sqrt((Math.pow(b,2))-4*a*c))/(2*a));
		double x2 = ((-b- Math.sqrt((Math.pow(b,2))-4*a*c))/(2*a));
		System.out.println("x = "+x1+", x = "+x2);
	}
}
