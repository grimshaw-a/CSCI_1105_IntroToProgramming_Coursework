// 01.31.20
// Author: Adam Grimshaw
// Intro to Programming

import java.util.Scanner;

class testPalindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Prompt user to input an integer.
		System.out.print("Enter a large integer: ");
		int newInt = input.nextInt();
		reverse(newInt);
	}
	public static int reverse(int number) {
		// Determine if number is a palindrome.
		if (isPalindrome(number)) {
			return number;
		}
		else {
			// Reverse order of digits.
			String testValue = "" + number;
			String reverseString = "";
			int j = testValue.length() - 1; 
			for(int i = 0; i < testValue.length(); i++) {
				reverseString = reverseString + testValue.charAt(j);
				j--;
			}
			int reversedInt = Integer.valueOf(reverseString);
			return reversedInt;
		}
	}
	public static boolean isPalindrome(int number) {
		String testValue = "" + number;
		int j = testValue.length() - 1;
		// Test to see if number is a palindrome.
		for (int i = 0; i < testValue.length(); i++) {
			if (testValue.charAt(i) == testValue.charAt(j)) {
				j--;
			}
			else {
				System.out.println(number + " is not a palindrome.");
				return false;
			}
		}
		System.out.println(number + " is a palindrome.");
		return true;
	}
}