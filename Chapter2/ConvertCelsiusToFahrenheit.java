// Author: Adam Grimshaw
// Date: December 16, 2019
// Course: CSCI 1105 Intro to Programming

import java.util.Scanner;

public class ConvertCelsiusToFahrenheit {

	public static void main(String[] args) {
		// create scanner
		Scanner input = new Scanner(System.in);
		
		// prompt user to enter degrees Celsius
		System.out.print("Enter degrees Celsius: ");
		double tempCelsius = input.nextDouble();
		
		// convert to Fahrenheit
		double tempFahrenheit = (9.0 / 5.0) * tempCelsius + 32;
		
		// display result
		System.out.print(tempCelsius + " degrees Celsius is " + tempFahrenheit + " degrees Fahrenheit.");
	}

}
