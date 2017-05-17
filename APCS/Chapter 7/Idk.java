import java.util.*;

public class Idk{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int x = (int) ((Math.random()*10)+1);
		int[] poopLength = new int[x];

		for(int i = 0; i<x; i++){
			System.out.print("How big is your poop today? Day " + (i+1) + "?\t");
			poopLength[i] = in.nextInt();
		}
		int counter = 0;
		for(int n : poopLength){
			if(n>5){
				counter++;
			}
		}
		System.out.
		println("Your poop was large on " + counter + "
		days");
	}
}