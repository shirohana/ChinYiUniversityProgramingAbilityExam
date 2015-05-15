import java.util.Scanner;

class A09 {

	private static final int RANGE_MIN = 1;
	private static final int RANGE_MAX = 1000;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int range[] = {RANGE_MIN, RANGE_MAX};

		int answer = scanner.nextInt();
		System.out.println(range[0] + "~" + range[1]);

		while (scanner.hasNext()) {
			int input = scanner.nextInt();

			if (input == answer) {
				System.out.println("BINGO");
				break;
			}

			if (range[0] < input && input < range[1]) {
				if (input > answer) {
					range[1] = input - 1;
				} else {
					range[0] = input + 1;
				}
			}

			System.out.println(range[0] + "~" + range[1]);
		}
	}
}