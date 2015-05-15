import java.util.Scanner;

class A10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int input[] = new int[20];
			for (int i = 0; i < input.length; ++i) {
				input[i] = scanner.nextInt();
			}

			int search = scanner.nextInt();

			int index = -1;
			for (int i = 0; i < input.length; ++i) {
				if (input[i] == search) {
					index = i;
					System.out.println(i);
				}
			}

			if (index == -1) {
				System.out.println("-1");
			}
		}
	}
}