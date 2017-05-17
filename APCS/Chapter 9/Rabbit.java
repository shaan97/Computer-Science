public class Rabbit extends Animal{

	private int bounceCount;

	public Rabbit(){
		super();
		this.dominance = 3;
	}

	public Rabbit(Point start){
		super(start);
		this.dominance = 3;
	}

	@Override
	public void move(){
		if(location.getX() == 0){
			location.translate(1,0);
			bounceCount++;
		}else if(location.getX() == gridSide){
			location.translate(-1,0);
			bounceCount++;
		}else if(bounceCount % 2 == 0){
			location.translate(1,0);
		}else if(bounceCount % 2 == 1){
			location.translate(-1,0);
		}

	}

	public String toString(){
		return "RABBIT";
	}
}