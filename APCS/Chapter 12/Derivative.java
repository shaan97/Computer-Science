import java.util.Scanner;

public class Derivative{

	public static String[][] trig = new String[3][2];
	trig[][1] = {"sin","cos","tan"};
	trig[][2] = {"-cos","sin","sec^2"};

	public static String derive(String f){

		for(int i = 0; i < f.length(); i++){
			if(f.charAt(i) == '^'){
				return powerRule(f,i + 1);
			}
			if((i+3) <= f.length()){

			}
		}

		Scanner in = new Scanner(f);
		if(in.hasNextInt())
			return "0";
		Scanner check = new Scanner(f.substring(f.length()-1));
		if(!(check.hasNextInt()))
			return powerRule(f + "^1", f.length() + 1);

		return "";
	}

	//Expected input String: "cx^n" where c and n are integers
	private static String powerRule(String f, int i){
		int n = Integer.parseInt(f.substring(i));
		int c = 1;
		try{
			c = Integer.parseInt(f.substring(0, i - 2));
		}catch(Exception e){};

		if(n > 2 || n < 0)
			return "" + (c*n) + f.substring(i - 2, i) + (n-1);
		else if(n == 1)
			return "" + c;
		else if(n == 2)
			return "" + (c*n) + f.charAt(i-2);
		else
			return "0";



	}


}