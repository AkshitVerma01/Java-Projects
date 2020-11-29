package Default;

public class Matrix {
	private int[][] matrixData;
	private int rowsNum;
	private int colsNum;

	public Matrix(int row, int col) {
		/*
		 * constructs a row-by-col matrix with all elements equal to 0; if row <= 0, the
		 * number of rows of the matrix is set to 3; likewise, if col <= 0 the number of
		 * columns of the matrix is set to 3.
		 */

		// Set a base matrix in case of matrix lengths that are not +ve
		if (row <= 0) {
			row = 3;
		}
		if (col <= 0) {
			col = 3;
		}

		// If provided with normal matrix length
		this.rowsNum = row;
		this.colsNum = col;
		this.matrixData = new int[rowsNum][colsNum];

		// Fill matrix with 0's
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				this.matrixData[i][j] = 0;
			}
		}
	}

	public Matrix(int[][] table) {

		/*
		 * constructs a matrix out of the two dimensional array table, with the same
		 * number of rows, columns, and the same element in each position as array
		 * table.
		 */

		// Get the lengths and assign memory for matrix
		this.rowsNum = table.length;
		this.colsNum = table[0].length;
		this.matrixData = new int[rowsNum][colsNum];

		// Fill array
		for (int i = 0; i < rowsNum; i++) {
			for (int j = 0; j < colsNum; j++) {
				this.matrixData[i][j] = table[i][j];
			}
		}

	}

	public int getElement(int i, int j) throws IndexOutOfBoundsException {
		/*
		 * returns the element on row i and column j of this matrix; it throws an
		 * exception (IndexOutOfBoundsException) if any of indexes i and j is not in the
		 * required range (rows and columns indexing starts with 0) the detail message
		 * of the exception should read: "Invalid indexes".
		 */

		// Check to see if its in the possible range and return
		if ((i >= 0 && i <= rowsNum) && (j >= 0 && j <= colsNum)) {
			return this.matrixData[i][j];

			// Throw new exception if not in range
		} else {
			throw new IndexOutOfBoundsException("Invalid indexes.");
		}
	}

	public boolean setElement(int x, int i, int j) throws IndexOutOfBoundsException {

		/* the detail message of the exception should read: "Invalid indexes" */

		// Check to see if its in the possible range and set value at that position to x
		if ((i >= 0 && i < rowsNum) && (j >= 0 && j < colsNum)) {
			this.matrixData[i][j] = x;
			return true;

			// Throw new exception if not in range
		} else {
			return false;
		}
	}

	public Matrix copy() {

		/* fix the code and write your implementation below */
		Matrix copy = new Matrix(this.rowsNum, this.colsNum);

		// Once the new instance is created, fill values
		for (int i = 0; i < this.rowsNum; i++) {
			for (int j = 0; j < this.colsNum; j++) {
				copy.matrixData[i][j] = this.matrixData[i][j];
			}
		}

		return copy;
	}

	public void addTo(Matrix m) throws ArithmeticException {

		/* the detail message of the exception should read: "Invalid operation". */

		// If the dimensions match, add to the current matrix
		if ((this.rowsNum == m.rowsNum) && (this.colsNum == m.colsNum)) {
			for (int i = 0; i < this.rowsNum; i++) {
				for (int j = 0; j < this.colsNum; j++) {
					this.matrixData[i][j] += m.matrixData[i][j];
				}
			}
		} else {
			throw new ArithmeticException("Invalid operation");
		}
	}

	public Matrix subMatrix(int i, int j) throws ArithmeticException {

		/* The exception detail message should read: "Submatrix not defined" */

		/* fix the code and write your implementation below */

		// If the dimensions are valid
		if ((i >= 0 && i < rowsNum) && (j >= 0 && j < colsNum)) {

			// Java starts counting from 0, so need to go an extra length
			Matrix subMat = new Matrix(i + 1, j + 1);

			// Fill the matrix as usual
			for (int k = 0; k <= i; k++) {
				for (int l = 0; l <= j; l++) {
					subMat.matrixData[k][l] = this.matrixData[k][l];
				}
			}
			return subMat;
		} else {
			throw new ArithmeticException("Submatrix not defined");
		}
	}

	// Basic getters
	public int getsizeofrows() {

		/* update below return */
		return this.rowsNum;
	}

	public int getsizeofcols() {

		/* update below return */
		return this.colsNum;
	}

	public boolean isUpperTr() {

		/* write your implementation here and update return accordingly */

		// Algorithm for determinant, stops at each diagonal using j < i
		for (int i = 1; i < this.rowsNum; i++) {
			for (int j = 0; j < i; j++) {
				if (this.matrixData[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static Matrix sum(Matrix[] matArray) throws ArithmeticException {

		// Get dimensions of the matArray
		int i = matArray[0].rowsNum;
		int j = matArray[0].colsNum;

		Matrix superMatrix = new Matrix(i, j);

		// Get length of the array
		int x = matArray.length;

		// If incorrect
		if (x <= 0) {
			throw new ArithmeticException("Invalid operation");

			// If there is length of one
		} else if (x == 1) {
			return matArray[0];

			// Fill array
		} else {
			for (int k = 0; k < x; k++) {
				superMatrix.addTo(matArray[k]);
			}
		}
		return superMatrix;
	}

//Printing
	public String toString() {
		String output = new String();

		for (int i = 0; i < this.rowsNum; i++) {
			for (int j = 0; j < this.colsNum; j++) {
				output += this.matrixData[i][j] + " ";
			}
			output += "\n";
		}

		return output;
	}

}