import java.util.Scanner;
import java.io.*;

public class IntegerReader{
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("numbers.txt");
		evenNumbers(new Scanner(f));
	}

	public static void evenNumbers(Scanner stream){
		double count = 0, sum = 0, numEven = 0;
		while(stream.hasNextInt()){
			int num = stream.nextInt();
			count++;
			sum += num;

			if(num % 2 == 0)
				numEven++;

		}

		System.out.println(count + " numbers, sum = " + sum + "\n" + numEven + " evens + (" + ((numEven/count) * 100) + "%)");
	}

}