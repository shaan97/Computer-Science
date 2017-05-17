import java.util.Scanner;
public class Question14{
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Type a number: ");
		int x = in.nextInt();
		System.out.print("\nType a number: ");
		int y = in.nextInt();
		System.out.print("\nType a number: ");
		int z = in.nextInt();
		int unq = numUnique(x,y,z);
		System.out.println(unq + " Unique numbers");

	}
	public static int numUnique( int x, int y, int z){
		if( x == y && x == z && y == z){
			return 0;
		}
		else if ( ((y == z|| x == y) && (x == z || z == y) ) && (y != z || x != z)){
			return 1;
		}
		else if( (x == y || x == z || y == z) && ((y != z || x != z) && (y != x || y != z)) ){
			return 2;
		}
		else if(x != y && x != z && y != z){
			return 3;
		}
		return 0;
	}
}
