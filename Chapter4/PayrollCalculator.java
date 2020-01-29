// 01.27.20
// Adam Grimshaw
// Intro to Programming
// Desription: This program creates a payroll stub based on user input.



import java.util.Scanner;

class PayrollCalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Prompt user to enter values.
		System.out.print("Enter employee's name: ");
		String empName = input.next();
		System.out.print("Enter number of hours worked: ");
		double hoursWorked = input.nextDouble();
		System.out.print("Enter hourly pay rate: ");
		double payRate = input.nextDouble();
		System.out.print("Enter federal tax withholding rate: ");
		double fedTax = input.nextDouble();
		System.out.print("Enter state tax withholding rate: ");
		double stateTax = input.nextDouble();
		System.out.println("");
		
		// Calculate tax witholding and net pay.
		if(fedTax + stateTax >= 1) {
			System.out.println("Invalid tax rate.");
		}
		else {
			double grossIncome = hoursWorked * payRate;
			double fedMoney = grossIncome * fedTax;
			double stateMoney = grossIncome * stateTax;
			double totalDeduction = fedMoney + stateMoney;
			double netPay = grossIncome - totalDeduction;
			
			// Print results.
			System.out.println("Employee Name: " + empName);
			System.out.println("Hours Worked: " + hoursWorked);
			System.out.printf("Pay Rate: $%.2f \n", (payRate * 100) / 100);
			System.out.printf("Gross Pay $%.2f \n", (grossIncome * 100) / 100);
			System.out.println("Deductions:");
			System.out.printf("\t Federal Withholding (%.1f%%): $%.2f\n", (fedTax * 100), ((fedMoney * 100) / 100));
			System.out.printf("\t State Withholding (%.1f%%): $%.2f\n", (stateTax * 100), ((stateMoney * 100) / 100));
			System.out.printf("\t Total Deduction: $%.2f\n", ((Math.rint(totalDeduction * 100) / 100)));
			System.out.printf("Net Pay: $%.2f", netPay);
		}
	}
}
