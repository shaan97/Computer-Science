/*Shaan Mathur
Per. 4
Exercise 9*/

import java.util.Scanner;

public class Exercise9{
	public static void main(String[] args){
		Scanner reggin = new Scanner(System.in);
		System.out.print("X1?\t");
		double x1=reggin.nextDouble();
		System.out.print("Y1?\t");
		double y1=reggin.nextDouble();
		System.out.print("X2?\t");
		double x2=reggin.nextDouble();
		System.out.print("Y2?\t");
		double y2=reggin.nextDouble();
		distance(x1, x2, y1, y2);
	}
	public static void distance(double x1, double x2, double y1, double y2){
		//Calculates the distance between two points
		double x = Math.pow((x2-x1),2);
		double y = Math.pow((y2-y1),2);
		double d = Math.sqrt(x+y);
		System.out.println("Distance is "+d);
	}
}