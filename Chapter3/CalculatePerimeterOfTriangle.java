// Author: Adam Grimshaw
// Date: December 18, 2019
// Class: Intro to Programming

import java.util.Scanner;

public class CalculatePerimeterOfTriangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// prompt user to enter values for sides of triangle
		System.out.print("What length is the first side of the triangle? ");
		double a = input.nextDouble();
		System.out.print("What length is the second side of the triangle? ");
		double b = input.nextDouble();
		System.out.print("What length is the third side of the triangle? ");
		double c = input.nextDouble();
		
		// determine if the inputs are valid
		if(a + b <= c || a + c <= b || b + c <= a)
			System.out.print("Invalid input");
		else {
			System.out.print("The perimeter of the triangle is " + (a + b+ c));
		}

	}

}
