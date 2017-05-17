/*Shaan Mathur
Per. 4
Programming Project Spherical Distance*/

import java.util.Scanner;

public class SphericalDistance{
	public static final double RAD = 6372.795;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Provide coordinates as follows: ");
		System.out.println("[North degrees] [North minutes] " +
		"[West degrees] [West minutes]");
		System.out.println("\nFor instance:");
		System.out.println("36 7.2 86 40.2");
		System.out.println("\nWould be the equivalent of:");
		System.out.println("N 36 degrees 7.2 minutes, W 86 degrees "+
		"40.2 minutes");
		System.out.println("\n\n\n---------------------------------" +
		"----------------------------------");
		//Explanation on input format. This way, input is very quick,
		//without all of the annoying series of questions.

		System.out.print("\nFirst city name: ");
		String s1 = in.nextLine();
		System.out.print("Coordinates (follow guidelines above): ");
		int degN = in.nextInt();
		double minN = in.nextDouble();
		double x1 = degN + (minN/60);
		int degW = in.nextInt();
		double minW = in.nextDouble();
		double y1 = degW + (minW/60);
		//This chunk of code assigns values for the first city

		System.out.print("\nSecond city name: ");
		Scanner console = new Scanner(System.in);
		String s2 = console.nextLine();
		System.out.print("Coordinates (follow guidelines above): ");
		degN = console.nextInt();
		minN = console.nextDouble();
		double x2 = degN + (minN/60);
		degW = console.nextInt();
		minW = console.nextDouble();
		double y2 = degW + (minW/60);
		//This chunk of code assigns values for the second city

		x1 = Math.toRadians(x1);
		y1 = Math.toRadians(y1);
		x2 = Math.toRadians(x2);
		y2 = Math.toRadians(y2);
		//This converts the degrees into radians

		double longDiff = y2-y1;
		double prod1 = Math.sin(x1)*Math.sin(x2);
		double prod2 = Math.cos(x1)*Math.cos(x2)*Math.cos(longDiff);
		double angDiff = Math.acos(prod1+prod2);
		double distance = Math.round((RAD*angDiff)*1000)/1000.0;
		//The values are plugged into the complex equations

		System.out.println("\nThe distance between "+s1+" and "+s2+
		" is about\n"+Math.round(distance)+" kilometers "+
		"away, or "+(Math.round((distance*.62137119224))*100/100.)+" miles.");
		//Final output goes here.
	}
}
