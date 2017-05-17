import java.util.*;

public class Ex{
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);

		int count = 0;
		for(int i = list.size() - 1; i >= 0; i--){
			if(list.get(i)==2){
				list.remove(i);
				i--;
			}
		}

		System.out.println(list);
	}

}