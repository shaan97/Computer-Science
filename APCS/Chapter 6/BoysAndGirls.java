import java.io.*;
import java.util.Scanner;

public class BoysAndGirls{
	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("boys&girls.txt");
		Scanner text = new Scanner(file);

		int count = 0, boy = 0, girl = 0, boySum = 0, girlSum = 0;
		while(text.hasNext()){
			count++;
			if(count % 2 == 1){
				text.next();
				boySum += text.nextInt();
				boy++;
			}else{
				text.next();
				girlSum += text.nextInt();
				girl++;
			}
		}

		System.out.println("Number of boys:\t" + boy + "\nNumber of girls:\t" + girl + "\nDifference in sums:\t" + Math.abs(boySum - girlSum));
	}
}