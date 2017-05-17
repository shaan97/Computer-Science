/*
Shaan Mathur
Period 4
APCS
Chapter 1 Project (#2)
Letter
*/

public class Letter {
	public static void main (String[] args) {
		//This is the main method. It calls mom, brother, and friend method,
		//each of which is its own letter.
		mom();
		System.out.println();
		brother();
		System.out.println();
		friend ();
	}
	public static void mom() {
		//The mom method organizes the different methods to construct a
		//letter for mom
		System.out.println("Dear mommy,");
		intro();
		school();
		money();
		bye();
	}
	public static void brother() {
		//The brother method organizes the different methods to construct
		//a letter for the brother
		System.out.println("Dear Devan,");
		intro();
		school();
		money();
		bye();
	}
	public static void friend() {
		//The friend method organizes the different methods to construct
		//a letter for a friend
		System.out.println("Dear bestie,");
		intro();
		love();
		lately();
		bye();
	}
	public static void intro() {
		//This is a generic intro to all letters
		System.out.println("Hey! How's it been? I haven't talked to" +
							"you in SO long. This is ridiculous!" +
							"\n Like how is this possible. Whaaaaaaat." +
							"Has it really been like a year? Wow!" +
							"\n The truth is I've really missed you!" +
							"I made this JUST FOR YOU!!!");
		System.out.println();
	}
	public static void love() {
		//This is a paragraph about my love life
		System.out.println("I GOT to tell you about my female game." +
							" If you know what I'm sayin'. ;)" +
							"\n You know how I've been going CRAZY" +
							" over that girl last year? Well she" +
							" likes me now!!!" +
							"\n She is so into me now, and its" +
							" really cute. Life is really good. :)");
		System.out.println();
	}
	public static void school() {
		//This is a paragraph about how school is going
		System.out.println("School has been pretty good. I mean, I " +
							"can't complain. Semester just started." +
							"\n So I can't really make any valid" +
							" complaints. So far I have A's for the" +
							" most part. \n But, like I said, it's" +
							" just the beginning. Hopefully I can" +
							" maintain!");
		System.out.println();
	}
	public static void lately() {
		//This is a paragraph about how things have been lately
		//(hobbies), and also quoting song lyrics
		System.out.println("\"Lately I've been... I've been losing " +
							"sleep. Dreaming about the things that " +
							"\n we could be. But baby I've been, " +
							"I've been praying hard. Said no more " +
							"counting dollars, we'll be " +
							"counting stars. We'll be counting" +
							"...stars.\"");
		System.out.println();
	}
	public static void money() {
		//This is a paragraph asking for money
		System.out.println("\"Cash to the left of me. Cash to the " +
							"right of me. Cash to the front of me. " +
							"Cash to the back of me. \n Cash be " +
							"the day for me. Cash be the night for " +
							"me. Cash all the time, making money " +
							"all the time.\" \n At least that would" +
							" be great if you could send me a " +
							"million dollars to Bank Account number" +
							"312-2342-2234. :)");
		System.out.println();
	}
	public static void bye() {
		//This is a generic ending for every letter
		System.out.println("Well now it's time for so long. But we'll " +
							"sing just one more song. Thanks for doing " +
							"your part. \n You sure are smart! Because " +
							"with me and you, and my friend Blue, we " +
							"can do AN-Y-THING. \n");
		System.out.println();
		System.out.println("That we wanna do. :)");
		System.out.println();
		System.out.println();
		System.out.println("Sincerely,");
		System.out.println("Shaan");
		System.out.println();
	}
}