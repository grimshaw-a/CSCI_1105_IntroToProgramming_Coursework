// 01.31.20
// Author: Adam Grimshaw
// Intro to Programming

import java.util.Scanner;

class numberFormatter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int userNumber = input.nextInt();
		System.out.print("Enter a width for that number: ");
		int userWidth = input.nextInt();
		System.out.println(format(userNumber, userWidth));
	}
	public static String format(int number, int width){
		String numberString = "" + number;
		if (width <= numberString.length()) {
			return numberString;
		}
		else {
			int j = width - numberString.length();
			String zeros = "";
			for (int i = 0; i < j; i++){
				zeros = zeros + "0";
			}
			numberString = zeros + numberString;
			return numberString;
		}
	}
	
}
