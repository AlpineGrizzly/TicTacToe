package application;
	
import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;


public class Driver extends Application {
	@Override
	public void start(Stage primaryStage) {
		/** --------------------------------------------------------------------------------
		 * The VBox root will hold the other horizontal rows with will then hold the buttons
		 * that are needed to build the board
		 * 
		 * The Border pane will organize the game board into the different parts being:
		 * The title
		 * the board
		 * the score
		 * ---------------------------------------------------------------------------------
		 */
			final BorderPane main = new BorderPane();
			VBox root = new VBox();
			HBox top = new HBox();
			HBox mid = new HBox();
			HBox bot = new HBox();
			VBox wins = new VBox();
			/**-----------------------------------------------------
			 * The nine buttons are set here as well as their size's
			 * -----------------------------------------------------
			 */
			Button c1 = new Button();
				c1.setPrefSize(100, 100);
			Button c2 = new Button();
				c2.setPrefSize(100, 100);
			Button c3 = new Button();
				c3.setPrefSize(100, 100);
			Button c4 = new Button();
				c4.setPrefSize(100, 100);
			Button c5 = new Button();
				c5.setPrefSize(100, 100);
			Button c6 = new Button();
				c6.setPrefSize(100, 100);
			Button c7 = new Button();
				c7.setPrefSize(100, 100);
			Button c8 = new Button();
				c8.setPrefSize(100, 100);
			Button c9 = new Button();
				c9.setPrefSize(100, 100);
				
			/** ---------------------------------------------------------------------------------
			 * This is the alert box that will show when either the player or the computer wins
			 * This will also show when their is a tie between the two players
			 * ---------------------------------------------------------------------------------
			 */
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("");
			
			/** ---------------------------------------------------------------------------------
			 * humScore and compScore will be integer values that will fetch the points that both the
			 * human and the player have accumlated throughout the game.
			 * 
			 * The humanWins and compWins variables will also display the scores along side the board
			 * while the game is going on.
			 * ---------------------------------------------------------------------------------
			 */
			int humScore = ScoreKeeper.getScoreH();
			int compScore = ScoreKeeper.getScoreC();
			Label title = new Label("Tic Tac Toe");
			Label humanWins = new Label("Player Wins: " + humScore);
			Label compWins = new Label("Computer Wins: " + compScore);
			humanWins.setStyle("-fx-font: 14 Verdana");
			compWins.setStyle("-fx-font: 14 Verdana");
			title.setStyle("-fx-font: 25 Verdana");

			
			/**---------------------------------------------------------------------------------
			 * butt is the buttons array that will be called on by the other classes to get access to them and set
			 * there text, mark them as pressed, etc. 
			 * ---------------------------------------------------------------------------------
			 */
			Button[] butt = {c1, c2, c3, c4, c5, c6, c7, c8, c9};
			/**---------------------------------------------------------------------------------
			 * Using the coordArray it will display 2 columns of 9 rows.
			 * Each row will contain the coordinates for the row's # button.
			 * Such that in row 0, the coordinates are 0,0, which is the 0th button in the button array.
			 * ---------------------------------------------------------------------------------
			 */
			int[][] coordArr = new int[9][2];
			
			/**---------------------------------------------------------------------------------
			 * coordArr will be set as follows
			 * 0 0
			 * 0 1
			 * 0 2		|
			 * 1 0		|	
			 * 1 1		V
			 * 1 2
			 * 2 0
			 * 2 1
			 * 2 2 
			 * ---------------------------------------------------------------------------------
			 */
			for(int i = 0; i < 9; i++) {
				coordArr[i][1] = i%3;
			}
			int k = 0;
				for(int j = 0; j < 9; j++) {
				coordArr[j][0] = k;
				if(j == 2) {
					k += 1;
				} else if(j == 5) {
					k += 1;
				} else if(j == 8) {
					k += 1;
					}
				}
			/**---------------------------------------------------------------------------------
			 * This is the array that will be set up as:
			 * 0 0 0 
			 * 0 0 0
			 * 0 0 0
			 * And will represent the game in progress as an int array so that i can 
			 * add sums of columns, rows, and crosses to check and see if there has been a win yet
			 * ---------------------------------------------------------------------------------
			 */
			int[][] array = new int[3][3];
			/** ---------------------------------------------------------------------------------
			 * Setting the turn of the board will make sure the player is the first person
			 * who will mark a move
			 * 
			 * The set board method will take the array and set it to all 0's
			 * ---------------------------------------------------------------------------------
			 */
			Board.setTurn(false);
			Board.setBoard(array);
			
			/**---------------------------------------------------------------------------------
			 * Ordering the board itself
			 * ---------------------------------------------------------------------------------
			 */
			wins.getChildren().addAll(humanWins, compWins);
			top.getChildren().addAll(c1, c2, c3);
			mid.getChildren().addAll(c4, c5, c6);
			bot.getChildren().addAll(c7, c8, c9);
			root.getChildren().addAll(top, mid, bot, wins);
			
			/**---------------------------------------------------------------------------------
			 * Putting the wins on each side of the board and putting the gameboard
			 * in the center
			 * ---------------------------------------------------------------------------------
			 */

			main.setRight(wins);
			main.setCenter(root);
			main.setTop(title);
			/**---------------------------------------------------------------------------------
			 * When a button is pressed, it will call the play method, which is going to be used to guide the game
			 * and get inputs from each the player and the ai
			 * ---------------------------------------------------------------------------------
			 */
			c1.setOnAction(e -> play(c1, 0, 0, array, alert, humanWins, compWins, coordArr, butt));
			c2.setOnAction(e -> play(c2, 0, 1, array, alert, humanWins, compWins, coordArr, butt));
			c3.setOnAction(e -> play(c3, 0, 2, array, alert, humanWins, compWins, coordArr, butt));
			c4.setOnAction(e -> play(c4, 1, 0, array, alert, humanWins, compWins, coordArr, butt));
			c5.setOnAction(e -> play(c5, 1, 1, array, alert, humanWins, compWins, coordArr, butt));
			c6.setOnAction(e -> play(c6, 1, 2, array, alert, humanWins, compWins, coordArr, butt));
			c7.setOnAction(e -> play(c7, 2, 0, array, alert, humanWins, compWins, coordArr, butt));
			c8.setOnAction(e -> play(c8, 2, 1, array, alert, humanWins, compWins, coordArr, butt));
			c9.setOnAction(e -> play(c9, 2, 2, array, alert, humanWins, compWins, coordArr, butt));
			
			Scene scene = new Scene(main,470,300);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Dalton's TicTacToe");
	}
	

	/**---------------------------------------------------------------------------------
	 * @param button - Button Array
	 * @param x - What x coordinate that button is at
	 * @param y - What y coordinate that button is at
	 * @param array - the gameboard
	 * @param alert - label to display when someone wins
	 * @param human - Score for the human
	 * @param comp - Score for the Computer
	 * @param coordArr - coordinates for the buttons
	 * @param butt - Buttons Array
	 * ---------------------------------------------------------------------------------
	 */
	public static void play(Button button, int x, int y, int[][] array, Alert alert, Label human, Label comp, int[][] coordArr, Button[] butt) {
		/**---------------------------------------------------------------------------------
		 * If it is the Player's turn when the button pressed, call to the wasPressed method in on the board
		 * ---------------------------------------------------------------------------------
		 */
		if(Board.getTurn() == false) {
		Board.wasPressed(button, x, y, array);
		}
		/**---------------------------------------------------------------------------------
		 * If it is the Computer's turn, call to the compTurn method which will make a move 
		 * ---------------------------------------------------------------------------------
		 */
		if(Board.getTurn() == true) {
		compTurn(butt, coordArr, array);
		}
		/** ---------------------------------------------------------------------------------
		 * Check to see if either the human or Computer has made a winning move and if so, display an alert 
		 * ---------------------------------------------------------------------------------
		 */
		winCheck(array, human, comp, alert, butt);		

	}
	
	public static void winCheck(int[][] array, Label human, Label comp, Alert alert, Button[] butt) {
		/**---------------------------------------------------------------------------------
		 * If the the Player has a winning move, then add one to the player's score
		 * then display the alert and restart the board when they exit the request
		 * ---------------------------------------------------------------------------------
		 * else if the Computer has a winning move, then add one to the player's score
		 * then display the alert and restart the board when they exit the request
		 * ---------------------------------------------------------------------------------
		 * else if the board is full, don't set any score but show the alert for a tie
		 * and restart the board
		 * ---------------------------------------------------------------------------------
		 */
		if(Board.checkWinPlayer(array) == true) {
			ScoreKeeper.humanWin();
			human.setText("Player Score: " + ScoreKeeper.getScoreH());
			alert.setHeaderText("You Won!");
			alert.setContentText("Human Wins!");
			alert.show();
			alert.setOnCloseRequest(e -> restart(butt, array));
		} else if(Board.checkWinComputer(array) == true) {
			ScoreKeeper.compWin();
			comp.setText("Computer Score: " + ScoreKeeper.getScoreC());
			alert.setHeaderText("You lost!");
			alert.setContentText("Computer Wins!");
			alert.show();
			alert.setOnCloseRequest(e -> restart(butt, array));
		} else if(Board.isFull(array) == true) {
			alert.setHeaderText("Draw!");
			alert.setContentText("It was a tie!");
			alert.show();
			alert.setOnCloseRequest(e -> restart(butt, array));
			
		}
	}
	
	/**---------------------------------------------------------------------------------
	 * This will set all the buttons back to blank and set the int array representing the
	 * board back to all 0's
	 * @param button
	 * @param array
	 * ---------------------------------------------------------------------------------
	 */
	public static void restart(Button[] button, int [][]array) {
		Board.setBoard(array);
		for(int i = 0; i < 9; i++) {
			button[i].setText("");
		}
	}
	/** ---------------------------------------------------------------------------------
	 * This will call on the move for the Computer
	 * @param butt - Button Array
	 * @param coordArr - Coordinate Array for the buttons
	 * @param array - Board array
	 * ---------------------------------------------------------------------------------
	 */
	public static void compTurn(Button[] butt, int[][] coordArr, int[][]array) {
		ComputerPlayer.compMove(butt, coordArr, array);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
