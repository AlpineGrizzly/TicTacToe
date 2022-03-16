package application;

import javafx.scene.control.Button;


public class Board {
	
	/**---------------------------------------------------------------------------------
	 * Boolean that will tell the game whose turn it is
	 * False meaning it is the Player's turn
	 * True meaning it is the Computer's turn
	 * ---------------------------------------------------------------------------------
	 */
	public static boolean whoseTurn;
	
	/**---------------------------------------------------------------------------------
	 * This will take the button that was pressed and check to see if it is avaible
	 * If it is, set the int array place to 1 and draw an X
	 * then make it the computer's turn
	 * @param pressed
	 * @param x
	 * @param y
	 * @param array
	 * ---------------------------------------------------------------------------------
	 */
	public static void wasPressed(Button pressed, int x, int y, int[][] array) {
		if(array[x][y] == 0) {
			array[x][y] = 1;
			drawX(pressed);	
			whoseTurn = true;
			} 
		} 
	/**---------------------------------------------------------------------------------
	 * Draw an X on the button that is passed through
	 * @param button
	 * ---------------------------------------------------------------------------------
	 */
	public static void drawX(Button button) {
		button.setText("X");
		button.setStyle("-fx-font: 24 arial");

	}
	
	/**---------------------------------------------------------------------------------
	 * Draw an O on the Button passed through
	 * @param button
	 * ---------------------------------------------------------------------------------
	 */
	public static void drawO(Button button) {
		button.setText("O");
		button.setStyle("-fx-font: 24 arial");

	}
	
	/**---------------------------------------------------------------------------------
	 * This is basically setting back the board to all 0's
	 * @param board
	 * ---------------------------------------------------------------------------------
	 */
	public static void setBoard(int[][] board) {
		for(int i =0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
			board[i][j] = 0;
			}
		}
	}
	
	/**---------------------------------------------------------------------------------
	 * Boolean that will return false if the board still has spaces open
	 * will return true, meaning the board is full
	 * @param board
	 * @return
	 * ---------------------------------------------------------------------------------
	 */
	public static boolean isFull(int[][] board) {
		for(int i =0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
			if(board[i][j] == 0) {
			return false;
		}
	}
		}
		return true;
	}	
	
	/**---------------------------------------------------------------------------------
	 * Set the turn to the Player or Computer
	 * @param turn
	 * ---------------------------------------------------------------------------------
	 */
	public static void setTurn(boolean turn) {
		whoseTurn = turn;
	}
	/**---------------------------------------------------------------------------------
	 * Return who's turn it is
	 * @return
	 * ---------------------------------------------------------------------------------
	 */
	public static boolean getTurn() {
		return whoseTurn;
	}

	/**---------------------------------------------------------------------------------
	 * This will run the sums of the rows, columns, and crosses 
	 * and if they are equal to 3 (1+1+1), then return true which is a win for the player
	 * @param board
	 * @return
	 * ---------------------------------------------------------------------------------
	 */
	public static boolean checkWinPlayer(int[][] board) {
		
		int row1 = 0;
		int row2 = 0;
		int row3 = 0;
		int col1 = 0;
		int col2 = 0;
		int col3 = 0;
		int cross1 = 0;
		int cross2 = 0;

		
		row1 = board[0][0] + board[0][1] + board[0][2];
		row2 = board[1][0] + board[1][1] + board[1][2];
		row3 = board[2][0] + board[2][1] + board[2][2];
		
		col1 = board[0][0] + board[1][0] + board[2][0];
		col2 = board[0][1] + board[1][1] + board[2][1];
		col3 = board[0][2] + board[1][2] + board[2][2];
		
		cross1 = board[0][0]+ board[1][1] + board[2][2];
		cross2 = board[2][0] + board[1][1] + board[0][2];

		if(row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3|| col2 == 3 || col3 == 3 || cross1 == 3 || cross2 == 3) {
			return true;
		} else {
		return false;
		}
	}
	
	/**---------------------------------------------------------------------------------
	 * This will check to see if the Computer has a winning board
	 * If the sum of a row, column or cross is 15 (5+5+5) return true which is a win.
	 * @param board
	 * @return
	 * ---------------------------------------------------------------------------------
	 */
	public static boolean checkWinComputer(int[][] board) {
		int row1 = 0;
		int row2 = 0;
		int row3 = 0;
		int col1 = 0;
		int col2 = 0;
		int col3 = 0;
		int cross1 = 0;
		int cross2 = 0;

		row1 = board[0][0] + board[0][1] + board[0][2];
		row2 = board[1][0] + board[1][1] + board[1][2];
		row3 = board[2][0] + board[2][1] + board[2][2];
		
		col1 = board[0][0] + board[1][0] + board[2][0];
		col2 = board[0][1] + board[1][1] + board[2][1];
		col3 = board[0][2] + board[1][2] + board[2][2];
		
		cross1 = board[0][0]+ board[1][1] + board[2][2];
		cross2 = board[2][0] + board[1][1] + board[0][2];		

		if(row1 == 15 || row2 == 15 || row3 == 15 || col1 == 15|| col2 == 15 || col3 == 15 || cross1 == 15 || cross2 == 15) {
			return true;
		} else {
		return false;
		}
	}

}
