import java.io.*;
import java.util.Scanner;


public class SortVamaAnatomy{
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("vama.txt");


		sortFile(f);

	}

	public static void sortFile(File f) throws FileNotFoundException{
		Scanner read = new Scanner(f);
		PrintStream stream = new PrintStream(new File("wtf.txt"));

		int count = 0;

		while(read.hasNextLine()){

			String lineText = read.nextLine();
			Scanner line = new Scanner(lineText);

			String next = "";
			if(line.hasNext())
				next = line.next();

			if(next.equals("%")){
				count++;
				stream.print("\n" + count + ". " + lineText.substring(1));

			}else{
				stream.print("\n\t" + lineText);
			}



		}


	}
}