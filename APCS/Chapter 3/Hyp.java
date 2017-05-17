public class Hyp{
	public static void main(String[] args){
		double x = 3;
		double y = 4;
		double c = findc(x,y);
		printZ(x,y,c);
		System.out.println("SWAG.");
	}
	public static double findc(double x, double y){
		double c = Math.hypot(x,y);
		return c;
	}
	public static void printZ(double x, double y, double c){
		System.out.println("The first leg is " + x);
		System.out.println("The second leg is " + y);
		System.out.println("The hypotenuse is " + c);
	}
}