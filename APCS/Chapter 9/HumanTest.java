class Human{
	private String eyeColor;
	private int teeth;
	private boolean isAttractive;
	private boolean hasSTD;

	public Human(String eyeColor, int teeth, boolean isAttractive, boolean hasSTD){
		this.eyeColor = eyeColor;
		this.teeth = teeth;
		this.isAttractive = isAttractive;
		this.hasSTD = hasSTD;
	}

	public Human(){
		int x = (int)(Math.random()*2)+1;
		boolean y = false;
		if(x == 1)
			y = true;
		else if(x == 2)
			y = false;
		this.eyeColor = "black";
		this.teeth = 32;
		this.isAttractive = true;
		this.hasSTD = y;
	}

	public String getEyeColor(){
		return this.eyeColor;
	}

	public int getTeeth(){
		return this.teeth;
	}

	public boolean isAttractive(){
		return this.isAttractive;
	}

	public boolean hasSTD(){
		return this.hasSTD;
	}

	public void receiveSTD(){
		this.hasSTD = true;
	}
}

class Male extends Human{
	private int dickLength;
	private int numberOfBalls;


	public Male(int dickLength, int numberOfBalls){
		this.dickLength = dickLength;
		this.numberOfBalls = numberOfBalls;
	}

	public int getDickLength(){
		return this.dickLength;
	}

	public int getNumberOfBalls(){
		return this.numberOfBalls;
	}

	public void fuckFemale(Female f1){
		if(f1.isHorny() == true){
			System.out.println("They fucked.");
			if(f1.hasSTD() == true){
				this.receiveSTD();
				f1.receiveSTD();
				System.out.println("But got an STD");
			}
		}
	}


}

class Female extends Human{
	private String cupSize;
	private boolean isHorny;

	public Female(String cupSize, boolean isHorny){
		this.cupSize = cupSize;
		this.isHorny = isHorny;
	}

	public String getCupSize(){
		return this.cupSize;
	}

	public boolean isHorny(){
		return this.isHorny;
	}


}

public class HumanTest{
	public static void main(String[] args){
		Human harsh = new Male(-2,1);
		Male harsh2 = (Male) harsh;
		System.out.println(harsh2.getDickLength());

	}

}


