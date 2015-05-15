import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class B05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int loops = Integer.parseInt(scanner.nextLine());

		while (loops-->0) {
			String input = scanner.nextLine();

			System.out.println(fullSorting(input));
		}
	}

	private static int fullSorting(String input) {
		char split[] = input.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		// Split to HashMap
		for (char c : split) {
			int count = map.containsKey(c) ? map.get(c)+1 : 1;
			map.put(c, count);
		}

		int grade = 0;
		int single = 0;
		// check for palindrome
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			int half = entry.getValue() / 2;
			if (half == 0) {
				if (++single > 1) return 0;
				continue;
			}

			map.put(entry.getKey(), half);
			grade += half;
		}

		long total = exclamation(grade);
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			total /= exclamation(entry.getValue());
		}

		return (int) total;
	}

	private static long exclamation(int input) {
		if (input <= 1)
			return 1;
		return input * exclamation(input - 1);
	}

}