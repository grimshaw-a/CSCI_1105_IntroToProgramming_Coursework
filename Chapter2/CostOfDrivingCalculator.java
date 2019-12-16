// Author: Adam Grimshaw
// Date: December 16, 2019
// Course: CSCI 1105 Intro to Programming

import java.util.Scanner;

public class CostOfDrivingCalculator {

	public static void main(String[] args) {
		// create scanner
		Scanner input = new Scanner(System.in);
		
		// request user input
		System.out.print("Enter the driving distance: ");
		double drivingDistance = input.nextDouble();
		
		System.out.print("Enter the miles per gallon: ");
		double milesPerGallon = input.nextDouble();
		
		System.out.print("Enter price per gallon: ");
		double pricePerGallon = input.nextDouble();
		
		// calculate cost
		double costPerMile = (drivingDistance / milesPerGallon) * pricePerGallon;
		
		// display result
		System.out.print("The cost of driving is: $ " + costPerMile);
	}

}
