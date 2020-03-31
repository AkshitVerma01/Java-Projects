/**
 * 
 */
package rockPaperScissor;

import java.util.Scanner;

/**
 * @author sverm_000
 * 
 */
public class FinallyPlayingThis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Input to do comp vs comp
		// Input to do human vs comp
		Scanner look = new Scanner(System.in);
		int counter = 0;
		int gameChoice = 0;

		System.out.println("Do you want to test computer vs computer(0) or human vs computer(1)?");
		gameChoice = look.nextInt();
		char quit = ' ';

		// Create objects of that instance
		ShowTime hakunaMatata = new ShowTime();
		ShowTime hope = new ShowTime();

		switch (gameChoice) {
		case 0:
			System.out.println("How many games you wanna play? " + "\n");
			counter = look.nextInt();

			for (int i = 0; i < counter; i++) {
				hakunaMatata.playTime();

			}

			look.close();
			System.out.println(" ");
			hakunaMatata.displayResults();
			hakunaMatata.displayAverages();
			break;

		case 1:
			Scanner boi = new Scanner(System.in);
			while (quit != 'Q') {
				hope.humanRights();

				System.out.println("Enter whatever key, or press Q to quit");
				quit = boi.nextLine().toUpperCase().charAt(0);
			}
			boi.close();

			hope.displayResults();
			System.out.println(" ");
			hope.displayAverages();
		}
	}
}
