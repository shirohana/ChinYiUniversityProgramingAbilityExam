import java.util.Scanner;
import java.util.ArrayList;

class B10 {

	// maybe input may not over than PRIME_TABLE_LIMIT
	private static final int PRIME_TABLE_LIMIT = 50000;

	private static ArrayList<Integer> primeList;
	static {
		primeList = new ArrayList<Integer>();
		boolean[] isSieve = new boolean[PRIME_TABLE_LIMIT];

		// linear sieve
		for (int i = 2; i < PRIME_TABLE_LIMIT; ++i) {
			if (!isSieve[i]) primeList.add(i);

			for (int j = 0; i * primeList.get(j) < PRIME_TABLE_LIMIT; ++j) {
				isSieve[i * primeList.get(j)] = true;
				if (i % primeList.get(j) == 0) break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			int[] input = new int[2];
			for (int i = 0; i < input.length; ++i) {
				input[i] = scanner.nextInt();
			}

			ArrayList<Integer> result = primeInRange(input[0], input[1]);
			for (int i = 0; i < result.size(); ++i) {
				int reverse = reverse(result.get(i));
				if (reverse == result.get(i)) continue;
				if (isPrime(reverse)) {
					System.out.println(result.get(i));
				}
			}
		}
	}

	private static ArrayList<Integer> primeInRange(int min, int max) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (max < primeList.get(primeList.size() - 1))
		for (int i = 0; i < primeList.size(); ++i) {
			int prime = primeList.get(i);
			if (prime > max) break;
			if (min <= prime) result.add(prime);
		}
		return result;
	}

	private static boolean isPrime(int value) {
		// if value <= the largest prime in primeList
		if (value <= primeList.get(primeList.size() - 1)) {
			if (primeList.indexOf(value) == -1)
				return false;
			else
				return true;
		}

		if (Math.sqrt(value) <= primeList.get(primeList.size() - 1))
		for (int i = 0; i < primeList.size(); ++i) {
			if (value % primeList.get(i) == 0) return false;
		}
		// maybe input may not over than PRIME_TABLE_LIMIT ^ 2
		return true;
	}

	private static int reverse(int value) {
		// prime must be positive
		// boolean isNegative = false;
		// if (String.valueOf(value).charAt(0) == '-') isNegative = true;

		String numeric = String.valueOf(Math.abs(value));

		StringBuilder reverse = new StringBuilder();
		for (int i = numeric.length() - 1; i > -1; --i) {
			reverse.append(numeric.charAt(i));
		}
		// if (isNegative) reverse.insert(0, "-");

		return Integer.parseInt(reverse.toString());
	}
}