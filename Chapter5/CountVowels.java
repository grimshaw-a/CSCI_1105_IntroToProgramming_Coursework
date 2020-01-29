// 01.29.20
// Author: Adam Grimshaw
// Intro to Programming
// Description: This program counts and displays the number of vowels and consonants in a string.

import java.util.Scanner;

class CountVowels {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Prompt user to enter string.
		System.out.print("Please enter a string: ");
		String theString = input.nextLine();
		theString = theString.toUpperCase();
		
		// Create variables to hold other values.
		int vowels = 0;
		int consonants = 0;
		int spaces = 0;
		
		// Run loops to count vowels, consonants, and spaces.
		for (int i = 0; i < theString.length(); i++)
			if (theString.charAt(i) == ' ') {
				spaces++;
			}
			else if (theString.charAt(i) == 'A' || theString.charAt(i) == 'E' || theString.charAt(i) == 'I' || theString.charAt(i) == 'O' || theString.charAt(i) == 'U') {
				vowels++;
			}
			else {
				consonants++;
			}
		System.out.println("The number of vowels is: " + vowels + ".");
		System.out.println("The number of consonants is: " + consonants + ".");
	}
}