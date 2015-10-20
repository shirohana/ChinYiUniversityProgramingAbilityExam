import java.util.Scanner;
class A01 {

    private static final int[] DaysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            // value = {year, month, days};
            int value[] = new int[3];
            for (int i = 0; i < 3; ++i)
                value[i] = scanner.nextInt();

            int totalDays = value[2];

            boolean isLeap = value[0] % 400 == 0 || (value[0] % 4 == 0 && value[0] % 100 != 0);
            if(isLeap && value[1] > 2)
                ++totalDays;

            for (int i = 1; i < value[1]; ++i)
                totalDays += DaysInMonth[i-1];

            System.out.println(totalDays);

        }

    }
}