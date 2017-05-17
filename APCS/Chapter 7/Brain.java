import java.util.*;

public class Brain{
	public static void main(String[] args){
		int[] hsm = new int[3];
		temperment(hsm);
		questionFeeling(hsm);
	}
	public static void temperment(int[] hsm){
		double sum = 0;
		do{
			sum = 0;
			for(int i = 0; i < hsm.length; i++){
				hsm[i] = (int) (Math.random()*100) + 1;
			}

			for(int i = 0; i < hsm.length; i++){
				sum+=hsm[i];
			}
		}while((sum!=100.0) && (hsm[0]-hsm[1] > 25 || hsm[0]-hsm[1] < -25));
		System.out.println(Arrays.toString(hsm));

	}

	public static void questionFeeling(int[] hsm){
		String s = "";
		for(int i = 0; i < 3;  i++){

			if(i==0){
				s = "happy";
			}else if(i==1){
				s = "sad";
			}else if(i ==2){
				s = "mad";
			}

			if(hsm[i] < 33){
				System.out.println("I'm not that " + s + " right now.");
			}
			else if(hsm[i] > 33 && hsm[i] < 66){
				System.out.println("I am sort of " + s + " right now.");
			}
			else if(hsm[i] > 66){
				System.out.println("I am very " + s + " right now!");
			}

		}
	}
}