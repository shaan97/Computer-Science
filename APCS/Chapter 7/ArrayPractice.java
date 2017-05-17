import java.util.*;

public class ArrayPractice{
	public static void main(String[] args){
		int counter = 0;
		int supreme = 0;
		boolean test;
		int[] rand = new int[5];
		int[] rand2 = new int[5];
		do{
			counter = 0;
			do{
				for(int i = 0; i < rand.length; i++){
					rand[i] = (int)(Math.random()*10);
				}

				for(int i = 0; i < rand2.length; i++){
					rand2[i] = (int) (Math.random()*10);
				}
				test = Arrays.equals(rand,rand2);
				counter++;
			}while(test==false);
			supreme++;
		}while(counter==1);
		System.out.println("Took " + counter + " times.");
	}
}