import java.util.Scanner;

class A04 {

	private static final int
		COIN_50_LIMIT = 100,
		COIN_20_LIMIT = 100,
		COIN_10_LIMIT = 500;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Maybe use Map is a better option
		int quota[] = {COIN_50_LIMIT, COIN_20_LIMIT, COIN_10_LIMIT};
		int currency[] = {50, 20, 10};

		while (scanner.hasNext()) {
			int input = scanner.nextInt();
			int trans[] = new int[3];

			int left = input;
			for (int i = 0; i < currency.length; ++i) {
				if (i < currency.length && currency[i] == input)
					continue;

				int amount = left / currency[i];
				if (amount > quota[i]) amount = quota[i];

				trans[i] = amount;
				quota[i] -= amount;
				left -= amount * currency[i];
			}

			for (int i = 0; i < 3; ++i) {
				System.out.println(trans[i]);
			}
		}
	}
}
