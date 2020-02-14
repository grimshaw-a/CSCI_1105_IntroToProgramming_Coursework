/**
 * <p>This program is a text version of the Guess Who? game.</p>
 * <p>Created: 02.12.20</p>
 * @author Adam Grimshaw
 *
 */

import java.util.Scanner;
import java.util.Arrays;

public class GuessWho {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Array of all characters and their attributes.
		String[][] characterArray = {{"TOM", "brown", "He", "hat", "glasses", "beard", "false"}, 
				{"SALLY", "blonde", "She", "no", "no", "no", "false"},
				{"JO", "red", "She", "hat", "glasses", "no", "false"},
				{"HARRY", "brown", "He", "no", "glasses", "beard", "false"},
				{"MARIA", "black", "She", "hat", "no", "no", "false"},
				{"STANLEY", "black", "He", "no", "no", "no", "false"},
				{"FRED", "brown", "He", "hat", "no", "no", "false"},
				{"KARL", "black", "He", "no", "glasses", "no", "false"},
				{"JOYCE", "brown", "She", "no", "no", "no", "false"},
				{"ANTON", "red", "He", "no", "no", "beard", "false"}};
		
		// Arrays to keep track of user and computer progress.
		String[][] userArray = new String[characterArray.length][characterArray[0].length];
		String[][] computerArray = new String[characterArray.length][characterArray[0].length];
		for (int i = 0; i < characterArray.length; i++) {
			for (int j = 0; j < characterArray[i].length; j++) {
				userArray[i][j] = characterArray[i][j];
				computerArray[i][j] = characterArray[i][j];
			}
		}
		
		// Initialize the game.
		shuffleArray(characterArray);
		String[] userCharacter = characterArray[0];
		String[] computerCharacter = characterArray[1];
		String userQuestion = "";
		printInstructions();
		printUserCharacter(characterArray[0]);
		
		// Dev cheat
		//System.out.println("The computer's character is " + computerCharacter[0]);
		
		// Loop the game until finished.
		while(characterArray[1][6].equals("false")) {
			userTurn(characterArray);
		}
	}
	
	/** Runs the computer's turn */
	public static void computerTurn() {
		Scanner input = new Scanner(System.in);
		boolean turnComplete = false;
		
	}
	
	/** Runs the user's turn.*/
	public static void userTurn(String[][] array) {
		Scanner input = new Scanner(System.in);
		boolean turnComplete = false;
		printAllRemainingCharacters(array);
		while(turnComplete == false) {
			System.out.print("Your turn. Enter a question: ");
			String question = input.nextLine();
			turnComplete = checkAnswer(array, question.toUpperCase());
		}
	}
	
	/** Creates a random variable and swaps array elements to randomize their order.*/
	public static String[][] shuffleArray(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			int j = (int)(Math.random() * (i + 1));
			String[] temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return array;
	}

	/** Prints out instructions for how to play the game.*/
	public static void printInstructions() {
		System.out.print("WELCOME TO \"GUESS WHO?\"\n-----------------------\nYou and the computer will each be "
					+ "assigned a character. The goal is to guess the computer's character before "
					+ "it guesses yours.\nYou will be given the name and attributes of your "
					+ "character. Answer the computer's questions by typing either \"YES\" or "
					+ "\"NO\".\n\nTo ask the computer a question, type one of the "
					+ "following:\n\"MAN?\", \"WOMAN?\", \"BROWN HAIR?\", \"BLONDE HAIR?\", "
					+ "\"BLACK HAIR?\", \"RED HAIR?\", \"GLASSES?\", \"HAT?\", \"BEARD?\", or "
					+ "\"(NAME OF CHARACTER)?\"\n\n"
					+ "The computer will go first. HAVE FUN!\n-------------------------------------\n\n");
	}
	
	/** Prints out a list of all characters.*/
	public static void printAllRemainingCharacters(String[][] array) {
		System.out.println("The following characters are on the board:");
		// Creates a new array with the names in alphabetical order, so the user can't cheat.
		String[] alphaArray = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			alphaArray[i] = array[i][0];
		}
		Arrays.sort(alphaArray);
		// Print out the remaining characters.
		for(int i = 0; i < array.length; i++) {
			if (alphaArray[i].equals("")) {
				// Do nothing
			}
			else {
				System.out.print(alphaArray[i] + " ");
			}
		}
		System.out.print("\n\n");
	}
	
	/** Prints out name and attributes of user's character.*/
	public static void printUserCharacter(String[] array) {
		String hat = "does not wear a hat, ";
		String glasses = "does not have glasses, ";
		String beard = "and does not have a beard.";
		if (array[3] == "hat") {
			hat = "wears a hat, ";
		}
		if (array[4] == "glasses") {
			glasses = "wears glasses, ";
		}
		if (array[5] == "beard") {
			beard = "and has a beard.";
		}
		System.out.print("Your character is " + array[0] + ". ");
		System.out.println(array[2] + " has " + array[1] + " hair, " + hat + glasses + beard + "\n");
	}
	
	/** Removes characters from the board.*/
	public static boolean checkAnswer(String[][] array, String question) {
		if (question.equals(array[1][0] + "?")) {
			System.out.println("You guessed correctly! The computer's character is " + array[1][0] + "!");
			array[1][6] = "true";
			return true;
		}
		else if (question.equals(array[2][0] + "?") || question.equals(array[3][0] + "?") || question.equals(array[4][0] + "?") || question.equals(array[5][0] + "?") || question.equals(array[6][0] + "?") || question.equals(array[7][0] + "?") || question.equals(array[8][0] + "?") || question.equals(array[9][0] + "?")) {
			System.out.println("No");
			// Removes "?" from string before feeding to removeCharacters method.
			question = question.substring(0, question.length() - 1);
			removeCharacters(question, array, 0, true);
			return true;
		}
		switch (question) {
		case "MAN?": 
			if (array[1][2].equalsIgnoreCase("He")) {
				System.out.println("Yes");
				removeCharacters("He", array, 2, false);
				return true;
			}
			else if (array[1][2].equalsIgnoreCase("She")) {
				System.out.println("No");
				removeCharacters("He", array, 2, true);
				return true;
			}
		case "WOMAN?": 
			if (array[1][2].equalsIgnoreCase("She")) {
				System.out.println("Yes");
				removeCharacters("She", array, 2, false);
				return true;
			}
			else if (array[1][2].equalsIgnoreCase("He")) {
				System.out.println("No");
				removeCharacters("She", array, 2, true);
				return true;
			}
		case "BROWN HAIR?": 
			if (array[1][1].equalsIgnoreCase("brown")) {
				System.out.println("Yes");
				removeCharacters("brown", array, 1, false);
				return true;
			}
			else if (array[1][1].equalsIgnoreCase("blonde") || array[1][1].equalsIgnoreCase("red") || array[1][1].equalsIgnoreCase("black")) {
				System.out.println("No");
				removeCharacters("brown", array, 1, true);
				return true;
			}
		case "BLONDE HAIR?": 
			if (array[1][1].equalsIgnoreCase("blonde")) {
				System.out.println("Yes");
				removeCharacters("blonde", array, 1, false);
				return true;
			}
			else if (array[1][1].equalsIgnoreCase("brown") || array[1][1].equalsIgnoreCase("red") || array[1][1].equalsIgnoreCase("black")) {
				System.out.println("No");
				removeCharacters("blonde", array, 1, true);
				return false;
			}
		case "BLACK HAIR?": 
			if (array[1][1].equalsIgnoreCase("black")) {
				System.out.println("Yes");
				removeCharacters("black", array, 1, false);
				return true;
			}
			else if (array[1][1].equalsIgnoreCase("blonde") || array[1][1].equalsIgnoreCase("red") || array[1][1].equalsIgnoreCase("brown")) {
				System.out.println("No");
				removeCharacters("black", array, 1, true);
				return true;
			}
		case "RED HAIR?": 
			if (array[1][1].equalsIgnoreCase("red")) {
				System.out.println("Yes");
				removeCharacters("red", array, 1, false);
				return true;
			}
			else if (array[1][1].equalsIgnoreCase("blonde") || array[1][1].equalsIgnoreCase("brown") || array[1][1].equalsIgnoreCase("black")) {
				System.out.println("No");
				removeCharacters("red", array, 1, true);
				return true;
			}
		case "GLASSES?": 
			if (array[1][4].equalsIgnoreCase("glasses")) {
				System.out.println("Yes");
				removeCharacters("glasses", array, 4, false);
				return true;
			}
			else if (array[1][4].equalsIgnoreCase("no")) {
				System.out.println("No");
				removeCharacters("glasses", array, 4, true);
				return false;
			}
		case "HAT?": 
			if (array[1][3].equalsIgnoreCase("hat")) {
				System.out.println("Yes");
				removeCharacters("hat", array, 3, false);
				return true;
			}
			else if (array[1][3].equalsIgnoreCase("no")) {
				System.out.println("No");
				removeCharacters("hat", array, 3, true);
				return false;
			}
		case "BEARD?": 
			if (array[1][5].equalsIgnoreCase("beard")) {
				System.out.println("Yes");
				removeCharacters("beard", array, 5, false);
				return true;
			}
			else if (array[1][5].equalsIgnoreCase("no")) {
				System.out.println("No");
				removeCharacters("beard", array, 5, true);
				return false;
			}
		case "INSTRUCTIONS":
			printInstructions();
			return false;
			
		case "HELP":
			printInstructions();
			return false;
		}
		System.out.println("Invalid input. Please try again.");
		return false;
	}
	
	/** Removes characters from user/computer array.*/
	public static void removeCharacters(String attribute, String[][] array, int arrayIndex, boolean bool) {
		for(int i = 0; i < array.length; i++) {
			if(array[i][arrayIndex].equals(attribute) == bool) {
				array[i][0] = "";
			}
		}
		System.out.println();
	}
}
