/*Shaan Mathur
Per. 4
Exercise 3*/


import java.util.Scanner;

public class Exercise3{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Base?\t");
		int x = in.nextInt();
		System.out.print("Power?\t");
		int y = in.nextInt();
		printPowersOfN(x,y);
	}
	public static void printPowersOfN(int x, int y){
		//Prints the powers of N
		for(int i = 0; y>=i; i++){
			System.out.print((int)Math.pow(x,i)+" ");
		}
		System.out.println();
	}
}