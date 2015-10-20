import java.util.Scanner;
class A02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            int value[] = new int[2];
            for (int i = 0; i < 2; ++i) {
                value[i] = scanner.nextInt();
            }

            int factor = maxFactor(value[0], value[1]);
            int multiple = value[0] * value[1] / factor;

            System.out.println(factor + " " + multiple);

        }

    }

    private static int maxFactor(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return maxFactor(b % a, a);
        }
    }
}