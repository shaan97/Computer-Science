import java.io.*;
import java.util.Scanner;

public class ReadData{
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("weather.txt");
		Scanner text = new Scanner(f);

		double first = text.nextDouble(), second;
		while(text.hasNextDouble()){
			second = text.nextDouble();
			System.out.println(first + " to " + second + ", change = " + Math.abs(first - second));
			first = second;
		}
	}
}