public class Turtle extends Animal{

	private int timeCount;

	public Turtle(){
		super();
		this.dominance = 1;
		this.timeCount = 0;
	}

	public Turtle(Point start){
		super(start);
		this.dominance = 1;
		this.timeCount = 0;
	}

	@Override
	public void move(){
		if(timeCount % 2 == 0)
			super.move();
		timeCount++;
	}


	public String toString(){
		return "TURTLE";
	}

}