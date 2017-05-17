import java.io.*;

public class DeleteFiles{
	public static void main(String[] args){
		File file1 = new File("bleh.txt");
		File file2 = new File("blah.txt");

		if(file1.exists()){
			System.out.println(file1 + " exists. Renaming now.");
			System.out.println(file1.renameTo(new File("poopy.txt")));
		}

		if(file2.exists()){
			System.out.println(file2 + " exists. Deleting now.");
			System.out.println(file2.delete());
		}
	}
}