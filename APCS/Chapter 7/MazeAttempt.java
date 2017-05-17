import java.util.*;

public class MazeAttempt{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Maze size?\t");
		int size = in.nextInt();
		char[][] maze = new char[size][size];
		drawMaze(maze,size);
		startPlayer(maze,size);
	}
	public static void drawMaze(char[][] maze, int size){
		for(int i = 0; i < size; i++){
			maze[i][0] = '|';
			maze[0][i] = '-';
			maze[(size-1)][i] = '-';
			maze[i][(size-1)] = '|';
		}
		for(int i = 0; i < ((size-2)*(size-2)); i++){
			int row = (int)(Math.random()*(size-2))+1;
			int column = (int)(Math.random()*(size-2))+1;
			maze[row][column] = 'X';
		}

		maze[1][1] = '*';

		for(int j = 0; j < size; j++){
			for(int x = 0; x < size; x++){
				System.out.print(maze[j][x] + "   ");
				if(x==(size-1)){
					System.out.println();
				}
			}
		}


	}

	public static void startPlayer(char[][] maze, int size){
		System.out.println("Use and enter the WASD keys to move. Type QUIT to quit.");
		Scanner console = new Scanner(System.in);
		String resp = console.next();

		int prevention = 0;
		int enemyRow = 0;
		int enemyColumn = 0;
		int points = 0;

			while(!resp.equals("QUIT") && !resp.equals("quit")){
				resp = resp.toUpperCase();
				int playerRow = 1;
				int playerColumn = 1;
				int enemyCount = 0;

				for(int a = 0; a < size; a++){
					for(int b = 0; b < size; b++){
						if(maze[a][b] == '*'){
							playerRow = a;
							playerColumn = b;
						}
					}
				}



					if(resp.equals("W")){
						maze[playerRow][playerColumn] = '\0';
						if(maze[playerRow-1][playerColumn]=='X'){
							points++;
						}
						maze[playerRow-1][playerColumn] = '*';
					}else if(resp.equals("A")){
						maze[playerRow][playerColumn] = '\0';
						if(maze[playerRow][playerColumn-1]=='X'){
							points++;
						}
						maze[playerRow][playerColumn-1] = '*';
					}else if(resp.equals("S")){
						maze[playerRow][playerColumn] = '\0';
						if(maze[playerRow+1][playerColumn]=='X'){
							points++;
						}
						maze[playerRow+1][playerColumn] = '*';
					}else if(resp.equals("D")){
						maze[playerRow][playerColumn] = '\0';
						if(maze[playerRow][playerColumn+1]=='X'){
							points++;
						}
						maze[playerRow][playerColumn+1] = '*';
					}else{
						System.out.println("Invalid Response");

					}

					if(prevention == 0){
						enemyRow = (int)(Math.random()*(size-2))+1;
						enemyColumn = (int)(Math.random()*(size-2))+1;
						maze[enemyRow][enemyColumn] = '^';

					}

					if((enemyCount%2)==0){
						if(enemyColumn > playerColumn){
							maze[enemyRow][enemyColumn] = '\0';
							enemyColumn--;
							maze[enemyRow][enemyColumn] = '<';
						}else if(enemyColumn < playerColumn){
							maze[enemyRow][enemyColumn] = '\0';
							enemyColumn++;
							maze[enemyRow][enemyColumn] = '>';
						}else if(enemyColumn == playerColumn){
							enemyCount++;
						}
					}
					if((enemyCount%2)!=0){



						if(enemyRow > playerRow){
							maze[enemyRow][enemyColumn] = '\0';
							enemyRow--;
							maze[enemyRow][enemyColumn] = '^';
						}else if(enemyRow < playerRow){
							maze[enemyRow][enemyColumn] = '\0';
							enemyRow++;
							maze[enemyRow][enemyColumn] = 'v';
						}else if(enemyRow == playerRow){
							enemyCount++;
							if(enemyColumn > playerColumn){
								maze[enemyRow][enemyColumn] = '\0';
								enemyColumn--;
								maze[enemyRow][enemyColumn] = '<';
							}else if(enemyColumn < playerColumn){
								maze[enemyRow][enemyColumn] = '\0';
								enemyColumn++;
								maze[enemyRow][enemyColumn] = '>';
							}else if(enemyColumn == playerColumn){
								enemyCount++;
							}
						}
					}


					for(int j = 0; j < size; j++){
						for(int x = 0; x < size; x++){
							System.out.print(maze[j][x] + "   ");
							if(x==(size-1)){
								System.out.println();
							}
						}
					}
				prevention++;
				enemyCount++;
				resp = console.next();
			}
			System.out.println("You scored: " + points + " points!");


	}
}

