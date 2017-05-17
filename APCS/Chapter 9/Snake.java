public class Snake extends Animal{

	public Snake(){
		super();
		this.dominance = 4;
	}

	public Snake(Point start){
		super(start);
		this.dominance = 4;
	}



	public String toString(){
		return "SNAKE";
	}

}