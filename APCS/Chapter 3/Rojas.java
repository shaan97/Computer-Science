public class Rojas{
	public static void main(String[] args){
		double num = numberOfSlaves(5000000);
		System.out.println("The number of slaves counted is " + num);
	}
	public static double numberOfSlaves(double x){
		double y = x*(3.0/5.0);
		return y;
	}
}
