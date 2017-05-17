public class Wolf extends Animal{

	private int bounceCount;

	public Wolf(){
		super();
		this.dominance = 9;
	}

	public Wolf(Point start){
		super(start);
		this.dominance = 9;
	}

	@Override
	public void move(){
		if(location.getY() == 0){
			location.translate(0,1);
			bounceCount++;
		}else if(location.getY() == gridSide){
			location.translate(0,-1);
			bounceCount++;
		}else if(bounceCount % 2 == 0){
			location.translate(0,1);
		}else if(bounceCount % 2 == 1){
			location.translate(0,-1);
		}

	}

	public String toString(){
		return "WOLF";
	}

}