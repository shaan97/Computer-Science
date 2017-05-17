import java.io.*;
import java.util.Scanner;

public class FileAttempt {
	public static void main(String[] args)throws FileNotFoundException{
		File f = new File("example.txt");
		Scanner input = new Scanner(f);

		double data;
		double temp = 0;
		int count = 0;
		while(input.hasNext()){
			if(input.hasNextDouble()){
				data = input.nextDouble();
				System.out.print("First Data:\t" + data + "\tAverage with Previous:\t");
				if(count == 0)
					System.out.println("N/A");
				else
					System.out.println( (data + temp) / 2 );
				temp = data;
				count++;
			}else{
				System.out.print("\nName:\t" + input.next() + "\t");
			}
		}
	}
}