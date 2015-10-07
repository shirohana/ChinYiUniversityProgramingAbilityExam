import java.util.Scanner;

class A11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String value = input;

            input = scanner.nextLine();
            char replaceChars[] = {input.charAt(0), input.charAt(2)};

            System.out.println(value.replace(replaceChars[0], replaceChars[1]));
        }
    }
}