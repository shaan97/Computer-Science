import java.util.*;

public class EmployeeHours{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("How many employees?\t");
		int numEmployees = in.nextInt();

		int[] hours = new int[(numEmployees)];
		double[] payRate = new double[(numEmployees)];

		for(int i = 0; i < hours.length; i++){
			System.out.print("Hours worked by employee #" + (i+1) + ":\t");
			hours[i] = in.nextInt();
			System.out.print("Hourly pay rate for employee #" + (i+1) + ":\t");
			payRate[i] = in.nextDouble();
		}

		System.out.println("Here is the gross pay for each employee:");

		for(int i = 0; i < hours.length; i++){
			double n = hours[i]*payRate[i];

			double brah = (double)(Math.round(n*100.0))/((100.0));
			System.out.println("Employee #" + (i+1) + ":  " + brah);
		}
	}
}
