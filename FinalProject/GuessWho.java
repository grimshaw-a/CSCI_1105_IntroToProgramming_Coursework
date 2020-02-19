/**
 * <p>This program is a text version of the Guess Who? game.</p>
 * <p>Created: 02.12.20</p>
 * @author Adam Grimshaw
 *
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.jar.*;

public class GuessWho {

	static boolean endGame = false;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// STARTING VALUES----------------------------------------------------------------------
		
		// Array of all characters and their attributes.
		String[][] characterArray = {{"LEROY", "brown", "He", "hat", "glasses", "beard"}, 
				{"SALLY", "blonde", "She", "no", "no", "no"},
				{"JO", "red", "She", "no", "no", "no"},
				{"TOM", "brown", "He", "hat", "glasses", "no"},
				{"MARIA", "black", "She", "no", "no", "no"},
				{"STAN", "brown", "He", "hat", "no", "no"},
				{"MARK", "brown", "He", "no", "no", "no"},
				{"HOPE", "brown", "She", "hat", "glasses", "beard"},
				{"TISHA", "black", "She", "hat", "glasses", "no"},
				{"DAISY", "red", "She", "hat", "no", "no"},
				{"HOLLY", "brown", "She", "no", "no", "no"},
				{"ANTONIO", "black", "He", "no", "glasses", "beard"},
				{"LEXY", "red", "He", "no", "glasses", "no"},
				{"GUY", "black", "He", "no", "no", "no"},
				{"MARSHA", "brown", "She", "no", "glasses", "no"},
				{"OLIVIA", "black", "She", "no", "no", "yes"},
				{"LEANNA", "red", "She", "hat", "no", "no"},
				{"SID", "brown", "He", "no", "no", "beard"},
				{"VINNY", "blonde", "He", "no", "no", "beard"},
				{"BUTCH", "blonde", "He", "no", "no", "no"},
				};
		

		
		// Questions the computer can ask.
		String[] computerQuestionsArray = {
			"Is your person a man?",
			"Does your person have brown hair?",
			"Does your person have a hat?",
			"Does your person wear glasses?",
			"Does your person have a beard?",
			"Does your person have black hair?",
			"Does your person have red hair?",
			"I'm really confused. Are you sure you answered my questions honestly?"
		};
		int compTurnCounter = 0;
		
		// BEGIN GAME----------------------------------------------------------------------------
		
		// Initialize the game.
		shuffleArray(characterArray);
		
		// Arrays to keep track of user and computer progress.
		String[][] userArray = new String[characterArray.length][characterArray[0].length];
		String[][] computerArray = new String[characterArray.length][characterArray[0].length];
		for (int i = 0; i < characterArray.length; i++) {
			for (int j = 0; j < characterArray[i].length; j++) {
				userArray[i][j] = characterArray[i][j];
				computerArray[i][j] = characterArray[i][j];
			}
		}
		String[] userCharacter = characterArray[0];
		String[] computerCharacter = characterArray[1];
		String userQuestion = "";
		printInstructions();
		
		// Dev cheat
		//System.out.println("The computer's character is " + computerCharacter[0]);
		
		// Loop the game until finished.
		while(endGame == false) {
			lastCharacterComputer(computerArray);
			if (endGame == true) {
				return;
			}
			printUserCharacter(userCharacter);
			computerTurn(compTurnCounter, computerQuestionsArray, computerArray);
			compTurnCounter++;
			userTurn(userArray);
		}
	}
	
	/** Runs the computer's turn */
	public static void computerTurn(int turn, String[] qArray, String[][] array) {
		Scanner input = new Scanner(System.in);
		boolean turnComplete = false;
		String[] attributesArray = {"He", "brown", "hat", "glasses", "beard", "black", "red"};
		int[] attributesOrderArray = {2, 1, 3, 4, 5, 1, 1};
		while (turnComplete == false) {
			System.out.print(qArray[turn] + " ");
			String answer = input.next();
			if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) 	{
				// remove names of characters exhibiting that feature.
				removeCharacters(attributesArray[turn], array, attributesOrderArray[turn], false);
				turnComplete = true;
			}
			else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
				// remove names not exhibiting that feature.
				removeCharacters(attributesArray[turn], array, attributesOrderArray[turn], true);
				turnComplete = true;
			}
			else {
				System.out.println("Invalid input. Please answer Yes or No.");
			}
		}
		//printAllRemainingCharacters(array);
		//System.out.println();
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
	
	/** Prints out name and attributes of user's character.*/
	public static void printCharacter(String[] array) {
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
		System.out.print(array[0] + ": ");
		System.out.println(array[2] + " has " + array[1] + " hair, " + hat + glasses + beard + "\n");
	}
	
	/** Removes characters from the board.*/
	public static boolean checkAnswer(String[][] array, String question) {
		if (question.equals(array[1][0] + "?")) {
			System.out.println("You guessed correctly! The computer's character is " + question + "! You win!");
			endGame = true;
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
				return true;
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
				return true;
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
				return true;
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
				return true;
			}
		case "INSTRUCTIONS":
			printInstructions();
			return false;
			
		case "HELP":
			printInstructions();
			return false;
			
		case "LIST ATTRIBUTES":
			for (int i = 0; i < array.length; i++) {
					if (array[i][0].equals("")) {
						// do nothing
					}
					else {
						printCharacter(array[i]);
					}
				}
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
	
	public static void lastCharacterComputer(String[][] array) {
		Scanner input = new Scanner(System.in);
		boolean turnComplete = false;
		int counter = 0;
		String character = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i][0].equals("")) {
				// do nothing
			}
			else {
				character = array[i][0];
				counter++;
			}
		}
		if (counter == 1) {
			// guess character
			System.out.print("Is your character " + character + "? ");
			String answer = input.next();
			if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
				System.out.println("Computer wins!");
				endGame = true;
				turnComplete = true;
			}
			else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
				// do nothing
				turnComplete = true;
			}
			else {
				System.out.println("Invalid input. Please answer Yes or No.");
				lastCharacterComputer(array);
			}
		}
	}
}
