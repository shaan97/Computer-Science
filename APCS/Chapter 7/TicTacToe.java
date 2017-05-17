import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe{
	public static void main(String[] args){
		String[][] box = new String[5][5];
		Scanner in = new Scanner(System.in);
		drawGame(box);
		String s1 = "";
		String s2 = "";
		boolean win = false;
		int turn = 2;
		do{
			System.out.print("Where?\t");
			s1 = in.next();
			if(turn % 2 == 0){
				s2 = " X ";
			}else{
				s2 = " O ";
			}
			win = playGame(box,s1,s2);
			turn++;
		}while(win == false);
		System.out.println("Congrats!");
	}

	//Draws the tic-tac-toe board
	public static void drawGame(String[][] box){


		for(int i = 0; i < box.length; i++){
			for(int j = 0; j < box.length; j++){
				if(i % 2 == 1 ){
					box[i][j] = "__";
				}else{
					box[i][1] = "|";
					box[i][3] = "|";
				}
			}
		}

		for(int x = 0; x < box.length; x++){
			for(int y = 0; y < box.length; y++){
				if(box[x][y] == null){
					box[x][y] = "   ";
				}
				System.out.print(box[x][y]);
			}
			System.out.println();
		}
	}

	//Actual game is performed here
	public static boolean playGame(String[][] box, String s1, String s2){
		Scanner in = new Scanner(System.in);
		boolean confirm = true;
			do{
				confirm = true;
				s1 = s1.toUpperCase();
				s2 = s2.toUpperCase();

				//Controls
				if(s1.equals("TL")){
					box[0][0] = s2;
					confirm = true;
				}else if(s1.equals("TM")){
					box[0][2] = s2;
					confirm = true;
				}else if(s1.equals("TR")){
					box[0][4] = s2;
					confirm = true;
				}else if(s1.equals("ML")){
					box[2][0] = s2;
					confirm = true;
				}else if(s1.equals("M")){
					box[2][2] = s2;
					confirm = true;
				}else if(s1.equals("MR")){
					box[2][4] = s2;
					confirm = true;
				}else if(s1.equals("BL")){
					box[4][0] = s2;
					confirm = true;
				}else if(s1.equals("BM")){
					box[4][2] = s2;
					confirm = true;
				}else if(s1.equals("BR")){
					box[4][4] = s2;
					confirm = true;
				}else{
					System.out.println("Try Again");
					confirm = false;
					s1 = in.next();
				}
			}while(confirm == false);

			for(int i = 0; i < box.length; i++){
				for(int j = 0; j < box.length; j++){
					System.out.print(box[i][j]);
				}
				System.out.println();
			}

			//Three in a Row scenarios
			if(box[0][2] != "   "){
				if(box[0][0] == box[0][2] && box[0][2] == box[0][4])
					return true;
			}if(box[2][2] != "   "){
				if(box[2][0] == box[2][2] && box[2][2] == box[2][4])
					return true;
			}
			if(box[4][2] != "   "){
				if(box[4][0] == box[4][2] && box[4][2] == box[4][4])
					return true;
			}
			if(box[2][0] != "   "){
				if(box[0][0] == box[2][0] && box[2][0] == box[4][0])
					return true;
			}
			if(box[2][2] != "   "){
				if(box[0][2] == box[2][2] && box[2][2] == box[4][2])
					return true;
			}
			if(box[2][4] != "   "){
				if(box[0][4] == box[2][4] && box[2][4] == box[4][4])
					return true;
			}
			if(box[2][2] != "   "){
				if(box[0][0] == box[2][2] && box[2][2] == box[4][4])
					return true;
			}
			if(box[2][2] != "   "){
				if(box[0][4] == box[2][2] && box[2][2] == box[4][0])
					return true;
			}
			return false;





	}
}