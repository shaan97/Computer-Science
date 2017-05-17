import java.util.Scanner;
import java.io.*;

public class ReadHours{
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("hours.txt");
		Scanner readLine = new Scanner(f);
		PrintStream file = new PrintStream(new File("newFile.txt"));

		while(readLine.hasNextLine()){
			String line = readLine.nextLine();
			Scanner inline = new Scanner(line);

			int id = inline.nextInt();
			String name = inline.next();

			double sum = 0;
			int count = 0;

			while(inline.hasNextDouble()){

				sum += inline.nextDouble();
				count++;
			}

			sum = ((int) (sum * 100))/100.0;
			file.println(name + " (ID#" + id + ")" + "worked " + sum + " hours (" + (sum/count) + " hours/day)\n");
		}
	}
}