import java.util.Scanner;

class B08 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int input = scanner.nextInt();

			(new Hanoi()).printHanoi(input, 'a', 'b', 'c');
		}
	}
}

class Hanoi {
	private int times;
	public Hanoi() {
		this.times = 1;
	}

	public void printHanoi(int layer, char towerA, char towerB, char towerC) {
		if (layer == 1) {
			System.out.printf("第%d步:移動%d從塔%c到%c\n", times++, layer, towerA, towerC);
			return;
		}

		this.printHanoi(layer - 1, towerA, towerC, towerB);
		System.out.printf("第%d步:移動%d從塔%c到%c\n", times++, layer, towerA, towerC);
		this.printHanoi(layer - 1, towerB, towerA, towerC);
	}

	public void reset() {
		this.times = 1;
	}
}