import java.util.Random;
public class Question11{
	public static void main(String [] args){
		Random r = new Random();
		int h = 0;
		do{
			char ran = (char) ((Math.random() * 13) + 72);
				if(ran == 'T' || ran == 'H'){
					if(ran != 'H'){
						h = 0 ;
					}
					System.out.print(ran + " ");
					if(ran == 'H'){
						h++;
					}
				}
		}while(h <= 2);
		System.out.println("\nThree heads in a row! You Win");
	}
}