import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        // Initiate a new Scanner
        Scanner userInputScanner = new Scanner(System.in);

        // Testing nextLine();
        System.out.print("\nWhat is your name? ");
        String name = userInputScanner.nextLine();

        // Testing nextInt();
        System.out.print("How many cats do you have? ");
        int numberOfCats = userInputScanner.nextInt();

        // Testing nextDouble();
        System.out.print("How much money is in your wallet? $");
        double moneyInWallet = userInputScanner.nextDouble();

        System.out.println("\nHello " + name + "! You have " + numberOfCats
                + (numberOfCats > 1 ? " cats" : " cat")
                + " and $" + moneyInWallet + " in your wallet.\n");
    }
}