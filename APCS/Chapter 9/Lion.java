public class Lion extends Animal{

	public Lion(){
		super();
		this.dominance = 10;
	}

	public Lion(Point start){
		super(start);
		this.dominance = 10;
	}


	public String toString(){
		return "LION";
	}
}