public class TestObject{
	public static void main(String[] args){
		Point p1 = new Point(19.99999999, 20.00000001);
		Point p2 = new Point(20.0, 20.0);

		Comparable a = max(p1,p2);

		if(a == null)
			System.out.println("Both are the same distance.");
		else
			System.out.println("Point " + a + " is farther.").

	}

	public static Comparable max(Comparable p1, Comparable p2){
		if(p1.compareTo(p2) > 1)
			return p1;
		else if(p1.compareTo(p2) == 0)
			return null;
		else
			return p2;

	}
}