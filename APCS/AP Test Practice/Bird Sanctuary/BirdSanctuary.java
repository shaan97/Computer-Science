public class BirdSanctuary{

	private Bird[] birdList;

	public BirdSanctuary(Bird[] birdList){
		this.birdList = birdList;
	}

	public void allEat(){
		for(int i = 0; i < this.birdList.length; i++){
			System.out.println(this.birdList[i].getName() + ":\t" + this.birdList[i].getFood());
		}
	}
}