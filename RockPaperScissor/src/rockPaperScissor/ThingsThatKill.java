package rockPaperScissor;

import java.util.Random;

public class ThingsThatKill {

	// Initializes everything
	static int pID = -1;
	static int sID = -1;
	static int choices[] = { 0, 1, 2 };
	public static boolean round1 = true;
	static int choice = -1;

	/**
	 * 
	 * @param ID
	 * @param sID
	 */
	public ThingsThatKill(int ID, int sID) {
		// Constructor
		// Same name as class name, MUST
		// Always returns objects of its own class
		// By adding return type, even void, it becomes a method and not a
		// constructor, therefore no return
		// Value of variables is set from passed parameters
		// At an instant
		pID = ID;
	}

	/**
	 * 
	 * @return Integer representation of the choice
	 */
	private static int draw() {
		// If i draw, do random
		Random rand = new Random();
		choice = rand.nextInt(3);

		return Math.abs(choice);
	}

	/**
	 * 
	 * @return
	 */
	public int getID() {
		return pID;
	}

	/**
	 * 
	 * @param playerOldChoice
	 * @param player2OldChoice
	 * @return
	 */
	private static int lose(int playerOldChoice, int player2OldChoice) {
		int choice = -1;
		// If i lose, do this according to the strategy number
		if (sID == 0) {
			for (int possibilities : choices) {
				if (playerOldChoice != possibilities && player2OldChoice != possibilities) {
					choice = possibilities;
				}
			}
		}
		if (sID == 1) {
			choice = player2OldChoice + 1;
		}
		if (sID == 2) {
			Random rand = new Random();
			choice = rand.nextInt(3);
			return choice;
		}

		return Math.abs(choice);
	}

	/**
	 * 
	 * @param playerOldChoice
	 * @param player2OldChoice
	 * @return
	 */
	private static int win(int playerOldChoice, int player2OldChoice) {
		// If i win, do this according to the strategy number
		int choice = -1;
		if (sID == 0) {
			choice = Math.abs(player2OldChoice);
		}
		if (sID == 1) {
			choice = playerOldChoice + 1;
		}
		if (sID == 2) {
			Random rand = new Random();
			choice = rand.nextInt(3);
			return choice;
		}
		return Math.abs(choice);
	}

	/**
	 * 
	 * @param playerOldChoice
	 * @param player2OldChoice
	 * @param prevWin
	 * @param enemyID
	 * @return
	 */
	public static int getChoice(int playerOldChoice, int player2OldChoice, int prevWin, int enemyID) {
		int choice = -2;

		// If i win
		if (prevWin == pID) {
			choice = win(playerOldChoice, player2OldChoice);

			// If i lose
		} else if (prevWin != pID && prevWin == enemyID) {
			choice = lose(playerOldChoice, player2OldChoice);

			// If its a draw
		} else if (prevWin != pID && prevWin != enemyID) {
			choice = draw();
		}

		// Checks for round one
		// If its round one, no strat can be applied so do random moves
		if (round1) {
			Random rand = new Random();
			choice = rand.nextInt(3);
			round1 = false;
		}

		return choice;

	}
}
