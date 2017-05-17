import java.util.*;

public class PointListTest{
	public static void main(String[] args){
		ArrayList<Point> list = new ArrayList<Point>();

		for(int i = 0; i < 5; i++){
			int x1 = (int) (Math.random()*11);
			int y1 = (int) (Math.random()*11);


			list.add(new Point(x1,y1));
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}

}

