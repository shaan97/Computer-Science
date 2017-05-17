/*
Rahil Bhatnagar
Period 4
APCS
Chapter 1 Project (question 2)
Letter project
*/


public class Chp1Project{
	public static void main(String[] args){
		family();
		brother();
		friend();
	}
	public static void family(){
		System.out.println("Dear, Family");
			common();
			moneypg();
			classpg();
			friendpg();
		System.out.println("sincerely, \nme");
		System.out.println();
		System.out.println();
	}
	public static void brother(){
		System.out.println("Dear, brother");
			common();
			friendpg();
			moneypg();
			hobbiepg();
		System.out.println("sincerely, \nme");
		System.out.println();
		System.out.println();
	}
	public static void friend(){
		System.out.println("Dear, friend");
			common();
			lovepg();
			classpg();
			hobbiepg();
		System.out.println("sincerely, \nme");
		System.out.println();
		System.out.println();
	}
	public static void common(){
		System.out.println();
				System.out.println("This is the common paragraph that all of you get.\n" +
				"I was so lazy to write out letters for all of you guys that i did it in java.\n" +
				"It is so much easier to do this whole program than to write all these letters.\n" +
				"Its like i mass produced these letters.");
		System.out.println();
	}
	public static void moneypg(){
		System.out.println();
				System.out.println("This is the paragraph about money.\nI really need some money to survive here at\n" +
				"this really boring camp that you have sent me to.\nI really wish I could have gone somewhere way cooler.\n"
				+"I mean I know you try to but seriously this place is super boring.");
		System.out.println();
	}
	public static void friendpg(){
		System.out.println();
				System.out.println("This is me telling you about me awesome friends!\nI met this really cool guy named Myself.\n" +
				"Myself and I have become very good friends we have bonded over our ablity to do nothing." +
				"Soon we will be going back home but till then i will just stay here and play with myself.\n");
		System.out.println();
	}
	public static void hobbiepg(){
		System.out.println();
				System.out.println("Hey guys these are my hobbies!\n" +
				"I have picked up an interest in paintball, Ice hockey, Water polo, and many other things.\n"
				+ "All of them are so much fun it is ridicoulous, I think i will start playing water polo when i get back."
				+ "I have really enjoyed playing and picking up these sports/hobbies.\n"
				+ "I also found a passion for coding and computers too!");
		System.out.println();
	}
	public static void classpg(){
		System.out.println();
				System.out.println("You wont believe how cool my classes are!\n" +
				"I have AP Physics, then Web Design, then AP Goverment, then AP CS, Precalc, and English!\n"
				+ "They are all such fun classes!");
		System.out.println();
	}
	public static void lovepg(){
		System.out.println();
				System.out.println("You wont believe who I have found.\n" +
				"I met this girl and we just hit it off, like no joke we are great together.\n" +
				"I am going to miss her when we all leave its gonna suck.\n" +
				"This was the best part of camp.\n");
		System.out.println();
	}


}