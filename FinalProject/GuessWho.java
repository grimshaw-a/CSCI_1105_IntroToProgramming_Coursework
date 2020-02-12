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
		String[][] characterArray = {{"TOM", "brown", "He", "hat", "glasses", "beard"}, 
				{"SALLY", "blonde", "She", "no", "no", "no"},
				{"JO", "red", "She", "hat", "glasses", "no"},
				{"HARRY", "brown", "He", "no", "glasses", "beard"},
				{"MARIA", "black", "She", "hat", "no", "no"}};
		
		// Arrays to keep track of user and computer progress.
		String[][] userArray = new String[characterArray.length][characterArray[0].length];
		String[][] computerArray = new String[characterArray.length][characterArray[0].length];
		for (int i = 0; i < characterArray.length; i++) {
			for (int j = 0; j < characterArray[i].length; j++) {
				userArray[i][j] = characterArray[i][j];
				computerArray[i][j] = characterArray[i][j];
			}
		}
		
		// Test to make sure shuffle works.
		//System.out.println(shuffleArray(characterArray)[0][0]);
		
		// Initialize the game.
		shuffleArray(characterArray);
		String[] userCharacter = characterArray[0];
		String[] computerCharacter = characterArray[1];
		printInstructions();
		printAllRemainingCharacters(characterArray);
		printUserCharacter(characterArray[0]);
		
		String userQuestion = "MAN?";
		
		//removeCharacters("He", userArray, 2, true);
		checkAnswer(characterArray, userQuestion);
		
		//if (checkAnswer(userArray[1], userQuestion)) {
		//	for (int i = 0; i< userArray.length; i++) {
				
		//	}
		//}
		
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
		System.out.print("WELCOME TO \"GUESS WHO?\"\n\nYou and the computer will each be "
					+ "assigned a character. The goal is to guess the computer's character before "
					+ "it guesses yours.\nYou will be given the name and attributes of your "
					+ "character. Answer the computer's questions by typing either \"YES\" or "
					+ "\"NO\".\n\nTo ask the computer a question, type one of the "
					+ "following:\n\"MAN?\", \"WOMAN?\", \"BROWN HAIR?\", \"BLONDE HAIR?\", "
					+ "\"BLACK HAIR?\", \"RED HAIR?\", \"GLASSES?\", \"HAT?\", \"BEARD?\", or "
					+ "\"(NAME OF CHARACTER)\"\n\n"
					+ "The computer will go first. HAVE FUN!\n\n");
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
			System.out.print(alphaArray[i] + " ");
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
		System.out.println("Your character is " + array[0] + ".");
		System.out.println(array[2] + " has " + array[1] + " hair, " + hat + glasses + beard);
	}
	
	/** Removes characters from the board.*/
	public static boolean checkAnswer(String[][] array, String question) {
		switch (question) {
		case "MAN?": 
			if (array[1][2].equals("He")) {
				System.out.print("Yes");
				removeCharacters("He", array, 2, true);
				return true;
			}
			else if (array[1][2].equals("She")) {
				System.out.print("No");
				return false;
			}
		case "WOMAN?": 
			if (array[1][2] == "She") {
				System.out.print("Yes");
				return true;
			}
			else if (array[1][2] == "He") {
				System.out.print("No");
				return false;
			}
		case "BROWN HAIR?": 
			if (array[1][1] == "brown") {
				System.out.print("Yes");
				return true;
			}
			else if (array[1][1] == "blonde" || array[1][1] == "red" || array[1][1] == "black") {
				System.out.print("No");
				return false;
			}
		case "BLONDE HAIR?": 
			if (array[1][1] == "blonde") {
				System.out.print("Yes");
				return true;
			}
			else if (array[1][1] == "brown" || array[1][1] == "red" || array[1][1] == "black") {
				System.out.print("No");
				return false;
			}
		case "BLACK HAIR?": 
			if (array[1][1] == "black") {
				System.out.print("Yes");
				return true;
			}
			else if (array[1][1] == "blonde" || array[1][1] == "red" || array[1][1] == "brown") {
				System.out.print("No");
				return false;
			}
		case "RED HAIR?": 
			if (array[1][1] == "red") {
				System.out.print("Yes");
				return true;
			}
			else if (array[1][1] == "blonde" || array[1][1] == "brown" || array[1][1] == "black") {
				System.out.print("No");
				return false;
			}
		case "GLASSES?": 
			if (array[1][4] == "glasses") {
				System.out.print("Yes");
				return true;
			}
			else if (array[1][4] == "no") {
				System.out.print("No");
				return false;
			}
		case "HAT?": 
			if (array[1][3] == "hat") {
				System.out.print("Yes");
				return true;
			}
			else if (array[1][3] == "no") {
				System.out.print("No");
				return false;
			}
		case "BEARD?": 
			if (array[1][5] == "beard") {
				System.out.print("Yes");
				return true;
			}
			else if (array[1][5] == "no") {
				System.out.print("No");
				return false;
			}
		}
		System.out.print("Invalid input. Please try again.");
		return false;
	}
	
	/** Removes characters from user/computer array.*/
	public static void removeCharacters(String attribute, String[][] array, int arrayIndex, boolean bool) {
		//System.out.println(array[0][arrayIndex]);
		for(int i = 0; i < array.length; i++) {
			if(array[i][arrayIndex].equals(attribute) == false) {
				System.out.println(array[i][arrayIndex]);
				array[i][0] = "";
			}
			else if (array[i][arrayIndex].equals(attribute) == false) {
				System.out.println(array[i][arrayIndex]);
				array[i][0] = "";
			}
		}
		printAllRemainingCharacters(array);
	}
	/** The computer makes a guess and updates its list of characters.*/
	public static void computerTurn() {
		
	}
}
