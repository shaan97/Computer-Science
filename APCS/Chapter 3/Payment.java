import java.util.Scanner;

public class Payment{

	public static void main(String[] args){

		Scanner payNum = new Scanner(System.in);
		System.out.print("What is the current interest rate? \t");
		double rate = payNum.nextDouble();
		System.out.print("For how many months are you paying? \t");
		double pay = payNum.nextDouble();
		System.out.print("What is the loan amount? \t \t");
		double loan = payNum.nextDouble();
		while(rate < 0 || pay < 0 || loan < 0){
			System.out.println("GIVE ME THE RIGHT VALUES");
			System.out.print("What is the current interest rate? \t");
			rate = payNum.nextDouble();
			pay = payNum.nextDouble();
			loan = payNum.nextDouble();
		}
		System.out.println();
		double pment = monthlyPayment(pay,loan,rate);
		double p = (int) pment;
		printReport(pay, p, loan, rate);
	}
	public static double monthlyPayment(double n, double l,double rate){
		double exp = Math.pow((1+rate),n);
		double payment = ((rate*exp)/(exp-1))*l;
		return payment;
	}
	public static void printReport(double pay, double p, double loan, double rate){
		System.out.println("Loan Amount: \t \t \t $" + loan);
		System.out.println("Monthly Interest Rate: \t \t " + rate);
		System.out.println("Number of Payments: \t \t $" + pay);
		System.out.println("Monthly Payment: \t \t $" + p);
		System.out.println("Amount Paid Back: \t \t $" + pay*p);
		System.out.println("Interest Paid: \t \t \t $" + ((pay*p)-loan));
	}
}