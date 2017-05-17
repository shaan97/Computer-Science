public class Chp2ex3{
	public static void main(String[] args){
		int num1 = 1, num2 = 1, x = 1;
		System.out.print(num1 + " "+ num2 + " ");
		for (int counter = 0; counter <= 12; counter++){
			x = num1 + num2;
			num1 = num2;
			num2 = x;
			System.out.print(x + " ");
		}
	}
}