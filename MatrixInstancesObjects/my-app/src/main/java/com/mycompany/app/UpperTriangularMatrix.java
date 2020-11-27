package com.mycompany.app;

public class UpperTriangularMatrix {
	private int n;
	private int[] array;

	public UpperTriangularMatrix(int n) {

		// Fill with the condition
		if (n <= 0) {
			this.n = 1;
			array = new int[this.n];
		} else {
			this.n = n;
		}

		// Allocation using formula provided
		this.array = new int[this.n * (this.n + 1) / 2];

	}

	public UpperTriangularMatrix(Matrix upTriM) throws IllegalArgumentException {

		// Fill the efficient array with the non 0 elements
		if (upTriM.isUpperTr()) {
			this.n = upTriM.getsizeofrows();
			this.array = new int[this.n * (this.n + 1) / 2];

			int index = 0;
			for (int i = 0; i < upTriM.getsizeofrows(); i++) {
				for (int j = i; j < upTriM.getsizeofcols(); j++) {
					this.array[index] = upTriM.getElement(i, j);
					index++;
				}
			}
		} else {
			throw new IllegalArgumentException("Not an upper triangular Matrix");
		}
	}

	// Basic getter
	public int getDim() {

		/* write your implementation here and update return accordingly */
		return this.n;
	}

	public int getElement(int i, int j) throws IndexOutOfBoundsException {

		/* write your implementation here and update return accordingly */

		// If valid dimensions
		if (i < getDim() && j < getDim()) {
			if (i <= j) {

				// Get the element using the arithmetic representation, + j - i allows it to
				// find every element, without it, its the main diagonal
				return this.array[n * (n + 1) / 2 - ((n - i) * (n - i + 1)) / 2 + j - i];

				// If the row element is larger than the column, its a 0 element
			} else {
				return 0;
			}

			// If dimensions not valid
		} else {
			throw new IndexOutOfBoundsException("Invalid indexes");
		}
	}

	public void setElement(int x, int i, int j) throws IndexOutOfBoundsException, IllegalArgumentException {

		// There were too many conditions to keep track off therefore i did the if's
		// using the condition as the main point of view
		if (x != 0 && j > i) {
			throw new IllegalArgumentException("Incorrect argument");
		}
		if (i > getDim() || j > getDim()) {
			throw new IndexOutOfBoundsException("Invalid index");

			// If passed the conditions, set x to be the element that we need
		} else {
			this.array[n * (n + 1) / 2 - ((n - i) * (n - i + 1)) / 2 + j - i] = x;
		}
	}

	public Matrix fullMatrix() {

		Matrix full = new Matrix(this.n, this.n);

		// Basically a deep copy
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				full.setElement(getElement(i, j), i, j);
			}
		}

		return full;
	}

	// To print
	public String toString() {

		Matrix A = fullMatrix();

		return A.toString();

	}

	public int getDet() {

		int diag = 1;
		for (int i = 0; i < this.n; i++) {
			diag *= getElement(i, i);
		}
		return diag;
	}

	public double[] effSolve(double[] b) throws IllegalArgumentException {
		/* fix the following and write your implementation */
		double[] sol = new double[b.length];

		// Back substitution

		// Check determinant
		int diag = 1;
		for (int i = 0; i < this.n; i++) {
			diag *= this.array[n * (n + 1) / 2 - ((n - i) * (n - i + 1)) / 2];
		}

		// If non 0 determinant and dimensions match
		if (diag != 0 && this.n == b.length) {

			// Formula for back substitution using the arithmetic representation for getting
			// an element
			for (int i = this.n - 1; i >= 0; i--) {

				for (int j = i + 1; j < this.n; j++) {

					b[i] -= this.array[n * (n + 1) / 2 - ((n - i) * (n - i + 1)) / 2 + j - i] * sol[j];
				}

				sol[i] = b[i] / this.array[n * (n + 1) / 2 - ((n - i) * (n - i + 1)) / 2];
			}

			// Remaining checks
		} else if (diag == 0) {
			throw new IllegalArgumentException("The determinant of the matrix is 0");
		} else if (b.length != this.n) {
			throw new IllegalArgumentException("The dimension of the matrix is not defined for operation");
		}
		return sol;
	}
}