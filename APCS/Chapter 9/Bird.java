public class Bird extends Animal{

	public Bird(){
		super();
		this.dominance = 2;
	}

	public Bird(Point start){
		super(start);
		this.dominance = 2;
	}



	public String toString(){
		return "BIRD";
	}

}