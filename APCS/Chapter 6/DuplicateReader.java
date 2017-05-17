import java.util.Scanner;
import java.io.*;

public class DuplicateReader{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(System.in);

		System.out.println("What file?\t");
		Scanner text = new Scanner(new File(in.next()));

		printDuplicates(text);
	}

	public static void printDuplicates(Scanner text){
		while(text.hasNextLine()){
			String line = text.nextLine();
			Scanner readLine = new Scanner(line);

			int count = 1;
			String word = "";
			if(readLine.hasNext())
				word = readLine.next();
			String next = "";
			while(readLine.hasNext()){
				next = readLine.next();
				if(word.equals(next))
					count++;
				else if(count > 1){
					System.out.print(word + "*" + count + "\t");
					word = next;
					count = 1;
				}else{
					word = next;
					count = 1;
				}
			}
			if(count > 1)
				System.out.print(word + "*" + count + "\t");
			System.out.println();
		}
	}
}