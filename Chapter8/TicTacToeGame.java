/**
 * <p>Created: 02.10.20</p>
 * @author Adam Grimshaw
 *
 */

import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		String[][] boardMatrix = {{" "," "," "}, {" "," "," "}, {" "," "," "}};
		int counter = 0;
		String team = "O";
		while (counter < 9) {
			System.out.println(counter);
			if (counter % 2 == 0) {
				team = "X";
			}
			else {
				team = "O";
			}
			counter = playerTurn(boardMatrix, counter, team);
		}
		System.out.print("GAME OVER");
	}
	
	public static int playerTurn(String[][] board, int counter, String team) {
		Scanner input = new Scanner(System.in);
		System.out.print(team + " team's turn.\nEnter a row (1, 2, or 3): ");
		int row = input.nextInt();
		if (row > 3 || row < 1) {
			System.out.println("Invalid input. Try again.");
			return counter;
		}
		System.out.print("Enter a column (1, 2, or 3); ");
		int column = input.nextInt();
		if (column > 3 || column < 1) {
			System.out.println("Invalid input. Try again.");
			return counter;
		}
		if (board[row - 1][column - 1] == " ") {
			board[row - 1][column - 1] = team;
		}
		else {
			System.out.println("Square already occupied. Try again.");
			return counter;
		}
		
		printBoard(board);
		counter++; 
		return counter;
	}
	
	public static void printBoard(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.println("-------");
			for (int j = 0; j < board[i].length; j++) {
				System.out.print("|" + board[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("-------");
	}
}
