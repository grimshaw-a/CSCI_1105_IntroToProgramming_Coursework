class FindDivisibleNumbers {
	public static void main(String[] args) {
		int counter = 100;
		int printTracker = 0;
		
		while(counter <= 200){
			if(counter % 5 == 0 ^ counter % 6 == 0) {
				System.out.print(counter + " ");
				printTracker++;
				if (printTracker % 10 == 0)
					System.out.print("\n");
			}
			counter++;
		}
		
	}
}