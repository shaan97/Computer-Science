abstract class Animal implements Comparable{
	protected Point location;
	protected int dominance;
	protected int directionRight;
	protected int directionLeft;
	public static final int gridSide = 10;

	public Animal(){
		this(new Point(0,0));
	}

	public Animal(Point start){
		if(start.getX() < gridSide && start.getY() < gridSide)
			this.location = start;
		else
			throw new IllegalArgumentException();

	}

	public void move(){
		int leapVert, leapHoriz = 0;
		double checkX, checkY = 0;
		do{
			leapVert = (int)(Math.random()*3) - 1;
			leapHoriz = (int)(Math.random()*3) - 1;
			checkX = (this.location.getX() + leapHoriz);
			checkY = (this.location.getY() + leapVert);
		}while(checkX > gridSide || checkX < 0 || checkY > gridSide || checkY < 0);
		this.location.translate(leapHoriz,leapVert);
	}


	public int compareTo(Object b){
		if(this.dominance > ((Animal)b).dominance)
			return 1;
		else
			return -1;
	}

	public int getDominance(){
		return this.dominance;
	}

	public Point getLocation(){
		return this.location;
	}

	public boolean killCheck(Animal a){
		if((this.location.equals(a.location)) && !(this.toString().equals(a.toString())))
			return true;
		else
			return false;
	}

	public Animal whichDied(Animal a){
		if(this.compareTo(a) == 1)
			return a;
		else
			return this;
	}

	public Animal whichDidNotDie(Animal a){
		if(this.compareTo(a) == 1)
			return this;
		else
			return a;

	}

	public abstract String toString();
}