/**
*<p>This program reads an array, removes the duplicates, and prints out the new array.</p>
*<p>Created: 02.08.20</p>
*@author Adam Grimshaw
*/

import java.util.Scanner;

public class ProcessArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] numArray = new int[10];
		System.out.print("Enter 10 numbers seperated by a space: ");
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = input.nextInt();
		}
		int[] newArray = eliminateDuplicates(numArray);
		System.out.print("Array without duplicates: ");
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}
		
	}
	
	public static int[] eliminateDuplicates(int[] list) {
		java.util.Arrays.sort(list);
		int[] newArray = new int[10];
		boolean isDuplicate = false;
		int counter = 0;
		for (int i = 0; i < list.length;) {
			if (isDuplicate == false) {
				newArray[counter] = list[i];
				//System.out.println(newArray[counter]);
				if(i == list.length - 1) {
				break;
			}
				counter++;
			}
			i++;
			if (list[i] == list[i - 1]) {
				isDuplicate = true;
			}
			else {
				isDuplicate = false;
			}
		}
		System.out.println("The number of distinct numbers is " + (counter + 1 ));
		int[] returnArray = new int[counter + 1];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = newArray[i];
		}
		return returnArray;
	}


}