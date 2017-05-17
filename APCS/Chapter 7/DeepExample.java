import java.util.*;

public class DeepExample{
	public static void main(String[] args){
		int[][][] example = new int[5][5][5];
		for(int i = 0; i < 5 ; i++){
			example[i][0][0] = 1;
			example[0][i][0] = 2;
			example[0][0][i] = 3;
		}
		System.out.println(Arrays.deepToString(example));
	}
}