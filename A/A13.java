import java.util.Scanner;

class A13 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();

			System.out.println(degree9(input));
		}
	}

	// return int because degree(X) > 2147483647 ? X > 2.3 billion digits
	private static int degree9(String input) {
		return degree9(input, 0);
	}
	private static int degree9(String input, int deg) {
		if (input.length() == 1 && Integer.parseInt(input) == 9) {
			return deg;
		}

		int sum = 0;
		for (int i = 0; i < input.length(); ++i) {
			sum += Integer.parseInt( String.valueOf(input.charAt(i)) );
		}

		if (sum % 9 != 0)
			return 0;
		return degree9(String.valueOf(sum), deg + 1);
	}
}