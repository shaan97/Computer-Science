import java.io.*;
import java.util.Scanner;

public class CreateFiles{
	public static void main(String[] args) throws FileNotFoundException	{
		File f = new File("example.txt");
		Scanner text = new Scanner(f);
		File f2 = new File("example2.txt");
		PrintStream output = new PrintStream(f2);

		double data = 0, prev = 0;
		int count = 0;

		while(text.hasNext()){
			if(text.hasNextDouble()){
				data = text.nextDouble();
				output.print(data + "\tAverage With Previous:\t");
				if(count == 0)
					output.println("N/A");
				else
					output.println( (data + prev) / 2 );
				prev = data;
				count++;
			}else{
				output.print(text.next() + ":\t");
			}

		}
		text.close();
		output.close();

		System.out.println("Exists?\t" + f.exists());
		boolean fIsDeleted = f.delete();
		System.out.println(fIsDeleted);
			if(fIsDeleted){
				System.out.println("Success!");
				System.out.println(f2.renameTo(f));
			}

	}

}