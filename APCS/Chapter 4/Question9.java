import java.util.Scanner;
	public class Question9{
		public static void main(String [] args){
			Scanner in = new Scanner(System.in);
			System.out.print("Enter three values: ");
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();
			printTriangleType(x, y, z);

		}

		public static void printTriangleType(double x, double y, double z){
			if( (x + y) < z || (z + y) < x || (x + z) < y ){
				System.out.println("Illegal arguments");
			}
			else if( x == y && x == z && y == z){
				System.out.println("Equilateral");
			}
			else if( ( (x == y || x == z || y == z) && (x != y || x != z || y != z) ) ){
				System.out.println("Isosceles");
			}
			else if( x != y && z != y && z != x){
					System.out.println("Scalene");
			}
		}
	}


