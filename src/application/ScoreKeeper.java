package application;

import java.awt.Label;

public class ScoreKeeper {
	public static int humanScore;
	public static int ComputerScore;
	
	ScoreKeeper() {
		humanScore = 0;
		ComputerScore = 0;
	}
	
	/**---------------------------------------------------------------------------------
	 * when called, add one to the human's score
	 * ---------------------------------------------------------------------------------
	 */
	public static void humanWin() {
		humanScore += 1;
	}
	/**---------------------------------------------------------------------------------
	 * when called, add one to the Computer's score
	 * ---------------------------------------------------------------------------------
	 */
	public static void compWin() {
		ComputerScore += 1;
	}
	
	/**---------------------------------------------------------------------------------
	 * Return the Human's Score
	 * ---------------------------------------------------------------------------------
	 */
	public static int getScoreH() {
		return humanScore;
	}
	
	/**---------------------------------------------------------------------------------
	 * Return the Computer's Score
	 * ---------------------------------------------------------------------------------
	 */
	public static int getScoreC() {
		return ComputerScore;
	}
	
}
