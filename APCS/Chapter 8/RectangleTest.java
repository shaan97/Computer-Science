public class RectangleTest{
	public static void main(String[] args){
		Point p1 = new Point(5,5);
		Rectangle r1 = new Rectangle(p1,10,5);
		System.out.println("getHeight:\t" + r1.getHeight());
		System.out.println("getWidth:\t" + r1.getWidth());
		System.out.println("getX:\t\t" + r1.getX());
		System.out.println("getY:\t\t" + r1.getY());
		System.out.println(r1);

	}


}