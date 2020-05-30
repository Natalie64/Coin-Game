package coinGame.Common;

import java.util.Scanner;
import java.util.Random;
/**
 * Basic coin-toss game.
 * @author Natalie Williams
 * @version 1.1
 */
public class CoinGame {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Random randGen = new Random();
		int coinFace;	// Which face is facing up. 0 = Heads 1 = Tails
		String coinChoice;	// Tracks if the user chose heads or tails.
		String nextRound = "Y";	// Whether or not the player wishes to continue.
		
		while (nextRound.equals("Y")) {	// Loops the game until the player chooses to stop playing.
			System.out.print("Heads or tails? H = heads T = Tails\n>");
			coinChoice = scnr.next();
			
			coinFace = randGen.nextInt(2);
			switch (coinFace){
				case 0:
					if (coinChoice.equals("H")) {
						System.out.println("You win!");
					}
					else {
						System.out.println("You lose...");
					}
					break;
				
				case 1:
					if (coinChoice.equals("T")) {
						System.out.println("You win!");
					}
					else {
						System.out.println("You lose...");
					}
					break;
			}
			
			System.out.print("Play again? Y = Yes N = No\n>");
			nextRound = scnr.next();
		}

	}

}
