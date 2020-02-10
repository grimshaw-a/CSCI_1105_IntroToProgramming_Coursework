/**
 * <p>Created: 02.10.20</p>
 * @author Adam Grimshaw
 *
 */
public class MatrixCalculator {
	/** This is the main method. It defines two multidimensional arrays and calls the addMatrix method.*/
	public static void main(String[] args) {
		double aMatrix[][] = {{1, 2, 3}, {4, 4, 5}, {9, 8, 7}};
		double bMatrix[][] = {{9.2, 7.1, 3.5}, {8.2, 5.5, 1}, {21, 18, 13.7}};
		
		for (int i = 0; i < aMatrix.length; i++) {
			for (int j = 0; j < aMatrix[i].length; j++) {
				System.out.print(addMatrix(aMatrix, bMatrix)[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/** This method adds two, two dimensional arrays together and returns the result.*/
	public static double[][] addMatrix(double[][] a, double[][] b) {
		double [][] sumMatrix = new double[3][3];
		for (int i = 0; i < sumMatrix.length; i++) {
			for (int j = 0; j< sumMatrix[i].length; j++) {
				sumMatrix[i][j] = a[i][j] + b[i][j];
			}
		}
		return sumMatrix;
	}

}
