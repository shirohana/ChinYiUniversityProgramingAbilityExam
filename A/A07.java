import java.util.Scanner;

class A07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int num[] = new int[2];
			for (int i = 0; i < num.length; ++i) {
				num[i] = scanner.nextInt();
			}

			if (num[0] >= num[1]) {
				System.out.println("輸入錯誤");
				continue;
			}

			if (isFinite(num[0], num[1])) {
				System.out.println(getDecimal(num[0], num[1]));
				System.out.println("0");
				continue;
			}

			double decimal = getDecimal(num[0], num[1]);
			int circular = getCircular(decimal, num[1]);

			System.out.println("0." + circular);
			System.out.println(String.valueOf(circular).length());
		}
	}

	private static double getDecimal(int a, int b) {
		double result = 1.0 * a / b;
		return result - (int) result;
	}
	private static double getDecimal(double value) {
		return value - (int) value;
	}

	// I want 'max' because the circular part is for sure less than divisor
	private static int getCircular(double input, int max) {
		double value = input;
		for (int i = 0; i < max; ++i) {
			int before = (int) value;
			int length = String.valueOf(before).length();
			int after = (int) ( getDecimal(value) * Math.pow(10, length) );

			if (before == after) {
				return before;
			}
			value *= 10;
		}
		return 0;
	}

	// I didn't check if divisible because it's for sure input1 < input2
	// why needs a XD
	private static boolean isFinite(int a, int b) {
		if (b % 2 == 0 || b % 5 == 0)
			return true;
		return false;
	}
}