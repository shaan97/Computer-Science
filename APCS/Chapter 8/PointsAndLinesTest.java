public class PointsAndLinesTest{
	public static void main(String[] args){
		Point p1 = new Point();
		Point p2 = new Point(5,5);
		Line line1 = new Line(p1, p2);

		System.out.println(line1.getP1());
		System.out.println(line1.getP2());
		System.out.println(line1);


	}

}






class Line{
	private Point p1;
	private Point p2;

	public Line(Point p1, Point p2){
		this.p1 = p1;
		this.p2 = p2;

	}

	public Point getP1(){
		return p1;

	}

	public Point getP2(){
		return p2;

	}

	public String toString(){
		return "[" + p1.toString() + ", " + p2.toString() + "]";
	}


}

class Point{

	private double x;
	private double y;

	public Point(){
		this(0,0);
	}

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	public String toString(){
		String s1 = "(" + x + "," + y + ")";
		return s1;
	}

	public double distanceFromOrigin(){
		double result = Math.sqrt((this.x*this.x)+(this.y*this.y));
		return result;
	}

	public void translate(double dx, double dy){
		this.x += dx;
		this.y += dy;

	}
	public double distance(Object o){
		Point p1 = (Point) o;
		double dist = Math.sqrt(((this.x-p1.x)*(this.x-p1.x))+((this.y-p1.y)*(this.y-p1.y)));
		return dist;
	}

	public void setX(double x){
		this.x = x;


	}

	public void setY(double y){
		this.y = y;

	}



	public void setLocation(double x2, double y2){
		this.x = x2;
		this.y = y2;
	}

	public double getX(){
		return this.x;
	}

	public double getY(){
		return this.y;
	}

	public boolean equals(Object o){
		Point p2 = (Point) o;
		return this.x == p2.x && this.y == p2.y;
	}

	public double slope(Object o){
		Point p2 = (Point) o;
		return (p2.y - this.y)/(p2.x - this.x);
	}

	public Point midpoint(Object o){
		Point d1 = (Point) o;

		Point p2 = new Point((d1.x+this.x)/2, (d1.y+this.y)/2);
		return p2;
	}

	public boolean isCollinear(Object o, Object o2){
		Point p1 = (Point) o;
		Point p2 = (Point) o2;
		double m1, m2, b1, b2;
		m1 = (p1.y - this.y)/(p1.x - this.x);
		m2 = (p2.y - this.y)/(p2.x - this.x);
		b1 = p1.y - (m1*p1.x);
		b2 = p2.y - (m2*p2.y);

		if(m1 == m2 && b1 == b2){
			return true;
		}else{
			return false;
		}



	}
	public String equationOfLine(Object o){
		Point p1 = (Point) o;
		double deltaY = p1.y - this.y;
		double deltaX = p1.x - this.x;
		double m = deltaY/deltaX;
		double b = (this.y)-(m*this.x);
		if((int)deltaX != 1 && (int) deltaX != 0)
			return "y = (" + deltaY + "/" + deltaX + ")x + " + b;
		else if((int) deltaX == 0){
			return "x = " + this.x;
		}
		else{
			return "y = " + deltaY + "x + " + b;
		}





	}
}

