import java.util.Scanner;
	public class Question16{
		public static void main(String [] args){
			Scanner in = new Scanner(System.in);
			System.out.print("Enter (X, Y) cordinates: ");
			int x = in.nextInt();
			int y = in.nextInt();
			quadrant(x, y);
		}

		public static void quadrant(int x, int y){
			if( x >= 0 && y >= 0){
				System.out.println("Quadrant I");
			}
			else if( x <= 0 && y >= 0){
				System.out.println("Quadrant II");
			}
			else if( x <= 0 && y <= 0){
				System.out.println("Quadrant III");
			}
			else if( x >= 0 && y <= 0){
				System.out.println("Quadrant IV");
			}
			else{
				System.out.println("Enter valid numbers");
			}
		}
	}