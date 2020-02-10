/**
*<p>Created: 02/08/20</p>
*@author Adam Grimshaw
*/

public class LockerExercise {
	public static void main(String[] args) {
		int[] lockers = new int[100];
		int[] students = new int[100];
		boolean[] open = new boolean[100];
		for (int i = 0; i < 100; i++) {
			lockers[i] = i + 1;
			students[i] = i + 1;
			open[i] = false;
		}
		for (int j = 0; j < 100; j++) {
			for (int i = j; i < 100; i++) {
				if (lockers[i] % students[j] == 0) {
					if(open[i] == false) {
						open[i] = true;
					}
					else {
						open[i] = false;
					}
				}
			}
		}
		System.out.print("The following lockers are open: ");
		for (int i = 0; i < 100; i++) {
			if(open[i]) {
				System.out.print(lockers[i] + " ");
			}
		}
	}
}