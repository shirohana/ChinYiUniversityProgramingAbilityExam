import java.util.Scanner;

class B04 {

	// It'll dumpMatrix everytime if DEBUG = true or not;
	private static final boolean DEBUG = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		if (DEBUG) System.out.println("In debug mode.");

		while (scanner.hasNextLine()) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			// following the question
			if (y > x) {
				System.out.println("0");
				continue;
			}

			// start from (0, 0)
			++x;
			++y;

			// x * y enough to store every status
			int width = x * y;
			int[][] matrix = new int[width][width];

			// Can move in 3 ways and can not go back
			for (int i = 0; i < y; ++i) {
				for (int j = 0; j < x; ++j) {
					// move UP
					if (i != 0) matrix[(i-1)*x+j][i*x+j] = 1;

					// move RIGHT
					if (j != 0) matrix[i*x+(j-1)][i*x+j] = 1;

					// move cross
					if (i != 0 && j != 0) matrix[(i-1)*x+(j-1)][i*x+j] = 1;
				}
			}

			int maxStep = (x - 1) + (y - 1);
			System.out.println(matrixPow(matrix, maxStep));

		}
	}

	private static int matrixPow(int[][] matrix, int times) {
		int[][] store = matrix;
		int passed = 1;
		if (DEBUG) {
			System.out.println("Original matrix: ");
			dumpMatrix(store);
		}

		int totalTimes = 0;
		while (times-->0) {
			store = matrixMultiple(store, matrix);
			totalTimes += store[0][store[0].length-1];
			if (DEBUG) {
				System.out.printf("----------[ %d time ]----------\n", passed++);
				dumpMatrix(store);
			}
		}
		return totalTimes;
	}

	private static int[][] matrixMultiple(int[][] matrix1, int[][] matrix2) {
		if (matrix1[0].length != matrix2.length) {
			return null;
		}

		int height = matrix1.length;
		int width = matrix2[0].length;
		int multipleTimes = matrix2.length;

		int[][] result = new int[height][width];

		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < height; ++j) {
				// result[i][j] = 0;
				for (int k = 0; k < multipleTimes; ++k) {
					result[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}
		return result;
	}

	private static void dumpMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				if (j != 0) {
					System.out.print(" ");
				}
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}