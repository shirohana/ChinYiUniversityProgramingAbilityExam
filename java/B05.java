import java.util.Scanner;

class B05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loops = Integer.parseInt(scanner.nextLine());

        while (loops-->0) {
            String input = scanner.nextLine();

            System.out.println(findPalindrome(input.toCharArray()));
        }
    }

    private static int findPalindrome(char[] input) {
        int[] letters = new int[26];

        for (char letter : input) {
            letters[letter - 'a'] += 1;
        }

        int total = layer(input.length / 2);

        boolean hasSingle = false;
        for (int amount : letters) {
            if (amount == 0) continue;

            if ((amount & 1) == 1) {
                if (hasSingle) return 0;

                hasSingle = true;

                if (amount == 1) continue;
            }

            total /= layer(amount / 2);
        }

        return total;
    }

    private static int layer(int level) {
        return level == 1 ? 1 : level * layer(level-1);
    }

}
