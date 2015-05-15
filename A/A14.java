import java.util.Scanner;

class A14 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			int length = scanner.nextInt();
			int inputArray[] = new int[length];
			for (int i = 0; i < length; ++i) {
				inputArray[i] = scanner.nextInt();
			}

			if (length % 2 == 1) {
				System.out.println(inputArray[length / 2 + 1] + " " + 1);
			} else {
				System.out.println(inputArray[length / 2 - 1] + " " + 2);
			}
		}
	}
}