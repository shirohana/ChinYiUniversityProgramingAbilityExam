import java.util.ArrayList;

class A08 {

    private static final int MAX = 10000;

    public static void main(String[] args) {
        for (int i = 2; i <= MAX; ++i) {
            if (isPerfect(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPerfect(int input) {
        ArrayList<Integer> factorList = new ArrayList<Integer>();

        for (int i = 1; i <= Math.floor(Math.sqrt(input)); ++i) {
            if (input % i == 0) {
                factorList.add(i);
            }
        }

        int sum = -input;
        for (Integer iter : factorList) {
            sum += iter + input / iter;
        }

        if (sum == input)
            return true;
        return false;
    }
}