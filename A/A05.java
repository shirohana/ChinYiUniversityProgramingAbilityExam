import java.util.Scanner;

class A05 {

	// GOLDEN_NUMBER = 1.618033988749895;
	private static final double GOLDEN_NUMBER = (1 + Math.sqrt(5)) / 2;

	// use golden number is a smarter choice,
	// it's much faster than the other one.
	private static final boolean USE_GOLDEN_NUMBER = true;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int input = scanner.nextInt();
			if (input <= 0 || 50 <= input) {
				System.out.println("輸入錯誤");
				continue;
			}

			if (USE_GOLDEN_NUMBER) {
				System.out.println( (long)goldenNumber(input));
			} else {
				System.out.println(goldenSquare(input));
			}
		}
	}

	private static long goldenSquare(int amount) {
		if (amount == 1 || amount == 2) {
			return 1;
		} else {
			return goldenSquare(amount - 1) + goldenSquare(amount - 2);
		}
	}

	private static double goldenNumber(int amount) {
		if (amount == 1 || amount == 2) {
			return 1;
		} else {
			return Math.round(GOLDEN_NUMBER * goldenNumber(amount - 1));
		}
	}
}