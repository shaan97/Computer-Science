import java.util.Scanner;

public class JavaCalculator{
	public static void main(String[] args){
		Scanner calc = new Scanner(System.in);
		System.out.println("First number please.");
		double x = calc.nextDouble();
		System.out.println("Second number please.");
		double y = calc.nextDouble();
		System.out.println("Enter the corresponding number \n"+
							"1.Add | 2.Subtract | 3.Multiply | 4.Divide?");
		int selec = calc.nextInt();
		if(selec==1){
			System.out.println(x+y);
		}else if(selec==2){
			System.out.println(x-y);
		}else if(selec==3){
			System.out.println(x*y);
		}else if(selec==4){
			System.out.println(x/y);
		}
	}
}