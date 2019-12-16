// Author: Adam Grimshaw
// Date: December 16, 2019
// Course: CSCI 1105 Intro to Programming

import java.util.Scanner;

public class InterestCalculator {

	public static void main(String[] args) {
		final double INTEREST_RATE = 0.05;
		
		// create scanner
		Scanner input = new Scanner(System.in);
		
		// prompt user to enter monthly amount
		System.out.print("Enter monthly savings amount: ");
		double monthlyAmount = input.nextDouble();
		
		// calculate interest
		double monthlyInterestRate = INTEREST_RATE / 12;
		double firstMonthTotal = monthlyAmount * (1 + monthlyInterestRate);
		double secondMonthTotal = (firstMonthTotal + monthlyAmount) * (1 + monthlyInterestRate);
		double thirdMonthTotal = (secondMonthTotal + monthlyAmount) * (1 + monthlyInterestRate);
		double fourthMonthTotal = (thirdMonthTotal + monthlyAmount) * (1 + monthlyInterestRate);
		double fifthMonthTotal = (fourthMonthTotal + monthlyAmount) * (1 + monthlyInterestRate);
		double sixthMonthTotal = (fifthMonthTotal + monthlyAmount) * (1 + monthlyInterestRate);
		
		// display result
		System.out.println("After the sixth month, the account value is $" + sixthMonthTotal);
	}
}
