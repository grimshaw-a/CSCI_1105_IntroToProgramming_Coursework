// Author: Adam Grimshaw
// Date: December 18, 2019
// Class: Intro to Programming

import java.util.Scanner;

public class SolveForXY {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// prompt user to enter values for a, b, c, d, e, and f
		System.out.print("Enter the value of a: ");
		double a = input.nextDouble();
		System.out.print("Enter the value of b: ");
		double b = input.nextDouble();
		System.out.print("Enter the value of c: ");
		double c = input.nextDouble();
		System.out.print("Enter the value of d: ");
		double d = input.nextDouble();
		System.out.print("Enter the value of e: ");
		double e = input.nextDouble();
		System.out.print("Enter the value of f: ");
		double f = input.nextDouble();
		
		// calculate values of x and y if possible
		if(a * d - b * c == 0) {
			System.out.print("Error: Cannot divide by zero.");
			System.exit(1);
		}
		else {
			double x = (e * d - b * f) / (a * d - b * c);
			double y = (a * f - e * c) / (a * d - b * c);
			System.out.println("x = " + x);
			System.out.println("y = " + y);
		}

	}

}
