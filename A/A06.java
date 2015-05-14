import java.util.Scanner;

class A06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int times = scanner.nextInt();
		while (times-- > 0) {
			int weight[] = new int[2];

			for (int i = 0; i < weight.length; ++i) {
				weight[i] = scanner.nextInt();
			}

			if (weight[0] < 1 || weight[1] < 1) {
				System.out.println("輸入錯誤");
				continue;
			}

			int sum = 0;
			for (int i = weight[0]; i <= weight[1]; ++i) {
				sum += Math.pow(i, 2);
			}

			System.out.println(sum);
		}
	}
}