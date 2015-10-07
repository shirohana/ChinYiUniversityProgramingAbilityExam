import java.util.Scanner;
import java.math.BigInteger;

class B09 {

    private static final int RANGE_MIN = 20;
    private static final int RANGE_MAX = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int input = scanner.nextInt();
            if (input < RANGE_MIN && RANGE_MAX < input)
                continue;
            System.out.println(bigExclamation(input));
        }
    }
    private static BigInteger bigExclamation(int grade) {
        return bigExclamation(new BigInteger(String.valueOf(grade)), grade - 1);
    }
    private static BigInteger bigExclamation(BigInteger value, int grade) {
        if (grade <= 1)
            return value;
        return bigExclamation(value.multiply(new BigInteger(String.valueOf(grade))), grade - 1);
    }
}