package application;

import javafx.scene.control.Button;

public class ComputerPlayer {	
	/**---------------------------------------------------------------------------------
	 * This will make the move of the Computer
	 * @param button
	 * @param coordArray
	 * @param gridArray
	 * ---------------------------------------------------------------------------------
	 */
	public static void compMove(Button[] button, int[][] coordArray, int[][] gridArray) {		
	/**---------------------------------------------------------------------------------
	 * The madeMove boolean will keep track of whether or not the computer has made a decision
	 * ---------------------------------------------------------------------------------
	 */
	boolean madeMove = false;
	
	/**---------------------------------------------------------------------------------
	 * Generate a number between 0 and 9
	 * ---------------------------------------------------------------------------------
	 */
	int y = (int) Math.floor(Math.random()*9);
	/**---------------------------------------------------------------------------------
	 * While the computer hasn't made a move and the board isn't full
	 * use the generated number to see whether or not the yth button has been chose yet, which will
	 * be referenced by its location in the Coordinate array
	 * If it hasn't been used in the gridarray, then draw an O in the space and set the space equal to 5
	 * which will be used to calculate the row, column, and cross sums.
	 * Since it has made a move, it will exit the while loop and set the turn to the player
	 * ---------------------------------------------------------------------------------
	 */
	while(madeMove == false && Board.isFull(gridArray) == false) {
		y = (int) Math.floor(Math.random()*9);
		if(gridArray[coordArray[y][0]][coordArray[y][1]] == 0) {
			gridArray[coordArray[y][0]][coordArray[y][1]] = 5;
			Board.drawO(button[y]);
			madeMove = true;
			}
		}
	Board.setTurn(false);
	}
}
