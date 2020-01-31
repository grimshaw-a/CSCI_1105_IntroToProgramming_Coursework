// 01.31.20
// Author: Adam Grimshaw
// Intro to Programming

import java.util.Scanner;

class createNumberMatrix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Prompt user to enter an integer.
		System.out.print("Please enter a positive integer: ");
		int userNumber = input.nextInt();
		printMatrix(userNumber);
	}
	
	public static void printMatrix(int n) {
		for(int j = 0; j < n; j++) {
			// Generates and prints a 1 or 0 at random.		
			for(int i = 0; i < n; i++){
				int r = (int)(Math.round(Math.random()));
				System.out.print(r);
			}
			System.out.println("");
		}
	}
}