import java.util.Scanner;

class B03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();
        while (times-->0) {
            int area = 0;

            int postsAmount = scanner.nextInt();
            while (postsAmount-->0) {
                int pos[] = new int[4];
                for (int i = 0; i < pos.length; ++i) {
                    pos[i] = scanner.nextInt();
                }

                area += (pos[2]-pos[0]) * (pos[3]-pos[1]);
            }

            System.out.println(area);
        }
    }
}