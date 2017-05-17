class ColorGrid{
	private String[][] myPixels;
	private int myRows;
	private int myCols;



	public ColorGrid(String s, int numRows, int numCols){
		this.myRows = numRows;
		this.myCols = numCols;
		this.myPixels = new String[myRows][numCols];

		int count = 0;
		for(int i = 0; i < myRows; i++){
			for(int j = 0; j < numCols; j++){
				this.myPixels[i][j] = "" + s.charAt(count);
				count++;
			}
		}
	}

	public void printg(){
		for(int i = 0; i < this.myRows; i++){
			for(int j = 0; j < this.myCols; j++){
				System.out.print(myPixels[i][j]);
			}
			System.out.println();
		}
	}

	public void paintRegion(int row, int col, String newColor, String oldColor){
		if(row < myRows && row >= 0 && col < myCols && col >= 0){
			if( !(newColor.equals(oldColor)) && myPixels[row][col].equals(oldColor)){
				myPixels[row][col] = newColor;
				paintRegion(row - 1, col, newColor, oldColor);
				paintRegion(row + 1, col, newColor, oldColor);
				paintRegion(row, col - 1, newColor, oldColor);
				paintRegion(row, col + 1, newColor, oldColor);
			}
		}
	}
}

public class ColorTest{
	public static void main(String[] args){
		ColorGrid grid = new ColorGrid("rrrrrrrrr", 3, 3);
		grid.printg();
		System.out.println("After Test:");
		grid.paintRegion(0,0,"b","r");
		grid.printg();

	}
}