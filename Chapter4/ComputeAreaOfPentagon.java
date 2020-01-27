// 01.27.20
// Adam Grimshaw
// Intro to Programming
// Description: This program calculates the area of a pentagon using the distance from the center to a vertex.

import java.util.Scanner;

class ComputeAreaOfPentagon {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Prompt user to enter length from the center to the vertex.
		System.out.println("Enter the length from the center to the vertex. ");
		Double r = input.nextDouble();
		if(r <= 0) {
			System.out.println("Invalid input. Please enter a positive number.");
		}
		else {
			// Calculate length of side.
			Double s = (2 * r) * Math.sin(Math.PI / 5);
			Double a = (5 * Math.pow(s, 2)) / (4 * Math.tan((Math.PI / 5)));
			a = (Math.ceil(a * 100)) / 100;

			// Print result.
			System.out.println("The area of the pentagon is: " + a);
		}
	}
}