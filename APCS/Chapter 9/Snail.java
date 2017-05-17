public class Snail extends Animal{

	private int timeCount;

	public Snail(){
		super();
		this.dominance = 0;
		this.timeCount = 0;
	}

	public Snail(Point start){
		super(start);
		this.dominance = 0;
		this.timeCount = 0;
	}

	@Override
	public void move(){
		if(timeCount % 5 == 0)
			super.move();
		timeCount++;
	}

	public String toString(){
		return "SNAIL";
	}

}