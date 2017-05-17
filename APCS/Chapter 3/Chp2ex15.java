public class Chp2ex15{
	public static void main(String[] args){
		printDesgin();
	}

	public static void printDesgin(){
		int w = 1;
		for (int x = 1; x <= 5; x++){
			for (int y = 5; y >= x; y--){
				System.out.print("-");
			}
			for (int z = 1; z <= w; z++){
				System.out.print(w);
			}
			for (int y = 5; y >= x; y--){
               System.out.print("-");
			}
			w = w + 2;
			System.out.println();
		}
	}
}