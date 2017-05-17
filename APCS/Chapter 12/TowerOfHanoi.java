import java.util.Scanner;

public class TowerOfHanoi{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("How many pegs?\t");
		char a = 'A';
		char b = 'B';
		char c = 'C';

		hanoi(in.nextInt(), a, b, c);
	}

	public static void hanoi(int numPegs, char start, char temp, char end){
		if(numPegs == 1){
			moveDisk(numPegs, start, end);
		}else{
			hanoi(numPegs - 1, start, end, temp);
			moveDisk(numPegs, start, end);
			hanoi(numPegs - 1, temp, start, end);
		}
	}

	public static void moveDisk(int peg, char start, char end){
		System.out.println("Move peg " + peg + " from " + start + " to " + end);
	}


}