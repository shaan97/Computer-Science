public class SnowyOwl extends Owl{

	private static final String name = "Snowy owl";

	public SnowyOwl(){
		super(name);
	}

	public String getFood(){
		int select = (int)(Math.random()*3) + 1;

		if(select == 1)
			return "hare";
		else if(select == 2)
			return "lemming";
		else if(select == 3)
			return "small bird";
		else
			return null;
	}




}