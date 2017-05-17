/*Shaan Mathur
Holcomb
APCS
Assignment: Pascal Triangle
December , 2014*/

import java.util.Scanner;

public class Pascal{
 	public static void main(String[] args){
		System.out.print("Enter number of rows for pascal triangle: ");
		Scanner console=new Scanner(System.in);
		int num=console.nextInt();
		for (int i = 0; i < num; i++){
			int c = 1;
				for(int j = 0;j < num-i; j++){ //spacing based on number user gave
					System.out.print("   ");
				}
				for(int k = 0; k <= i; k++){
					System.out.print("   ");
					System.out.print(c); //print c value
					System.out.print(" ");
					c = c * (i - k) / (k + 1); //find next c value
			   }
			System.out.println();
			System.out.println();
		}
		System.out.println();
	}
}
