import java.util.Scanner;

class B06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			int length = scanner.nextInt();
			int[][] input = new int[2][length];

			for (int i = 0; i < input.length; ++i) {
				for (int j = 0; j < length; ++j) {
					input[i][j] = scanner.nextInt();
				}
			}

			int[][] lcs = new int[length][length];
			for (int i = 0; i < length; ++i) {
				for (int j = 0; j < length; ++j) {
					if (input[0][i] == input[1][j]) {
						lcs[i][j] = (i == 0 || j == 0) ? 1 : lcs[i-1][j-1] + 1;
					} else {
						int x = (j == 0) ? 0 : lcs[i][j-1];
						int y = (i == 0) ? 0 : lcs[i-1][j];
						lcs[i][j] = Math.max(x, y);
					}
				}
			}

			System.out.println(lcs[length-1][length-1]);
		}
	}
}