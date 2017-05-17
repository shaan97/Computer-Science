public class ScrewYou{
	public static void main(String[] args){
		System.out.println(screwed(4,4));
	}

	public static int screwed(int x, int y){
		if(x == 0)
			return 1;
		if(y == 0)
			return 1;
		else
			return screwed( screwed(x-1,y-1), screwed(x-1,y-1) );


	}
}