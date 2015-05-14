import java.util.Arrays;
import java.util.ArrayList;

class B02 {

	private static final int MIN = 1000;
	private static final int MAX = 9999;

	public static void main(String[] args) {

		for (int i = MIN; i <= MAX; ++i) {
			if (isNarcissus(i)) {
				System.out.println(i);
			}
		}

	}

	private static boolean isNarcissus(int input) {
		int sum = 0;
		String value = String.valueOf(input);

		for (int i = 0; i < value.length(); ++i) {
			int num = Integer.parseInt(value.substring(i, i + 1));
			sum += Math.pow(num, 4);
		}
/*
		// or this
		int digit[] = new int[]{
			input / 1000,
			(input % 1000) / 100,
			(input % 100) / 10,
			input % 10
		};
		for (int i = 0; i < digit.length; ++i) {
			sum += Math.pow(digit[i], 4);
		}
*/

		if (sum == input)
			return true;
		else
			return false;
	}
}