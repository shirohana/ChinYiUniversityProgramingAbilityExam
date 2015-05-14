import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

class A03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int input = scanner.nextInt();
			System.out.println(factor(input));
		}
	}

	private static String factor(int input) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		int last = input;
		for (int i = 2; i <= Math.ceil(Math.sqrt(input)); i += i > 2 ? 2 : 1) {
			while (last % i == 0) {
				last /= i;
				if (map.containsKey(i)) {
					map.put(i, map.get(i) + 1);
				} else {
					map.put(i, 1);
				}
			}
		}

		if (map.size() == 0)
			return String.valueOf(input) + "=" + String.valueOf(input);

		StringBuilder result = new StringBuilder(String.valueOf(input) + "=");

		boolean isFirst = true;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (isFirst) {
				isFirst = false;
			} else {
				result.append("*");
			}
			if (entry.getValue() == 1) {
				result.append(entry.getKey().toString());
			} else {
				result.append(entry.getKey().toString() + "^" + entry.getValue().toString());
			}
		}

		return result.toString();
	}
}