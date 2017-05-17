import java.util.Scanner;

public class AnimalFarm{
	static String[] deaths;
	static int grossDeath = 0;


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		System.out.println("Main Menu:");
		System.out.print("How many animals?\t");
		int numAn = in.nextInt();
		Animal[] animal = new Animal[numAn];
		deaths = new String[numAn - 1];

		for(int i = 0; i < animal.length; i++){
			System.out.print("Select animal. (1) Lion (2) Snail (3) Rabbit (4) Bird (5) Turtle (6) Snake (7) Turtle (8) Wolf\t");
			animal[i] = select(in.nextInt());
		}




		boolean death = false;
		do{
			death = play(animal);
		}while(death == false);


		System.out.println("Congratulations! You finished the simulation!");
		for(int i = 0; i < animal.length; i++){
			if(animal[i] != null)
				System.out.println(animal[i] + " is at Point " + animal[i].getLocation());
		}
		for(int j = 0; j < deaths.length; j++){
			System.out.println(deaths[j]);
		}

	}

	public static Animal select(int x){
		switch(x){
			case 1:		return new Lion(randPoint());

			case 2:		return new Snail(randPoint());

			case 3:		return new Rabbit(randPoint());

			case 4:		return new Bird(randPoint());

			case 5:		return new Turtle(randPoint());

			case 6:		return new Snake(randPoint());

			case 7:		return new Turtle(randPoint());

			case 8:		return new Wolf(randPoint());

			default:	throw new IllegalArgumentException();


		}


	}

	private static Point randPoint(){
		return new Point((int)(Math.random()*(Animal.gridSide)), (int)(Math.random()*(Animal.gridSide)));

	}

	//DEPRECATED CODE
	/*public static Point askLocation(String s1){
		Scanner in = new Scanner(System.in);
		System.out.print(s1 + " start location x-coordinate:\t");
		int x = in.nextInt();
		System.out.print(s1 + " start location y-coordinate:\t");
		int y = in.nextInt();

		return new Point(x,y);
	}*/

	public static boolean play(Animal[] animal){


		for(int i = 0; i < animal.length; i++){
			for(int j = 0; j < animal.length; j++){
				//Check to see if there is overlap with animal[i] and animal[j]. If so, find which dies and set object reference to null.
				if(animal[i] != null && animal[j] != null && (i != j)){
					if((animal[i].killCheck(animal[j]))){
						Animal a = animal[i].whichDied(animal[j]);
						Animal b = animal[i].whichDidNotDie(animal[j]);

						deaths[grossDeath] = a + " died at " + a.getLocation() + ". Killed by " + b;
						grossDeath++;
						if( a == animal[i] )
							animal[i] = null;
						else
							animal[j] = null;
					}

				}


			}

		}


		for(int i = 0; i < animal.length; i++){
			if(animal[i] != null)
				animal[i].move();
		}


		if(grossDeath == (animal.length - 1)){
			return true;
		}
		return false;

	}
}