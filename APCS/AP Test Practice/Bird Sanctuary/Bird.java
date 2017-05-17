public abstract class Bird{

	private String myName;
	private String myNoise;

	public Bird(String name, String noise){
		myName = name;
		myNoise = noise;
	}

	public String getName(){
		return myName;
	}

	public String getNoise(){
		return myNoise;
	}

	public abstract String getFood();

}