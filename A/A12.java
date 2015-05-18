import java.util.Scanner;

class A12 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int amount = scanner.nextInt();

			int total = 0;
			int[] post = new int[amount];
			for (int i = 0; i < post.length; ++i) {
				post[i] = scanner.nextInt();
				total += post[i];
			}
			int average = (int) Math.round((double) total / amount);

			int distance = 0;
			for (int i = 0; i < post.length; ++i) {
				distance += Math.abs(post[i] - average);
			}

			System.out.println(distance);
		}
	}
}