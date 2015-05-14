import java.util.Arrays;
import java.util.ArrayList;

class C01 {

	private static final int MIN = 1;
	private static final int MAX = 10;
	private static final int COMPARE_TO = 100;

	public static void main(String[] args) {

		int flag;
		// ArrayList<Integer> containsList = new ArrayList<Integer>();

		for (flag = 0; flag < ( 1 << (2*(MAX - MIN)) ); ++flag) {

			StringBuilder builder = new StringBuilder();

			for (int i = MIN; i <= MAX; ++i) {
				builder.append(String.valueOf(i) + ' ');

				if (i == MAX) break;

				char sign;
				switch (( flag >> (2 * (MAX - 1 - i)) ) & 0b11) {
					case 0: sign = '+'; break;
					case 1: sign = '-'; break;
					case 2: sign = '*'; break;
					case 3: sign = '/'; break;
					default: sign = ' '; break;
				}
				builder.append(String.valueOf(sign) + ' ');
			}

			if (equalsInt(builder.toString().trim(), COMPARE_TO)) {
				// containsList.add(flag);
				System.out.println(builder.toString() + " = " + COMPARE_TO);
			}

		}
	}

	// tring low coulping
	private static boolean equalsInt(String input, int compare) {

		ArrayList<String> explode = new ArrayList<String>(Arrays.asList(input.split(" ")));

		char signOrder[] = {'*', '/', '+', '-'};

		for (int i = 0; i < signOrder.length; ++i) {
			char sign = signOrder[i];
			while (true) {
				int index = explode.indexOf(String.valueOf(sign));
				if (index == -1) break;

				double value[] = {Double.parseDouble(explode.get(index - 1)), Double.parseDouble(explode.get(index + 1))};
				double result;
				switch (sign) {
					case '+': result = value[0] + value[1]; break;
					case '-': result = value[0] - value[1]; break;
					case '*': result = value[0] * value[1]; break;
					case '/': result = value[0] / value[1]; break;
					default: result = 0;
				}
				if (result % 1 != 0) return false;

				explode.set(index - 1, String.valueOf((int)result));
				explode.remove(index + 1);
				explode.remove(index);
			}
		}
		if (Integer.parseInt(explode.get(0)) == compare)
			return true;
		else
			return false;
	}
}