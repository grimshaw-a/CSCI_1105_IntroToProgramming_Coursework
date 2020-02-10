/**
 * <p>Created: 02.10.20</p>
 * @author Adam Grimshaw
 *
 */

import java.util.Scanner;

public class GuessStateCapital {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[][] stateCapitals = {{"Utah", "Salt Lake City"}, {"Idaho", "Boise"}, {"Oregon", "Salem"}, 
				{"Montana", "Helena"}, {"Iowa", "Des Moines"}, {"New York", "Albany"}, {"Colorado", "Denver"}, 
				{"Minnesota", "St. Paul"}, {"Arkansas", "Little Rock"}, {"Alabama", "Montgomery"}};
		
		int correctAnswers = 0;
		for (int i = 0; i < stateCapitals.length; i++) {
			System.out.print("What is the capital of " + stateCapitals[i][0] + "? ");
			String answer = input.nextLine();
			if(answer.equalsIgnoreCase(stateCapitals[i][1])) {
				System.out.println("That is correct.");
				correctAnswers++;
			}
			else {
				System.out.println("That is incorrect.");
			}
		}
		System.out.println("You got " + correctAnswers + " answers correct.");
	}

}
