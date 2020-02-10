/**
* <p>This program finds the smallest element in an array of user entered doubles.</p>
* <p>Created: 02.07.20</p>
* @author Adam Grimshaw
*/

import java.util.Scanner;

class findSmallestElement {
	/** This is the main method. Prompts user to enter 10 numbers. Invokes the findSmallestValue method and prints out result.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] numArray = new double[10];
		// Prompts user to enter 10 numbers.
		System.out.print("Enter 10 numbers separated by a space: ");
		// Records user input into an array.
		for(int i = 0; i < numArray.length; i++) {
			numArray[i] = input.nextDouble();
		}
		System.out.println("The smallest number is: " + findSmallestValue(numArray));
	}	
	/** This method searches the array for the smallest value. Returns that value.*/
	public static double findSmallestValue(double[] numList) {
		double min = numList[0];
		for(int i = 0; i < numList.length; i++) {
			if (min > numList[i])
				min = numList[i];
		}
		return min;
	}
}