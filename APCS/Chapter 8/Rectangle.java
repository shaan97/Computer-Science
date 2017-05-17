public class Rectangle{
	private double x;
	private double y;
	private int width;
	private int height;


	public Rectangle(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		if(width < 0 || height < 0){
			throw new IllegalArgumentException();
		}else{
			this.width = width;
			this.height = height;
		}
	}

	public Rectangle(Point p1, int width, int height){
		this.x = p1.getX();
		this.y = p1.getY();
		this.width = width;
		this.height = height;
	}
	public int getHeight(){
		return this.height;
	}

	public int getWidth(){
		return this.width;
	}

	public double getX(){
		return this.x;
	}

	public double getY(){
		return this.y;
	}

	public String toString(){
		return "Rectangle[x = " + this.x + ",y = " + this.y + ",width = " + this.width + ",height = " + this.height + "]";
	}



	}