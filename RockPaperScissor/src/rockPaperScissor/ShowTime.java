package rockPaperScissor;

import java.util.Scanner;

public class ShowTime {
	// Rock, paper, scissor
	int choice[] = { 0, 1, 2 };

	// Win, lose, Draw
	int result[] = { 0, 1, 2 };

	// First parameter is playerID
	// The second parameter is 0 for strat 1, 1 for strat 2, 2 for random
	// 0 and 1 = strat1 vs strat2
	// 0 and 2 equal strat1 vs random
	// 1 and 2 equal strat2 vs random
	static ThingsThatKill p1 = new ThingsThatKill(0, 2);
	static ThingsThatKill p2 = new ThingsThatKill(1, 2);

	// Object of strategyID
	ThingsThatKill sID = new ThingsThatKill(0, 0);

	private int player1Choice;
	private int player2Choice;

	int player1OldChoice = -1;
	int player2OldChoice = -1;
	int lastWin = -1;
	int resultIs = -1;

	// Division of two ints returns a double, therefore assign double type
	private double wins;
	private double lose;
	private double draw;

	/**
	 * Get the choice for player 1 and 2, then use those and send them to the score
	 * method for comparison
	 */
	public void playTime() {
		// Where it runs the actual game

		// Player 1 and 2 choice dependent on the old choices due to strats
		// Its random because of round 1, last int values are enemyID
		player1Choice = ThingsThatKill.getChoice(player1OldChoice, player2OldChoice, lastWin, 0);
		player2Choice = ThingsThatKill.getChoice(player2OldChoice, player1OldChoice, lastWin, 1);

		// After everytime, the current choice becomes old choice
		player1OldChoice = player1Choice;
		player2OldChoice = player2Choice;

		// Result is the return of the score method, basically tells if i won or not
		// Lastwin is then the result of that round, used for the next round for strat
		resultIs = score();
		lastWin = resultIs;

		// What beat what (0-Rock, 1-Paper, 2-Scissors)
		whatHappened();

	}

	/**
	 * 
	 */
	public void humanRights() {
		// Me vs computer who uses the best strategy
		// Player 2 is the bot
		player2Choice = ThingsThatKill.getChoice(player2OldChoice, player1OldChoice, lastWin, 0);

		// Takes the input of the user and makes it my choice
		Scanner hope = new Scanner(System.in);
		System.out.println("\nChoose what you want to play this round: r-Rock, p-Paper, s-Scissors");
		String input = hope.nextLine();
		hope.close();

		if (input.contains("r") || input.contains("s") || input.contains("p")) {
			while (input.contains("r") || input.contains("s") || input.contains("p")) {
				if (input.equals("s")) {
					player1Choice = choice[2];
				} else if (input.contentEquals("r")) {
					player1Choice = choice[0];
				} else if (input.contentEquals("p")) {
					player1Choice = choice[1];
				}

				player1OldChoice = player1Choice;
				player2OldChoice = player2Choice;

				resultIs = score();
				lastWin = resultIs;
				whatHappened();
				break;
			}
		} else {
			System.out.println("Pick r, p or s. Be smart and do the right thing!");
		}

	}

	/**
	 * 
	 * @return
	 */
	private int score() {
		// Checks who won based from my perspective
		if (player1Choice == player2Choice) {
			return result[2];
		}

		switch (player1Choice) {
		case 0:
			if (player2Choice == choice[1]) {
				return result[0];
			} else
				return result[1];

		case 1:
			if (player2Choice == choice[2]) {
				return result[0];
			} else
				return result[1];

		case 2:
			if (player2Choice == choice[0]) {
				return result[0];
			} else
				return result[1];

		}

		// Expects a return statement so adding this
		// Never will reach this section as something from above must come true
		// making anything after that irrelevant
		return result[1];

	}

	/**
	 * 
	 */
	private void whatHappened() {
		// Shows what beat what at every run
		switch (resultIs) {
		case 0:
			System.out.println(player1Choice + " loses to " + player2Choice + ". You lose!");
			lose++;
			break;

		case 1:
			System.out.println(player1Choice + " beats " + player2Choice + ". You win!");
			wins++;
			break;

		case 2:
			System.out.println(player1Choice + " equals  " + player2Choice + ". It's a draw!");
			draw++;
			break;
		}

	}

	/**
	 * 
	 */
	public void displayResults() {
		System.out.println("You have played " + (wins + draw + lose) + " games!");
		System.out.println("You have won " + wins + " games!");
		System.out.println("You have lost " + lose + " games!");
		System.out.println("You have tied " + draw + " games!");
	}

	/**
	 * 
	 */
	public void displayAverages() {
		System.out.println("\n" + "You won on an average of " + (wins / (wins + draw + lose) * 100) + "%");
		System.out.println("You lost on an average of " + (lose / (wins + draw + lose) * 100) + "%");
		System.out.println("You drew on an average of " + (draw / (wins + draw + lose) * 100) + "%");
	}
}
